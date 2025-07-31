package factory;


import factory.listeners.Listener;

import java.util.*;

public class Storage<T> {
    private final int maxSize;
    private final Queue<T> storageQueue;
    private final Object lock = new Object();
    private Listener listener = null;

    public Storage(int maxSize) {
        this(maxSize, null);
    }

    public Storage(int maxSize, Listener listener) {
        this.maxSize = maxSize;
        this.storageQueue = new ArrayDeque<>();
        this.listener = listener;
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
            if (listener != null) {
                listener.update();
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
