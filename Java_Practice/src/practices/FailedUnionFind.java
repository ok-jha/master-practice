package practices;
import java.io.*;
import java.util.*;

public class FailedUnionFind {
    HashMap<Integer,Integer> map = new HashMap<>();

    public boolean isConnected(int p, int q){
        if (map.containsKey(p) && map.get(p).equals(q))
            return true;
        else if(map.containsKey(q) && map.get(q).equals(p))
            return true;
        return false;
    }

    public void union(int p,int q){
        if(!map.containsKey(p)){
            map.put(p,q);
        }
        else if (map.containsKey(p)){
            map.put(q,p);
        }
        int k = p;
        int v = q;
        while(map.containsValue(k) || map.containsKey(v)){
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue().equals(k)) {
                    k = entry.getKey();
                }
                else if(entry.getKey().equals(v)){
                    v = entry.getValue();
                }
            }
            map.put(v,k);
        }

    }
}
