package Ss12_Java_collection_Framework.practice.model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    public static void main(String[] args) {
        Map<Integer,String> hashMap = new HashMap<>();
        hashMap.put(19,"duc");
        hashMap.put(20,"duc1");
        hashMap.put(21,"duc2");
        hashMap.put(22,"duc3");
        hashMap.put(23,"duc4");
        System.out.println(" hien thi cac muc trong hash Map ");
        System.out.println(hashMap+ " \n");
Map< Integer,String> treeMap = new TreeMap<>(hashMap);
        System.out.println(" hien thic cac muc nhap theo thu tu tang dan ");
        System.out.println(treeMap);
        Map<Integer,String> linked = new LinkedHashMap<>();
        linked.put(1,"a");
        linked.put(2,"a2");
        linked.put(3,"a3");
        linked.put(4,"a4");
        linked.put(5,"a5");
        System.out.println(" ten cua "+" so thu 5 " + linked.get(5));

    }

}