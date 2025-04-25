package collection.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SyncMain {

    public static void main(String[] args) {
        // ArrayList 생성 (가변 리스트)
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1); // 요소 1 추가
        list.add(2); // 요소 2 추가
        list.add(3); // 요소 3 추가

        // ArrayList의 클래스 정보 출력
        System.out.println("list class = " + list.getClass());

        // Collections.synchronizedList()를 사용하여 동기화된 리스트 생성
        // 여러 스레드에서 동시에 접근해도 안전하도록 동기화 지원
        List<Integer> synchronizedList = Collections.synchronizedList(list);

        // 동기화된 리스트의 클래스 정보 출력
        System.out.println("synchronizedList class = " + synchronizedList.getClass());
    }
}
