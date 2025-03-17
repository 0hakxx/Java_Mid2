package collection.map.test;

import java.util.ArrayDeque;
import java.util.Queue;

public class PrinterQueueTest {
    public static void main(String[] args) {
        Queue<String> printQueue = new ArrayDeque<>();
        // 코드 작성

        printQueue.add("doc1");
        printQueue.add("doc2");
        printQueue.add("doc3");


        System.out.println(printQueue.poll());
        System.out.println(printQueue.poll());
        System.out.println(printQueue.poll());

    }
}
