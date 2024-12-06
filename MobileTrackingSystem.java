import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class MobileTrackingSystem extends JFrame {
 
    private JTextField latitudeField;
    private JTextField longitudeField;
    private JTextArea displayArea;
 
    public MobileTrackingSystem() {
        setTitle("Mobile Tracking System");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
 
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));
 
        JLabel latitudeLabel = new JLabel("Latitude:");
        latitudeField = new JTextField();
        JLabel longitudeLabel = new JLabel("Longitude:");
        longitudeField = new JTextField();
 
        JButton trackButton = new JButton("Track");
        trackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trackLocation();
            }
        });
 
        inputPanel.add(latitudeLabel);
        inputPanel.add(latitudeField);
        inputPanel.add(longitudeLabel);
        inputPanel.add(longitudeField);
        inputPanel.add(trackButton);
 
        displayArea = new JTextArea();
        displayArea.setEditable(false);
 
        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);
    }
 
    private void trackLocation() {
        String latitude = latitudeField.getText();
        String longitude = longitudeField.getText();
        if (latitude.isEmpty() || longitude.isEmpty()) {
            displayArea.append("Please enter both latitude and longitude.\n");
        } else {
            displayArea.append("Tracking location...\n");
            displayArea.append("Latitude: " + latitude + "\n");
            displayArea.append("Longitude: " + longitude + "\n");
            // Simulate location tracking logic
            displayArea.append("Location tracked successfully!\n\n");
        }
    }
       public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MobileTrackingSystem app = new MobileTrackingSystem();
            app.setVisible(true);
        });
   }
}
