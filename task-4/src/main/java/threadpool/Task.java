package threadpool;

public interface Task {
    void doJob() throws InterruptedException;
}
