package collection.set;

import collection.set.member.Member;

public class JavaHashCodeMain {

    public static void main(String[] args) {
        //Object의 기본 hashCode는 객체의 참조값을 기반으로 생성
        Object obj1 = new Object(); // 새로운 Object 인스턴스 생성
        Object obj2 = new Object(); // 또 다른 Object 인스턴스 생성
        // 각각의 객체는 서로 다른 메모리 주소(참조값)를 가지므로, hashCode 값도 다르다.
        System.out.println("obj1.hashCode() = " + obj1.hashCode());
        System.out.println("obj2.hashCode() = " + obj2.hashCode());

        //각 클래스마다 hashCode를 이미 오버라이딩 해두었다.
        Integer i = 10; // Integer 클래스는 hashCode를 값 자체로 반환하도록 오버라이딩되어 있다.
        String strA = "A"; // String 클래스도 hashCode를 오버라이딩해서 문자열의 내용을 기반으로 해시값을 계산한다.
        String strAB = "AB";
        // Integer, String 등 주요 표준 클래스들은 hashCode와 equals를 적절히 오버라이딩하여, 값이 같으면 해시값도 같게 동작한다.
        System.out.println("10.hashCode = " + i.hashCode()); // 10의 해시코드(=10)
        System.out.println("'A'.hashCode = " + strA.hashCode()); // 'A'의 해시코드
        System.out.println("'AB'.hashCode = " + strAB.hashCode()); // 'AB'의 해시코드

        //hashCode는 마이너스 값이 들어올 수 있다.
        // 해시코드는 int 범위 내에서 어떤 값도 나올 수 있으므로, 음수값도 가능하다.
        System.out.println("-1.hashCode = " + Integer.valueOf(-1).hashCode()); // -1의 해시코드(=-1)

        //둘은 같을까 다를까?, 인스턴스는 다르지만, equals는 같다.
        Member member1 = new Member("idA"); // idA라는 id를 가진 Member 인스턴스 생성
        Member member2 = new Member("idA"); // 동일한 id를 가진 또 다른 Member 인스턴스 생성

        //equals, hashCode를 오버라이딩 하지 않은 경우와, 한 경우를 비교
        // == 연산자는 두 객체의 참조(주소)가 같은지 비교한다. (항상 false)
        System.out.println("(member1 == member2) = " + (member1 == member2));
        // equals 메서드는 두 객체의 논리적 동등성을 비교한다.
        // Member 클래스에서 equals를 오버라이딩했다면 id 값이 같으면 true, 아니면 false가 된다.
        System.out.println("member1 equals member2 = " + member1.equals(member2));
        // hashCode도 오버라이딩했다면, id가 같을 때 같은 해시코드가 반환된다.
        System.out.println("member1.hashCode() = " + member1.hashCode());
        System.out.println("member2.hashCode() = " + member2.hashCode());
        // 만약 equals와 hashCode를 오버라이딩하지 않았다면, 두 객체는 항상 다르다고 판단되고, 해시코드도 다르다.
        // 오버라이딩했다면, id가 같으니 equals는 true, hashCode도 동일한 값이 출력된다.
    }
}
