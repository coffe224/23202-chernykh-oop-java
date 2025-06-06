package factory.carparts;

import java.util.UUID;

public class Engine implements CarPart {
    private final UUID id;

    public Engine() {
        this.id = UUID.randomUUID();;
    }

    public String getId() {
        return id.toString();
    }
}
