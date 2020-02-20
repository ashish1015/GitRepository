
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DuplicateMap<K, V> {

    private Map<K, ArrayList<V>> m = new HashMap<>();

    public void put(K k, V v) {
        if (m.containsKey(k)) {
            m.get(k).add(v);
        } else {
            ArrayList<V> arr = new ArrayList<>();
            arr.add(v);
            m.put(k, arr);
        }
    }

     public ArrayList<V> get(K k) {
        return m.get(k);
    }

    public V get(K k, int index) {
        return m.get(k).size()-1 < index ? null : m.get(k).get(index);
    }
    
    public static void main(String[] args) {
        DuplicateMap<String,String> dm=new DuplicateMap<>();
        dm.put("1", "one");
        dm.put("1", "not one");
        dm.put("1", "surely not one");
        System.out.println(dm.get("1"));
        System.out.println(dm.get("1",1));
        System.out.println(dm.get("1", 5));
    }
}

