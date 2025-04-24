package collection.compare;

// MyUser 클래스는 Comparable<MyUser> 인터페이스를 구현
// 즉, MyUser 객체들끼리 기본적으로 정렬(비교)할 수 있게 만듦
public class MyUser implements Comparable<MyUser> {

    // 사용자 ID (문자열)
    private String id;
    // 사용자 나이 (정수)
    private int age;

    // 생성자: id와 age를 받아서 멤버 변수에 저장
    public MyUser(String id, int age) {
        this.id = id;
        this.age = age;
    }

    // id 값을 반환하는 getter
    public String getId() {
        return id;
    }

    // age 값을 반환하는 getter
    public int getAge() {
        return age;
    }

    /**
     * compareTo 메서드: 두 MyUser 객체의 나이를 기준으로 비교
     * - this.age < o.age 이면 음수(-1) 반환 (this가 o보다 앞에 옴)
     * - this.age == o.age 이면 0 반환 (같음)
     * - this.age > o.age 이면 양수(1) 반환 (this가 o보다 뒤에 옴)
     *
     * 즉, 나이 오름차순 정렬 (나이가 적은 사람이 앞에 오도록)
     */
    @Override
    public int compareTo(MyUser o) {
        return this.age < o.age ? -1 : (this.age == o.age ? 0 : 1);
        // 또는 Integer.compare(this.age, o.age)로도 가능
    }

    @Override
    public String toString() {
        return "MyUser{" +
                "id='" + id + '\'' +
                ", age=" + age +
                '}';
    }
}

