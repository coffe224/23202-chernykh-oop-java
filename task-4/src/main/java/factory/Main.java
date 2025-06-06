package factory;

import factory.car.carparts.Accessory;
import factory.car.carparts.Body;
import factory.car.carparts.Engine;
import factory.suppliers.AccessorySupplier;
import factory.suppliers.BodySupplier;
import factory.suppliers.MotorSupplier;

public class Main {
    public static void main(String[] args) {
        AccessorySupplier accessorySupplier = new AccessorySupplier();
        MotorSupplier motorSupplier = new MotorSupplier();
        BodySupplier bodySupplier = new BodySupplier();

        Engine engine1 = (Engine) motorSupplier.supply();
        System.out.println(engine1.getId());
        Engine engine2 = (Engine) motorSupplier.supply();

        System.out.println(engine1.getId());
        System.out.println(engine2.getId());


        Accessory accessory1 = (Accessory) accessorySupplier.supply();
        System.out.println(accessory1.getId());

        Body body1 = (Body) bodySupplier.supply();
        System.out.println(body1.getId());

    }
}