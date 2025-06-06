package factory.car;

import factory.car.carparts.Accessory;
import factory.car.carparts.Body;
import factory.car.carparts.Engine;

public class Car {
    private static int count = 1;

    private final long id;

    private final Engine engine;
    private final Accessory accessory;
    private final Body body;

    public Car(Engine engine, Accessory accessory, Body body) {
        this.engine = engine;
        this.accessory = accessory;
        this.body = body;

        this.id = count;
        count++;
    }

    public long getId() {
        return this.id;
    }

    public long getEngineId() {
        return this.engine.getId();
    }

    public long getAccessoryId() {
        return this.accessory.getId();
    }

    public long getCarcassId() {
        return this.body.getId();
    }
}
