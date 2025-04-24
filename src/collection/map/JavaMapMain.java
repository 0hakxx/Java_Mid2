package collection.map;

import java.util.*;

public class JavaMapMain {

    public static void main(String[] args) {
        // run() 메서드를 각각 다른 Map 구현체로 3번 호출
        // HashMap : 순서 보장 X
        // LinkedHashMap : 입력(put) 순서 보장
        // TreeMap : key의 오름차순(정렬) 순서 보장
        run(new HashMap<>());        // HashMap 테스트
        run(new LinkedHashMap<>());  // LinkedHashMap 테스트
        run(new TreeMap<>());        // TreeMap 테스트
    }

    /**
     * 다양한 Map 구현체의 key 순서 특성을 확인하는 메서드
     */
    private static void run(Map<String, Integer> map) {
        // 현재 사용 중인 Map의 클래스 이름 출력
        System.out.println("map = " + map.getClass());

        // Map에 데이터 추가
        // put() 순서: "C" → "B" → "A" → "1" → "2"
        map.put("C", 10);
        map.put("B", 20);
        map.put("A", 30);
        map.put("1", 40);
        map.put("2", 50);

        // keySet()을 통해 모든 key를 Set으로 반환
        Set<String> keySet = map.keySet();

        // keySet의 반복자(Iterator) 생성
        Iterator<String> iterator = keySet.iterator();

        // Iterator를 사용하여 key와 value를 순서대로 출력
        // HashMap: 출력 순서가 put() 순서와 다를 수 있음 (무작위)
        // LinkedHashMap: put()한 순서대로 출력됨
        // TreeMap: key의 오름차순(문자열 정렬)으로 출력됨 ("1", "2", "A", "B", "C")
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.print(key + "=" + map.get(key) + " ");
        }
        System.out.println(); // 줄바꿈
    }
}
