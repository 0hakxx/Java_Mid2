package collection.map;

import java.util.*;

public class MapMain1 {

    public static void main(String[] args) {
        // Map 선언 및 생성: 학생 이름(String)을 key로, 점수(Integer)를 value로 저장
        Map<String, Integer> studentMap = new HashMap<>();

        // 학생 성적 데이터 추가 (put 메서드 사용)
        studentMap.put("studentA", 90);
        studentMap.put("studentB", 80);
        studentMap.put("studentC", 80);
        studentMap.put("studentD", 100);
        // 현재 Map의 모든 key-value 쌍 출력
        System.out.println(studentMap);

        // 특정 학생("studentD")의 점수 조회 (get 메서드 사용)
        Integer result = studentMap.get("studentD");
        System.out.println("result = " + result);

        // keySet()을 활용하여 모든 key(학생 이름)와 해당 value(점수) 출력
        System.out.println("KeySet 활용");
        // KeySet을 Set으로 반환될까?? Map의 Key는 순서를 보장하지 않고, 중복이 되지 않는다 ==> Set 자료구조와 같다!
        Set<String> keySet = studentMap.keySet(); // key만 모은 Set 반환
        for (String key : keySet) {
            Integer value = studentMap.get(key); // key로 value 조회
            System.out.println("key=" + key + ", value=" + value);
        }

        // entrySet()을 활용하여 key와 value를 한 번에 출력
        System.out.println("entrySet 활용");
        Set<Map.Entry<String, Integer>> entries = studentMap.entrySet(); // key-value 쌍을 Entry로 모은 Set 반환
        for (Map.Entry<String, Integer> entry : entries) {
            String key = entry.getKey();      // Entry에서 key 추출
            Integer value = entry.getValue(); // Entry에서 value 추출
            System.out.println("key=" + key + ", value=" + value);
        }

        // values()를 활용하여 모든 value(점수)만 출력
        System.out.println("values 활용");
        // value는 중복이 될 수 있으므로 Set은 못 쓰고, 또 순서는 보장되지 않으므로 list는 쓰기도 애매하여 list의 상위 타입인 Collection으로 반환한다.
        Collection<Integer> values = studentMap.values();
        for (Integer value : values) {
            System.out.println("value = " + value);
        }

    }
}
