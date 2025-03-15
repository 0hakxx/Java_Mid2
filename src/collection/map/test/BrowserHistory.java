package collection.map.test;

import java.util.ArrayDeque;
import java.util.Deque;

public class BrowserHistory {
    private Deque<String> history = new ArrayDeque<String>();
    private int size=0;


    public void visitPage(String Page){
        history.push(Page);
        System.out.println("방문 " + Page);
        size++;
    }



    public String goBack(){
        if(history.size() == size){
            history.pop();
        }

        return history.pop();
    }

}
