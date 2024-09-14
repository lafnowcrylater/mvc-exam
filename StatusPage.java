import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.awt.event.*;

public class StatusPage extends JPanel {
    private Farms farm;
    private JTextArea statusArea;

    public StatusPage(CardLayout cardLayout, JPanel cardPanel, Farms farm) {
        this.farm = farm;
        setLayout(new BorderLayout());

        JLabel statusLabel = new JLabel("Farm Status");
        add(statusLabel, BorderLayout.NORTH);

        statusArea = new JTextArea();
        statusArea.setEditable(false);
        add(new JScrollPane(statusArea), BorderLayout.CENTER);

        JButton backToFirst = new JButton("Done");
        backToFirst.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Home");
            }
        });
        add(backToFirst, BorderLayout.PAGE_END);

        updateStatus();
    }

    // Method to update the status display
    public void updateStatus() {
        StringBuilder sb = new StringBuilder();
        Map<Integer, String> farmData = farm.getFarmData();
        Map<Integer, Integer> cowCount = farm.getCowCount();

        for (Map.Entry<Integer, String> entry : farmData.entrySet()) {
            int farmID = entry.getKey();
            String color = entry.getValue();
            int count = cowCount.getOrDefault(farmID, 0);
            sb.append("Farm ID: ").append(farmID)
              .append(", Color: ").append(color)
              .append(", Number of Cows: ").append(count)
              .append("\n");
        }

        statusArea.setText(sb.toString());
    }

    // Call this method to refresh the status display
    public void refresh() {
        updateStatus();
    }
}
