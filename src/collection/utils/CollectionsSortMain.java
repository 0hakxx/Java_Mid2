package collection.utils;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionsSortMain {

    public static void main(String[] args) {
        // 정수를 저장할 ArrayList 생성
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1); // 1 추가
        list.add(2); // 2 추가
        list.add(3); // 3 추가
        list.add(4); // 4 추가
        list.add(5); // 5 추가

        // 리스트에서 가장 큰 값 찾기
        Integer max = Collections.max(list);
        // 리스트에서 가장 작은 값 찾기
        Integer min = Collections.min(list);

        // 최대값 출력
        System.out.println("max = " + max);
        // 최소값 출력
        System.out.println("min = " + min);

        // 현재 리스트 상태 출력 (정렬된 상태)
        System.out.println("list = " + list);

        // 리스트의 요소들을 무작위로 섞음 (shuffle)
        Collections.shuffle(list);
        // 섞인 리스트 출력
        System.out.println("shuffle list = " + list);

        // 리스트를 오름차순 정렬
        Collections.sort(list);
        // 정렬된 리스트 출력
        System.out.println("sort list = " + list);

        // 리스트의 순서를 반대로 뒤집음 (내림차순이 됨)
        Collections.reverse(list);
        // 뒤집힌 리스트 출력
        System.out.println("reverse list = " + list);
    }
}
