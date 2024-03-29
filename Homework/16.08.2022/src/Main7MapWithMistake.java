/* Дана map<Character, Set<String>> где значение - список строк, начинающихся на букву, которая является ключом.
 Увы исходный map coдержит ошибки.
 Несколько строк записаны в неправильные ключи. Написать метод,который скорректирует  map
 */


import java.security.Key;
import java.util.*;

public class Main7MapWithMistake {
    public static void main(String[] args) {
        Map <Character, Set<String>> map = new HashMap<>();
        map.put('a', new HashSet<>(Set.of("assa", "abba", "day")));
        map.put('c', new HashSet<>(Set.of("cssa", "abba", "current")));
        map.put('f', new HashSet<>(Set.of("fut", "football", "assa")));
        mapCheckAndCorrect(map);
        System.out.println(map);
    }

    public static void mapCheckAndCorrect(Map<Character, Set<String>> map){
        Set<Character> keys = map.keySet();
        for (Character key:keys) {
            Set<String> values = map.get(key);
            Iterator<String> iterator = values.iterator();
            while (iterator.hasNext()){
                String value = iterator.next();
                if(value.charAt(0) != key){
                    addValue(map,value);
                    iterator.remove();
                }
            }
        }
    }

    private static void addValue(Map<Character, Set<String>> map, String value) {
        if (value!=null && !value.isEmpty()) {
            Character key = value.charAt(0);
            Set<String> set = map.getOrDefault(key, new HashSet<>());
            set.add(value);
            map.put(key, set);
        }
    }
}
