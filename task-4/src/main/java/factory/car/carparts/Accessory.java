package factory.car.carparts;

public class Accessory implements CarPart {
    private final long id;
    private static int count = 1;

    public Accessory() {
        this.id = count;
        count++;
    }

    public long getId() {
        return id;
    }
}
