package collection.utils;

import java.util.*;

public class EmptyListMain {

    public static void main(String[] args) {
        // 빈 가변 리스트 생성
        List<Integer> list1 = new ArrayList<>(); // ArrayList로 빈 리스트 생성
        List<Integer> list2 = new LinkedList<>(); // LinkedList로 빈 리스트 생성

        // 빈 불변 리스트 생성
        List<Integer> list3 = Collections.emptyList(); // Java 5부터 사용 가능: 수정 불가능한 빈 리스트
        List<Integer> list4 = List.of(); // Java 9부터 사용 가능: 수정 불가능한 빈 리스트
        // 각 리스트의 클래스 정보 출력
        System.out.println("list3 = " + list3.getClass()); // 클래스 정보 출력
        System.out.println("list4 = " + list4.getClass()); // 클래스 정보 출력

        // 배열 생성 및 초기화
        Integer[] arr = {1, 2, 3, 4, 5};
        // 배열을 List로 변환 (Arrays.asList)
        List<Integer> arrList = Arrays.asList(arr);
        // List의 첫 번째 요소 변경
        arrList.set(0, 100);
        // Arrays.asList로 새로운 List 객체를 생성하지만, 이 List는 원본 배열의 데이터를 복사하는 대신, 원본 배열을 직접 참조
        // 하여 배열과 연결되어 있기 때문에, List의 내용을 변경하면 원본 배열도 함께 변경됨

        System.out.println("arr = " + Arrays.toString(arr)); // 배열 내용 출력
        System.out.println("arrList = " + arrList); // List 내용 출력


    }
}
