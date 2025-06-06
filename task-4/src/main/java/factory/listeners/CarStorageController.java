package factory.listeners;

import factory.Factory;
import threadpool.ThreadPool;

public class CarStorageController implements Listener {
    private final ThreadPool threadpool;
    private final Factory factory;

    public CarStorageController(Factory factory, ThreadPool threadpool, int initialTasks) {
        this.factory = factory;
        this.threadpool = threadpool;
        for (int i = 0; i < initialTasks; ++i) {
            threadpool.addTask(new WorkerTask(factory));
        }
    }

    @Override
    public void update() {
        threadpool.addTask(new WorkerTask(factory));
    }
}
