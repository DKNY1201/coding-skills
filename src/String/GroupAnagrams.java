package String;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Bi on 7/11/19.
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,0,0,5};
        System.out.println(Arrays.toString(arr));

        Person p2 = new Person("quy tran", 29);
        Person p1 = new Person("kim long", 29);
        Person p3 = new Person("quy", 39);
        Person p4 = new Person("tran", 35);
        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);

        list.sort((o1, o2) -> {
            if (o1.age != o2.age) {
                return o1.age - o2.age;
            } else {
                return o1.name.compareTo(o2.name);
            }
        });

        for (Person p: list) {
            System.out.println(p);
        }
    }
}

class Person {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", age: " + age;
    }
}
