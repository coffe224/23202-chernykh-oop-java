package factory.listeners;

import factory.Car;
import factory.Factory;
import factory.carparts.*;
import threadpool.Task;

public class WorkerTask implements Task {
    private final Factory factory;

    public WorkerTask(Factory factory) {
        this.factory = factory;
    }

    @Override
    public void doJob() throws InterruptedException {
        Body body = factory.getBodyStorage().get();
        Engine engine = factory.getEngineStorage().get();
        Accessory accessory = factory.getAccessoryStorage().get();

        Car newCar = new Car(engine, accessory, body);

        factory.getCarStorage().put(newCar);
        factory.incrementTotalCars();
    }
}
