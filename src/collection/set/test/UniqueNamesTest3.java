package collection.set.test;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class UniqueNamesTest3 {

    public static void main(String[] args) {
        Integer[] inputArr = {30, 20, 20, 10, 10};
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(Integer i : inputArr) {
            treeSet.add(i);
        }
        System.out.println(treeSet);
    }
}
