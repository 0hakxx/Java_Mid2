package collection.compare;

import java.util.Arrays;

public class SortMain3 {
    public static void main(String[] args) {
        MyUser myuser1 = new MyUser("ID1", 20);
        MyUser myuser2 = new MyUser("ID2", 30);
        MyUser myuser3 = new MyUser("ID3", 40);

        MyUser[] array = {myuser1, myuser2, myuser3};
        System.out.println("기본 데이터");
        System.out.println(Arrays.toString(array));

        System.out.println("Comparable 기본 정렬");
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));




    }
}
