package collection.deque.test.queue;

import java.util.ArrayDeque;
import java.util.Queue;


public class TaskScheduler {
    private Queue<Task> tasks = new ArrayDeque<>();

    public void addTask(Task task) {
        tasks.offer(task);
    }


    public void processNextTask() {
        // poll()은 큐의 맨 앞에서 작업을 꺼내 반환(큐가 비면 null 반환)
        Task task = tasks.poll();
        if (task != null) {
            // 작업이 있으면 실행 (Task 클래스는 execute() 메서드를 가져야 함)
            task.execute();
        }
    }

    public int getRemainingTasks() {
        return tasks.size();
    }
}
