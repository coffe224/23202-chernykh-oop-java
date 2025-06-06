package factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Dealer implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(Dealer.class);

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

    private void buy() throws InterruptedException {
        Car soldCar = storage.get();
        if (isLog) {
            logger.info("Car Sold: {} : {} : {} : {}", soldCar.getId(), soldCar.getAccessoryId(), soldCar.getBodyId(), soldCar.getEngineId());
        }
    }
}