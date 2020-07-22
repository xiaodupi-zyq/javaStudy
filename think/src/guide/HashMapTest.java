package guide;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 23:01 2020/6/30
 * @Modified By:
 */
public class HashMapTest {
    public static void main(String[] args) {
        // 创建并赋值 HashMap
        Map<Integer, String> map = new HashMap();
        map.put(1, "Java");
        map.put(2, "JDK");
        map.put(3, "Spring Framework");
        map.put(4, "MyBatis framework");
        map.put(5, "Java中文社群");

        Iterator<Map.Entry<Integer,String>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer,String> entry = iterator.next();
            System.out.print(entry.getKey() + " ");
            System.out.print(entry.getValue() + " ");
        }
        System.out.println();
        Iterator<Integer> iterator1 = map.keySet().iterator();
        while(iterator1.hasNext()){
            Integer key = iterator1.next();
            System.out.print(key + " ");
            System.out.print(map.get(key) + " ");
        }
        System.out.println();
        for(Map.Entry<Integer,String> m : map.entrySet()){
            System.out.print(m.getKey() + " ");
            System.out.print(m.getValue() + " ");
        }
        System.out.println();
        for(Integer i : map.keySet()){
            System.out.print(i + " ");
            System.out.print(map.get(i) + " ");
        }
        System.out.println();
        map.forEach((key,value) -> {
            System.out.print(key + " ");
            System.out.print(value + " ");
        });
        System.out.println();
        map.entrySet().stream().forEach((entry) -> {
            System.out.print(entry.getKey() + " ");
            System.out.print(entry.getValue() + " ");
        });
        System.out.println();
        map.entrySet().parallelStream().forEach((entry) -> {
            System.out.print(entry.getKey() + " ");
            System.out.print(entry.getValue() + " ");
        });
    }
}
