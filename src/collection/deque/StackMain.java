package collection.deque;

import java.util.Deque;
import java.util.Stack;

//Stack은 사용하면 안됨 -> Deque를 대신 사용
// Stack 클래스는 Vector 라는 자료 구조를 사용한다. 이 자료 구조는 자바 1.0에 개발되었는데,
// 지금은 사용되지 않고 하위 호환을 위해 존재한다. 지금은 더 빠른 좋은 자료 구조가 많다.

public class StackMain {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);

        // 다음 꺼낼 요소 확인(꺼내지 않고 단순 조회만)
        System.out.println("stack.peek() = " + stack.peek());

        // 스택 요소 뽑기
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println(stack);
    }
}