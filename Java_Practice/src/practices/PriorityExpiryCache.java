package practices;
import java.util.*;
import java.io.*;

public class PriorityExpiryCache<K, V> {
    // Define the data structures
    private final LinkedHashMap<K, CacheEntry<K, V>> cache;
    private final PriorityQueue<CacheEntry<K, V>> expiryQueue;
    private final HashMap<K, Integer> priorityMap;
    private final int maxCapacity;

    public PriorityExpiryCache(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.cache = new LinkedHashMap<>(maxCapacity, 0.75f, true);
        this.expiryQueue = new PriorityQueue<>(Comparator.comparingLong(CacheEntry::getExpiryTime));
        this.priorityMap = new HashMap<>();
    }

    // CacheEntry class
    private static class CacheEntry<K, V> {
        private final K key;
        private final V value;
        private final long expiryTime;

        public CacheEntry(K key, V value, long expiryTime) {
            this.key = key;
            this.value = value;
            this.expiryTime = expiryTime;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public long getExpiryTime() {
            return expiryTime;
        }
    }

    // Get operation
    public synchronized V get(K key) {
        CacheEntry<K, V> entry = cache.get(key);
        if (entry == null || isExpired(entry)) {
            return null;
        }
        return entry.getValue();
    }

    // Put operation
    public synchronized void put(K key, V value, long expiryTime, int priority) {
        if (cache.size() >= maxCapacity) {
            evictEntries();
        }
        CacheEntry<K, V> entry = new CacheEntry<>(key, value, expiryTime);
        cache.put(key, entry);
        expiryQueue.add(entry);
        priorityMap.put(key, priority) ;
    }

    // Remove operation
    public synchronized void remove(K key) {
        CacheEntry<K, V> entry = cache.remove(key);
        if (entry != null) {
            expiryQueue.remove(entry);
            priorityMap.remove(key);
        }
    }

    // Eviction strategies
    private void evictEntries() {
        while (!expiryQueue.isEmpty()) {
            CacheEntry<K, V> entry = expiryQueue.poll();
            if (entry != null && isExpired(entry)) {
                remove(entry.getKey());
            } else {
                break;
            }
        }

        if (cache.size() >= maxCapacity) {
            Iterator<Map.Entry<K, CacheEntry<K, V>>> iterator = cache.entrySet().iterator();
            while (iterator.hasNext() && cache.size() > maxCapacity * 0.75) {
                K key = iterator.next().getKey();
                if (priorityMap.getOrDefault(key, 0) == 0) {
                    iterator.remove();
                }
            }
        }
    }

    private boolean isExpired(CacheEntry<K, V> entry) {
        return System.currentTimeMillis() > entry.getExpiryTime();
    }

    public synchronized int size() {
        return cache.size();
    }
}
