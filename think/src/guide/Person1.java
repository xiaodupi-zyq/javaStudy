package guide;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 20:54 2020/6/30
 * @Modified By:
 */
public class Person1 {
    private Integer age;
    public Person1(Integer age){
        this.age = age;
    }
    public Integer getAge(){
        return age;
    }
    public static void main(String[] args){
        TreeMap<Person1,String> treeMap = new TreeMap<>(new Comparator<Person1>() {
            @Override
            public int compare(Person1 o1, Person1 o2) {
                int num = o1.getAge() - o2.getAge();
                return Integer.compare(num,0);
            }
        });
        treeMap.put(new Person1(3), "person1");
        treeMap.put(new Person1(18), "person2");
        treeMap.put(new Person1(35), "person3");
        treeMap.put(new Person1(16), "person4");
        treeMap.entrySet().stream().forEach(personStringEntry -> {
            System.out.println(personStringEntry.getValue());
        });
    }
}
