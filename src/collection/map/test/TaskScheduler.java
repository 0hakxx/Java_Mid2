package collection.map.test;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class TaskScheduler {
    Queue<Task> tasks = new ArrayDeque<>();

    public void addTask(Task task) {
        tasks.offer(task);
    }
    public int getRemainingTasks(){
        return tasks.size();
    }

    public void processNextTask() {
        Task task = tasks.poll();
        if(task != null) {
            task.execute();
        }
    }

}
