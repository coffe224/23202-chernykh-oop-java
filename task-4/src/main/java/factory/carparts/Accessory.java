package factory.carparts;

import java.util.UUID;

public class Accessory implements CarPart {
    private final UUID id;

    public Accessory() {
        this.id = UUID.randomUUID();;
    }

    public String getId() {
        return id.toString();
    }
}
