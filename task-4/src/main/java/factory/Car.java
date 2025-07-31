package factory;

import factory.carparts.Accessory;
import factory.carparts.Body;
import factory.carparts.Engine;

import java.util.UUID;

public class Car {
    private final UUID id;

    private final Engine engine;
    private final Accessory accessory;
    private final Body body;

    public Car(Engine engine, Accessory accessory, Body body) {
        this.engine = engine;
        this.accessory = accessory;
        this.body = body;

        this.id = UUID.randomUUID();;
    }

    public String getId() {
        return id.toString();
    }

    public String getEngineId() {
        return this.engine.getId();
    }

    public String getAccessoryId() {
        return this.accessory.getId();
    }

    public String getBodyId() {
        return this.body.getId();
    }
}
