package factory.carparts;

import java.util.UUID;

public class Body implements CarPart {
    private final UUID id;

    public Body() {
        this.id = UUID.randomUUID();;
    }

    public String getId() {
        return id.toString();
    }
}
