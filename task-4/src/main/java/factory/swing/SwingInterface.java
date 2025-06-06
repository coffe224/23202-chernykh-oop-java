package factory.swing;

import factory.Factory;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SwingInterface {
    private final Factory factory;
    private final JLabel totalLabel = createValueLabel();
    private final JLabel storedLabel = createValueLabel();
    private final JLabel bodyStorageLabel = createValueLabel();
    private final JLabel engineStorageLabel = createValueLabel();
    private final JLabel accessoryStorageLabel = createValueLabel();
    private JSlider bodyCreationSlider;
    private JSlider engineCreationSlider;
    private JSlider accessoryCreationSlider;
    private JSlider requestSpeedSlider;

    private final int MIN = 50;
    private final int MAX = 1500;

    public SwingInterface(Factory factory) {
        this.factory = factory;
        Timer updateTimer = new Timer(100, e -> update(factory.getTotalCarsCreated()));
        updateTimer.start();
    }

    private JLabel createValueLabel() {
        JLabel label = new JLabel("0", SwingConstants.RIGHT);
        label.setFont(new Font("Segoe UI", Font.BOLD, 18));
        label.setForeground(new Color(70, 130, 180)); // Steel blue
        return label;
    }

    private JLabel createTitleLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        label.setForeground(new Color(50, 50, 50));
        return label;
    }

    private JSlider createStyledSlider() {
        JSlider slider = new JSlider(JSlider.HORIZONTAL, MIN, MAX, (MAX + MIN) / 2);
        slider.setBackground(Color.WHITE);
        slider.setForeground(new Color(70, 130, 180));
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(500);
        slider.setMinorTickSpacing(100);
        return slider;
    }

    public void activate() {
        JFrame frame = new JFrame("Car Factory Dashboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 650);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setLocationRelativeTo(null);

        // Create sliders with consistent styling
        bodyCreationSlider = createStyledSlider();
        engineCreationSlider = createStyledSlider();
        accessoryCreationSlider = createStyledSlider();
        requestSpeedSlider = createStyledSlider();

        // Add change listeners
        bodyCreationSlider.addChangeListener(e ->
                factory.updateBodySupplier(bodyCreationSlider.getValue()));
        engineCreationSlider.addChangeListener(e ->
                factory.updateEngineSupplier(engineCreationSlider.getValue()));
        accessoryCreationSlider.addChangeListener(e ->
                factory.updateAccessorySuppliers(accessoryCreationSlider.getValue()));
        requestSpeedSlider.addChangeListener(e ->
                factory.updateDealers(requestSpeedSlider.getValue()));

        // Main panel with padding
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        mainPanel.setBackground(new Color(240, 240, 245));

        // Create control panel
        JPanel controlPanel = createControlPanel();
        mainPanel.add(controlPanel, BorderLayout.NORTH);

        // Create stats panel
        JPanel statsPanel = createStatsPanel();
        mainPanel.add(statsPanel, BorderLayout.CENTER);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private JPanel createControlPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 210)),
                "Production Speed Controls",
                TitledBorder.LEFT, TitledBorder.TOP,
                new Font("Segoe UI", Font.BOLD, 14),
                new Color(70, 130, 180)));
        panel.setBackground(Color.WHITE);
        panel.setOpaque(true);

        panel.add(createSliderPanel("Body Supplier Speed:", bodyCreationSlider));
        panel.add(createSliderPanel("Engine Supplier Speed:", engineCreationSlider));
        panel.add(createSliderPanel("Accessory Supplier Speed:", accessoryCreationSlider));
        panel.add(createSliderPanel("Dealer Request Speed:", requestSpeedSlider));

        return panel;
    }

    private JPanel createSliderPanel(String title, JSlider slider) {
        JPanel panel = new JPanel(new BorderLayout(10, 5));
        panel.setBackground(Color.WHITE);
        panel.setOpaque(true);

        JLabel label = createTitleLabel(title);
        panel.add(label, BorderLayout.NORTH);
        panel.add(slider, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createStatsPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 2, 15, 0));
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 210)),
                "Factory Statistics",
                TitledBorder.LEFT, TitledBorder.TOP,
                new Font("Segoe UI", Font.BOLD, 14),
                new Color(70, 130, 180)));
        panel.setBackground(Color.WHITE);
        panel.setOpaque(true);

        // Left column - Production stats
        JPanel productionPanel = createStatSubPanel("Production");
        productionPanel.add(createStatRow("Total Cars Produced:", totalLabel));
        productionPanel.add(createStatRow("Cars in Storage:", storedLabel));

        // Right column - Component stats
        JPanel componentPanel = createStatSubPanel("Components");
        componentPanel.add(createStatRow("Bodies in Storage:", bodyStorageLabel));
        componentPanel.add(createStatRow("Engines in Storage:", engineStorageLabel));
        componentPanel.add(createStatRow("Accessories in Storage:", accessoryStorageLabel));

        panel.add(productionPanel);
        panel.add(componentPanel);

        return panel;
    }

    private JPanel createStatSubPanel(String title) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(230, 230, 240)),
                title,
                TitledBorder.LEFT, TitledBorder.TOP,
                new Font("Segoe UI", Font.BOLD, 12),
                new Color(100, 149, 237)));
        panel.setBackground(Color.WHITE);
        panel.setOpaque(true);
        panel.add(Box.createVerticalStrut(5));

        return panel;
    }

    private JPanel createStatRow(String title, JLabel valueLabel) {
        JPanel row = new JPanel(new BorderLayout(10, 0));
        row.setBackground(Color.WHITE);
        row.setOpaque(true);
        row.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        JLabel titleLabel = createTitleLabel(title);
        row.add(titleLabel, BorderLayout.WEST);
        row.add(valueLabel, BorderLayout.EAST);

        return row;
    }

    public void update(int totalNum) {
        SwingUtilities.invokeLater(() -> {
            totalLabel.setText(String.valueOf(totalNum));
            storedLabel.setText(String.valueOf(factory.getCarStorage().getCount()));
            bodyStorageLabel.setText(String.valueOf(factory.getBodyStorage().getCount()));
            engineStorageLabel.setText(String.valueOf(factory.getEngineStorage().getCount()));
            accessoryStorageLabel.setText(String.valueOf(factory.getAccessoryStorage().getCount()));
        });
    }
}