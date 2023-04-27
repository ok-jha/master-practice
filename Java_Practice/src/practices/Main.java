package practices;

public class Main {

    public static void main(String[] args) {
        PriorityExpiryCache<String, String> cache = new PriorityExpiryCache<>(3);

        cache.put("key1", "value1", System.currentTimeMillis() + 5000, 1);
        cache.put("key2", "value2", System.currentTimeMillis() + 10000, 0);
        cache.put("key3", "value3", System.currentTimeMillis() + 15000, 0);

        System.out.println(cache.get("key1")); // Output: value1
        System.out.println(cache.get("key2")); // Output: value2
        System.out.println(cache.get("key3")); // Output: value3
        System.out.println(cache);
        System.out.println("Cache size: " + cache.size());

        cache.put("key4", "value4", System.currentTimeMillis() + 60000, 0);

        /*try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        System.out.println(cache.get("key1")); // Output: null (expired)
        System.out.println(cache.get("key2")); // Output: value2 (priority)
        System.out.println(cache.get("key3")); // Output: value3
        System.out.println(cache.get("key4"));
        System.out.println("Cache size: " + cache.size());
    }

}
