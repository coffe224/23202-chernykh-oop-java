package factory.car;


import java.util.*;

public class Storage<T> {
    private final int maxSize;
    private final Queue<T> storageQueue;
    private final Object lock = new Object();

    public Storage(int maxSize) {
        this.maxSize = maxSize;
        this.storageQueue = new ArrayDeque<>();
    }

    public void put(T item) throws InterruptedException {
        synchronized (lock) {
            while (storageQueue.size() == maxSize) {
                lock.wait();
            }
            storageQueue.add(item);
            lock.notifyAll();
        }
    }

    public T get() throws InterruptedException {
        synchronized (lock) {
            while (storageQueue.isEmpty()) {
                lock.wait();
            }
            T item = storageQueue.remove();

            lock.notifyAll();
            return item;
        }
    }

    public int getCount() {
        return storageQueue.size();
    }
}
