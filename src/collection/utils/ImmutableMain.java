package collection.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ImmutableMain {

    public static void main(String[] args) {
        // 1. 불변 리스트 생성 (Java 9 이상, List.of() 사용)
        //    이 리스트는 요소를 추가, 삭제, 변경할 수 없다.
        List<Integer> list = List.of(1, 2, 3);

        // 2. 가변 리스트 생성
        //    불변 리스트를 기반으로 새로운 ArrayList를 만들어 가변 리스트로 변환
        ArrayList<Integer> mutableList = new ArrayList<>(list); // 복사 생성
        mutableList.add(4); // 요소 추가 (가변이므로 가능)
        System.out.println("mutableList = " + mutableList); // [1, 2, 3, 4]
        System.out.println("mutableList class = " + mutableList.getClass()); // ArrayList 출력

        // 3. 다시 불변 리스트로 전환
        //    Collections.unmodifiableList()를 사용하여, 기존 리스트를 '읽기 전용' 래퍼로 감싼다.
        //    unmodifiableList는 내부적으로 mutableList를 참조하지만, 외부에서 add/remove 등 수정 불가
        List<Integer> unmodifiableList = Collections.unmodifiableList(mutableList);
        System.out.println("unmodifiableList class = " + unmodifiableList.getClass()); // 래퍼 클래스명 출력

        // 4. 불변 리스트에 요소 추가 시도 (예외 발생)
        //    아래 코드의 주석을 해제하면 java.lang.UnsupportedOperationException이 발생한다.
        //    unmodifiableList.add(5);

        // 참고: unmodifiableList는 외부에서 add/remove 등 변경이 불가능하지만,
        //      내부적으로 참조하는 mutableList가 변경되면 unmodifiableList의 내용도 함께 변경된다.
        //      완전히 안전한 불변 리스트를 원한다면, List.of() 등으로 생성해야 한다.
    }
}
