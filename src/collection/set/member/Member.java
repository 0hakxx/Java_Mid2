package collection.set.member;

import java.util.Objects;

public class Member {

    private String id;

    public Member(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        // 1. 자기 자신과 비교하는 경우 항상 true를 반환한다.
        //    (동일한 객체이므로 무조건 같다.)
        if (this == o) return true;

        // 2. 비교 대상이 null이거나, 클래스 타입이 다르면 false를 반환한다.
        //    (null은 어떤 객체와도 같지 않고, 타입이 다르면 논리적으로 같다고 볼 수 없다.)
        if (o == null || getClass() != o.getClass()) return false;

        // 3. 비교 대상 객체를 Member 타입으로 캐스팅한다.
        Member member = (Member) o;

        // 실질적으로 오버라이딩 하는 이유는 이 부분이다.
        // 4. 두 객체의 id 값이 같은지 비교한다.
        // (Objects.equals는 null-safe 비교를 제공한다. 즉, 둘 다 null이면 true, 하나만 null이면 false, 둘 다 같으면 true)
        return Objects.equals(id, member.id);
    }

    @Override
    public int hashCode() {
        // 5. id 필드를 기반으로 해시코드를 생성한다. --> Objects.hash(id) 코드는 id 값이 같으면 해시 값도 같도록 정의한다.
        //    (Objects.hash는 null도 안전하게 처리해준다. id가 같으면 항상 같은 해시코드가 반환된다.)
        //    -> equals가 true인 객체는 반드시 hashCode도 같아야 하므로, equals에서 비교하는 필드를 기준으로 hashCode를 만든다.
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                '}';
    }

}