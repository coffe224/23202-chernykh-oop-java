package factory;

public class Supplier<T> implements Runnable {
    private final Class<T> itemClass;
    private final Storage<T> storage;
    private int pauseTime;

    public Supplier(Storage<T> storage, Class<T> itemClass, int pauseTime) {
        this.itemClass = itemClass;
        this.storage = storage;
        this.pauseTime = pauseTime;
    }

    public void setPauseTime(int pauseTime) {
        this.pauseTime = pauseTime;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                supply();
                Thread.sleep(pauseTime);
            } catch (InterruptedException | RuntimeException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    private void supply() {
        try {
            storage.put(itemClass.getConstructor().newInstance());
        } catch (Exception e) {
            throw new RuntimeException("Couldn't create detail: " + e.getMessage());
        }
    }
}
