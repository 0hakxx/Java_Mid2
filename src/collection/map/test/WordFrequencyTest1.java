package collection.map.test;
import java.util.HashMap;
import java.util.Map;

public class WordFrequencyTest1 {
    public static void main(String[] args) {
        String text = "orange banana apple apple banana apple";

        //문자열을 공백(" ") 기준으로 분리하여 단어 배열로 만듦
        String[] words = text.split(" ");


        Map<String, Integer> map = new HashMap<>();

        //단어 배열을 순회하며 각 단어의 빈도수를 Map에 저장
        for (String word : words) {
            // 현재 단어가 Map에 이미 있는지 확인
            Integer count = map.get(word); // 없으면 null 반환
            if(count == null) {
                // 단어가 처음 등장하면 count를 0으로 초기화
                count = 0;
            }
            // 등장 횟수 증가
            count++;
            // Map에 (단어, 등장횟수) 저장 (이미 있으면 값이 갱신됨)
            map.put(word, count);
        }
        System.out.println(map);
    }
}
