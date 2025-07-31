package threadpool;

import java.util.ArrayDeque;
import java.util.Queue;

public class ThreadPool {
    private final Queue<Task> taskQueue = new ArrayDeque<>();
    private final Queue<PoolThread> threads = new ArrayDeque<>();

    public ThreadPool(int threadCount) {
        for (int i = 0; i < threadCount; i++) {
            PoolThread thread = new PoolThread(taskQueue);
            threads.add(thread);
            thread.start();
        }
    }

    public void addTask(Task task) {
        synchronized (taskQueue) {
            taskQueue.add(task);
            taskQueue.notifyAll();
        }
    }

    public void shutdown() {
        threads.forEach(Thread::interrupt);
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }
}