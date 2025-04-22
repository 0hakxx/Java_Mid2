package collection.list.test.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ListEx2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        System.out.println("n개의 정수를 입력하세요 (종료 0)");
        while (true) {
            int input = scanner.nextInt();
            if(input == 0){ break; }
            numbers.add(input);
        }
        System.out.println(numbers);
    }
}