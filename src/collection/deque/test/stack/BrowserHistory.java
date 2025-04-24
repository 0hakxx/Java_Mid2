package collection.deque.test.stack;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 visitPage("A"); // 첫 방문
 visitPage("B");
 visitPage("C");
 각 단계별 스택 상태

 Step1.
 visitPage("A")
 currentPage: null → "A"
 stack: []

 Step2.
 visitPage("B")
 currentPage: "A" (null 아님 → "A"를 push)
 stack: ["A"]
 currentPage: "B"

 Step3.
 visitPage("C")
 currentPage: "B" (null 아님 → "B"를 push)
 stack: ["B", "A"]
 currentPage: "C"

 goBack()을 하면?
 goBack()
 stack에서 "B" pop → currentPage: "B"
 stack: ["A"]

 goBack()
 stack에서 "A" pop → currentPage: "A"
 stack: []
 */
public class BrowserHistory {
    // 이전에 방문한 페이지들의 URL을 저장하는 스택(Deque)
    private Deque<String> stack = new ArrayDeque<>();
    // 현재 보고 있는 페이지의 URL
    private String currentPage = null;

    public void visitPage(String url) {
        // 현재 페이지가 null이 아니라면(즉, 첫 방문이 아니라면)
        // 현재 페이지를 stack에 저장(뒤로가기를 위해)
        if (currentPage != null) {
            stack.push(currentPage);
        }
        // 현재 페이지를 새로 방문한 url로 갱신
        currentPage = url;
        // 방문한 페이지를 출력
        System.out.println("방문: " + url);
    }

    public String goBack() {
        // 스택이 비어있지 않다면(즉, 이전 페이지 기록이 있다면)
        if (!stack.isEmpty()) {
            // 스택에서 가장 최근 페이지를 꺼내 현재 페이지로 설정
            currentPage = stack.pop();
            // 뒤로 간 페이지를 출력
            System.out.println("뒤로가기 " + currentPage);
            // 현재 페이지 반환
            return currentPage;
        }
        // 더 이상 뒤로 갈 페이지가 없으면 null 반환
        return null;
    }
}
