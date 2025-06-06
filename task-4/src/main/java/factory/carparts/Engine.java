package factory.car.carparts;

public class Engine implements CarPart {
    private final long id;
    private static int count = 1;

    public Engine() {
        this.id = count;
        count++;
    }

    public long getId() {
        return id;
    }
}
