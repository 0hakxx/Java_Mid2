package collection.map;

import java.util.*;

public class JavaMapMain {

    public static void main(String[] args) {
        run(new HashMap<>());
        run(new LinkedHashMap<>());
        run(new TreeMap<>());
    }

    private static void run(Map<String, Integer> map) {
        System.out.println(map.getClass());
        map.put("C", 10);
        map.put("B", 20);
        map.put("A", 30);
        map.put("1", 40);
        map.put("2", 50);

        // Map 객체에서 모든 키를 가져와 Set 형태로 저장
        // keySet() 메서드는 Map에 포함된 모든 키를 Set 컬렉션으로 반환합니다.
        // 반환된 Set은 중복되지 않는 키들의 집합입니다.
        Set<String> keySet = map.keySet();


        // keySet에 대한 Iterator 생성
        Iterator<String> iterator = keySet.iterator();
        // Iterator는 컬렉션(여기서는 keySet)을 순회하기 위한 객체입니다.
        // keySet.iterator()를 호출하면 keySet의 요소를 순차적으로 접근할 수 있는 Iterator가 반환됩니다.
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(key);
            System.out.print(key + "=" + map.get(key) + " ");
        }
        System.out.println();




    }
}
