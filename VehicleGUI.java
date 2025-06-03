import java.awt.*;
import javax.swing.*;

public class VehicleGUI extends JFrame {
    private JComboBox<String> vehicleTypeCombo;
    private final JTextField makeField;
    private final JTextField modelField;
    private final JTextField yearField;
    private JTextField doorsField, fuelField;          // Car
    private JTextField wheelsField, typeField;         // Motorcycle
    private JTextField capacityField, transmissionField; // Truck
    private final JTextArea outputArea;
    private JPanel dynamicPanel;

    public VehicleGUI() {
        setTitle("Vehicle Info");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 500);
        setLayout(new BorderLayout());

        // Common input
        JPanel topPanel = new JPanel(new GridLayout(5, 2));
        vehicleTypeCombo = new JComboBox<>(new String[]{"Car", "Motorcycle", "Truck"});
        makeField = new JTextField();
        modelField = new JTextField();
        yearField = new JTextField();

        topPanel.add(new JLabel("Select Vehicle Type:"));
        topPanel.add(vehicleTypeCombo);
        topPanel.add(new JLabel("Make:"));
        topPanel.add(makeField);
        topPanel.add(new JLabel("Model:"));
        topPanel.add(modelField);
        topPanel.add(new JLabel("Year:"));
        topPanel.add(yearField);

        // Dynamic fields
        dynamicPanel = new JPanel(new GridLayout(4, 2));
        updateDynamicFields("Car");

        // Output area
        outputArea = new JTextArea(6, 30);
        outputArea.setEditable(false);

        // Button
        JButton submitBtn = new JButton("Submit");
        submitBtn.addActionListener(e -> handleSubmit());

        // Vehicle type change
        vehicleTypeCombo.addActionListener(e -> {
            dynamicPanel.removeAll();
            updateDynamicFields(vehicleTypeCombo.getSelectedItem().toString());
            dynamicPanel.revalidate();
            dynamicPanel.repaint();
        });

        // Layout
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(topPanel, BorderLayout.NORTH);
        centerPanel.add(dynamicPanel, BorderLayout.CENTER);
        centerPanel.add(submitBtn, BorderLayout.SOUTH);

        add(centerPanel, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);
    }

    private void updateDynamicFields(String type) {
        dynamicPanel.removeAll();
        switch (type) {
            case "Car" -> {
                doorsField = new JTextField();
                fuelField = new JTextField();
                dynamicPanel.add(new JLabel("Number of doors:"));
                dynamicPanel.add(doorsField);
                dynamicPanel.add(new JLabel("Fuel type:"));
                dynamicPanel.add(fuelField);
            }
            case "Motorcycle" -> {
                wheelsField = new JTextField();
                typeField = new JTextField();
                dynamicPanel.add(new JLabel("Number of wheels:"));
                dynamicPanel.add(wheelsField);
                dynamicPanel.add(new JLabel("Type (sport/cruiser):"));
                dynamicPanel.add(typeField);
            }
            default -> {
                capacityField = new JTextField();
                transmissionField = new JTextField();
                dynamicPanel.add(new JLabel("Cargo capacity (tons):"));
                dynamicPanel.add(capacityField);
                dynamicPanel.add(new JLabel("Transmission (manual/auto):"));
                dynamicPanel.add(transmissionField);
            }
        }
    }

    private void handleSubmit() {
        try {
            String make = makeField.getText();
            String model = modelField.getText();
            int year = Integer.parseInt(yearField.getText());

            String type = vehicleTypeCombo.getSelectedItem().toString();
            String result = "";

            switch (type) {
                case "Car" -> {
                    int doors = Integer.parseInt(doorsField.getText());
                    String fuel = fuelField.getText();
                    result = "Car: " + make + " " + model + ", Year: " + year + ", Doors: " + doors + ", Fuel: " + fuel;
                }

                case "Motorcycle" -> {
                    int wheels = Integer.parseInt(wheelsField.getText());
                    String motoType = typeField.getText();
                    result = "Motorcycle: " + make + " " + model + ", Year: " + year + ", Wheels: " + wheels + ", Type: " + motoType;
                }

                case "Truck" -> {
                    double capacity = Double.parseDouble(capacityField.getText());
                    String trans = transmissionField.getText();
                    result = "Truck: " + make + " " + model + ", Year: " + year + ", Cargo: " + capacity + " tons, Transmission: " + trans;
                }
            }

            outputArea.setText(result);

        } catch (NumberFormatException e) {
            outputArea.setText("Error: Please fill all fields correctly.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VehicleGUI().setVisible(true));
    }
}
