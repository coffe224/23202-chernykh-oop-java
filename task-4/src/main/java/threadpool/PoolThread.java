package threadpool;

import java.util.Queue;

public class PoolThread extends Thread{
    private final Queue<Task> taskQueue;

    public PoolThread(Queue<Task> taskQueue) {
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        Task currentTask;
        while (!isInterrupted()) {
            synchronized (taskQueue) {
                while (taskQueue.isEmpty()) {
                    try {
                        taskQueue.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                currentTask = taskQueue.remove();
            }
            try {
                currentTask.doJob();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
