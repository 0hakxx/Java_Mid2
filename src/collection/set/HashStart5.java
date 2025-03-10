package collection.set;


import java.util.LinkedList;


public class HashStart5 {
    static final int CAPCITY = 10;

    public static void main(String[] args){
        LinkedList<Integer>[] buckets = new LinkedList[10];
        for(int i=0; i<buckets.length; i++){
            buckets[i] = new LinkedList<>();
        }
        add(buckets, 1);
        add(buckets, 2);
        add(buckets, 5);
        add(buckets, 8);
        add(buckets, 14);
        add(buckets, 99);
        add(buckets, 9); //중복
    }

    public static void add(LinkedList<Integer>[] buckets, int searchVaalue){
        int hashIndex = hashIndex(int searchValue);
    }
    static int hashIndex(int hashValue){
        return hashValue % CAPCITY;
    }

}
