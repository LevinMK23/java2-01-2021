package lesson3;

import java.util.List;
import java.util.TreeMap;

public class Task2 {
    public static void main(String[] args) {
        String src = "asfa a jsfhjk asfgjag sfjf gkj gfaj asf f f f f  a a  a";
        String[] data = src.split(" +");
        TreeMap<String, Integer> map = new TreeMap<>();
        for (String word : data) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        System.out.println(map);
    }
}
