package collection.map.test;

import java.util.HashMap;
import java.util.Map;

public class ArrayToMapTest {
    public static void main(String[] args) {
        String[][] productArr = {{"Java", "10000"}, {"Spring", "20000"},
                {"JPA", "30000"}};
        // 주어진 배열로부터 Map 생성 - 코드 작성
        // Map의 모든 데이터 출력  - 코드 작성
        Map<String, Integer> map = new HashMap<>();
        map.put("Java", 10000);
        map.put("Spring", 20000);
        map.put("JPA", 30000);

        for (String s : map.keySet()) {
            System.out.println("제품 : " + s + ", 가격 : " + map.get(s));
        }
    }
}
