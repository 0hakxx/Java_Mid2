package collection.compare;

import java.util.*;

// List는 순서가 있는 자료구조이므로, 정렬을 사용할 수 있다.
public class SortMain4 {

    public static void main(String[] args) {
        // MyUser 객체 3개 생성 (이름과 나이 정보 포함)
        MyUser myUser1 = new MyUser("a", 30);
        MyUser myUser2 = new MyUser("b", 20);
        MyUser myUser3 = new MyUser("c", 10);

        // MyUser 객체를 저장할 LinkedList 생성
        List<MyUser> list = new LinkedList<>();
        list.add(myUser1); // 첫 번째 유저 추가
        list.add(myUser2); // 두 번째 유저 추가
        list.add(myUser3); // 세 번째 유저 추가

        System.out.println("기본 데이터");
        // 리스트의 현재 상태 출력 (입력 순서대로 출력)
        System.out.println(list);

        System.out.println("Comparable 기본 정렬");
        // 정렬: MyUser 클래스가 Comparable을 구현했다면, compareTo() 기준으로 정렬
        // sort(null)은 기본 정렬(Comparable 기준) 수행
        list.sort(null);
        // Collections.sort(list); // 위와 동일한 기능
        System.out.println(list); // 정렬된 결과 출력

        System.out.println("IdComparator 정렬");
        // 정렬: IdComparator 기준으로 정렬 (예: 이름 기준 정렬)
        list.sort(new IdComparator());
        // Collections.sort(list, new IdComparator()); // 위와 동일한 기능
        System.out.println(list); // 정렬된 결과 출력
    }

}