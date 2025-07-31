package factory;


import factory.swing.SwingInterface;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Factory carFactory;
        carFactory = new Factory();

        SwingInterface gui = new SwingInterface(carFactory);
        carFactory.start();
        SwingUtilities.invokeLater(() -> {
            gui.activate();
            Runtime.getRuntime().addShutdownHook(new Thread(carFactory::stop));
        });


    }
}