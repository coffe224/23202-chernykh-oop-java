package factory.car.carparts;

public class Body implements CarPart {
    private final long id;
    private static int count = 1;

    public Body() {
        this.id = count;
        count++;
    }

    public long getId() {
        return id;
    }
}
