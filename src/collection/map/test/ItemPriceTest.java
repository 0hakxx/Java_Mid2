package collection.map.test;
import java.util.*;

public class ItemPriceTest {
    public static void main(String[] args) {
        // 1. 과일 이름(String)을 key, 가격(Integer)을 value로 하는 Map 생성
        Map<String, Integer> map = new HashMap<>();
        map.put("사과", 500);
        map.put("바나나", 500);
        map.put("망고", 1000);
        map.put("딸기", 1000);

        // 2. 가격이 1000인 과일의 이름(key)을 저장할 리스트 생성
        List<String> list = new ArrayList<>();

        // 3. Map의 entrySet()을 사용하여 모든 key-value 쌍을 순회
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            // entry.getValue()로 현재 과일의 가격을 가져옴
            // 가격이 1000이면
            if (entry.getValue().equals(1000)) {
                // 해당 과일 이름(key)을 리스트에 추가
                list.add(entry.getKey());
            }
        }

        // 4. 조건을 만족하는 모든 과일 이름이 담긴 리스트를 출력
        // 결과: [망고, 딸기]
        System.out.println(list);
    }
}
