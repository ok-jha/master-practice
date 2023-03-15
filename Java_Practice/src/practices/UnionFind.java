package practices;
import java.util.*;
import java.lang.*;

public class UnionFind {
    HashMap<Integer,Integer> map = new HashMap<>();
    HashMap<Integer, Boolean> takenValue = new HashMap<Integer, Boolean>() {{
        put(0,false);
        put(1,false);
        put(2,false);
        put(3,false);
        put(4,false);
        put(5,false);
        put(6,false);
        put(7,false);
        put(8,false);
        put(9,false);
    }};

    public boolean isConnected(int p, int q){
        if(map.isEmpty())
            return false;
        if (map.get(p) == map.get(q))
            return true;
        return false;
    }

    public void union(int p,int q) {
        Random rand = new Random();
        int randomNumber = rand.nextInt(10);

        if (!map.containsKey(p) && !map.containsKey(q)) {
            if(!takenValue.get(randomNumber)){
                map.put(p, randomNumber);
                map.put(q, randomNumber);
                takenValue.put(randomNumber,true);
            }
        }
        else if (!map.containsKey(p) && map.containsKey(q)){
            map.put(p,map.get(q));
        }
        else if (!map.containsKey(q) && map.containsKey(p)){
            map.put(q,map.get(p));
        }
    }
}
