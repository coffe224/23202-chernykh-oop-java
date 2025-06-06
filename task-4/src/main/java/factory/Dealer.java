package factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

public class Dealer implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(Dealer.class);
    private static final AtomicInteger counter = new AtomicInteger(0);


    private final Storage<Car> storage;
    private int pauseTime;
    private final boolean isLog;

    public Dealer(Storage<Car> storage, int pauseTime, boolean isLog) {
        this.storage = storage;
        this.pauseTime = pauseTime;
        this.isLog = isLog;
    }

    public void setPauseTime(int pauseTime) {
        this.pauseTime = pauseTime;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                buy();
                Thread.sleep(pauseTime);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public static int getTotalSoldCount() {
        return counter.get();
    }

    private void buy() throws InterruptedException {
        Car soldCar = storage.get();
        counter.incrementAndGet();
        if (isLog) {
            logger.info("Car Sold: {} : {} : {} : {}", soldCar.getId(), soldCar.getAccessoryId(), soldCar.getBodyId(), soldCar.getEngineId());
        }
    }
}