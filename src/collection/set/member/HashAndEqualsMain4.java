package collection.set.member;

import collection.set.MyHashSetV2;

public class HashAndEqualsMain4 {

    public static void main(String[] args) {

        MyHashSetV2 set = new MyHashSetV2(10);



        System.out.println(set);


        MemberOnlyHash searchValue = new MemberOnlyHash("A");
        System.out.println("searchValue.hashCode() = " + searchValue.hashCode());
        boolean contains = set.contains(searchValue);
        System.out.println("contains = " + contains);
    }
}