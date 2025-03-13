package collection.set.test;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class UniqueNamesTest2 {
    public static void main(String[] args) {
        Integer[] inputArr = {30, 20, 20, 10, 10};
        // 코드 작성

        Set<Integer> set = new LinkedHashSet<>();
        for (Integer i : inputArr) {
            set.add(i);
        }

        for (Integer s : set) {
            System.out.println(s);
        }

    }
}