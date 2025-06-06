package factory;
import factory.carparts.*;
import factory.listeners.CarStorageController;
import factory.listeners.Listener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import threadpool.ThreadPool;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.Properties;

public class Factory {
    private static final FactoryData data = FactoryData.parse();
    private static final Logger logger = LoggerFactory.getLogger(Factory.class);

    private int totalCars = 0;

    private final Storage<Engine> engineStorage;
    private final Storage<Body> bodyStorage;
    private final Storage<Accessory> accessoryStorage;

    private final Storage<Car> carStorage;
    private final CarStorageController carStorageController;

    private final Supplier<Engine> engineSupplier;
    private final Supplier<Body> bodySupplier;
    private final LinkedList<Supplier<Accessory>> accessorySuppliers;

    private final LinkedList<Dealer> dealers;

    private final ThreadPool workersThreadPool;

    private final LinkedList<Thread> threads;

    public Factory() {
        engineStorage = new Storage<>(data.engineStorageSize());
        bodyStorage = new Storage<>(data.bodyStorageSize());
        accessoryStorage = new Storage<>(data.accessoryStorageSize());

        threads = new LinkedList<>();

        engineSupplier = new Supplier<>(engineStorage, Engine.class, data.supplierWorkTime());
        threads.add(new Thread(engineSupplier));

        bodySupplier = new Supplier<>(bodyStorage, Body.class, data.supplierWorkTime());
        threads.add(new Thread(bodySupplier));

        workersThreadPool = new ThreadPool(data.workersAmount());

        carStorageController = new CarStorageController(this, workersThreadPool, data.carStorageSize());
        carStorage = new Storage<>(data.carStorageSize(), carStorageController);

        accessorySuppliers = new LinkedList<>();
        for (int i = 0; i < data.suppliersAmount(); ++i) {
            Supplier<Accessory> supplier = new Supplier<>(accessoryStorage, Accessory.class, data.supplierWorkTime());
            accessorySuppliers.add(supplier);
            threads.add(new Thread(supplier));
        }

        dealers = new LinkedList<>();
        for (int i = 0; i < data.dealersAmount(); ++i) {
            Dealer dealer = new Dealer(carStorage, data.dealerWorkTime(), data.logging());
            dealers.add(dealer);
            threads.add(new Thread(dealer));
        }
    }

    public void start() {
        logger.info("Fabric is working");
        for (Thread thread : threads) {
            thread.start();
        }
    }

    public void stop() {
        workersThreadPool.shutdown();
        for (Thread thread : threads) {
            thread.interrupt();
        }
        logger.info("Fabric is finished");
    }


    public synchronized void incrementTotalCars() {
        ++totalCars;
    }

    public void updateEngineSupplier(int workTime) {
        engineSupplier.setPauseTime(workTime);
    }

    public void updateBodySupplier(int workTime) {
        bodySupplier.setPauseTime(workTime);
    }

    public void updateAccessorySuppliers(int workTime) {
        for (Supplier<Accessory> supplier : accessorySuppliers) {
            supplier.setPauseTime(workTime);
        }
    }

    public void updateDealers(int workTime) {
        for (Dealer dealer : dealers) {
            dealer.setPauseTime(workTime);
        }
    }

    public Storage<Engine> getEngineStorage() {
        return engineStorage;
    }

    public Storage<Body> getBodyStorage() {
        return bodyStorage;
    }

    public Storage<Accessory> getAccessoryStorage() {
        return accessoryStorage;
    }

    public Storage<Car> getCarStorage() {
        return carStorage;
    }

    public int getTotalCarsCreated() {
        return totalCars;
    }

}


record FactoryData(int bodyStorageSize, int engineStorageSize, int accessoryStorageSize,
                   int carStorageSize, int suppliersAmount, int workersAmount, int dealersAmount,
                   int supplierWorkTime, int dealerWorkTime, boolean logging) {

    public static FactoryData parse() {
        FactoryData factoryData = null;
        try {
            Properties properties = new Properties();
            InputStream propertiesStream = FactoryData.class.getClassLoader().getResourceAsStream("config.properties");
            properties.load(propertiesStream);

            factoryData = new FactoryData(
                    Integer.parseInt(properties.getProperty("BodyStorageSize")),
                    Integer.parseInt(properties.getProperty("EngineStorageSize")),
                    Integer.parseInt(properties.getProperty("AccessoryStorageSize")),
                    Integer.parseInt(properties.getProperty("CarStorageSize")),
                    Integer.parseInt(properties.getProperty("SuppliersAmount")),
                    Integer.parseInt(properties.getProperty("WorkersAmount")),
                    Integer.parseInt(properties.getProperty("DealersAmount")),
                    Integer.parseInt(properties.getProperty("SupplierWorkTime")),
                    Integer.parseInt(properties.getProperty("DealerWorkTime")),
                    Boolean.parseBoolean(properties.getProperty("Logging"))
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return factoryData;
    }
}