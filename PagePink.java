import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PagePink extends JPanel {
    private JTextField cowIDField;
    private JTextField farmIDField;
    private JTextField nameField;
    private JTextField lastNameField;
    private Farms farm;
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public PagePink(CardLayout cardLayout, JPanel cardPanel, Farms farm) {
        this.farm = farm;
        this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;
        setLayout(new GridLayout(5, 2));

        add(new JLabel("Cow ID:"));
        cowIDField = new JTextField();
        add(cowIDField);

        add(new JLabel("Farm ID:"));
        farmIDField = new JTextField();
        add(farmIDField);

        add(new JLabel("Owner Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Owner Last Name:"));
        lastNameField = new JTextField();
        add(lastNameField);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new SubmitButtonListener());
        add(submitButton);
    }

    private class SubmitButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                int cowID = Integer.parseInt(cowIDField.getText());
                int farmID = Integer.parseInt(farmIDField.getText());
                String name = nameField.getText();
                String lastName = lastNameField.getText();

                if (validateInputs(cowID, farmID, name, lastName)) {
                    PinkCow pinkCow = new PinkCow(cowID, farmID, name, lastName);
                    if (farm.canAddCow(farmID, "Pink")) {
                        if (farm.isCowIDUnique(cowID)) {
                            farm.addCow(cowID, farmID, "Pink", pinkCow);
                            JOptionPane.showMessageDialog(PagePink.this, "Pink Cow registered successfully.");
                            ((StatusPage) cardPanel.getComponent(4)).refresh(); //refresh status page
                            cardLayout.show(cardPanel, "Status");
                        } else {
                            JOptionPane.showMessageDialog(PagePink.this, "Cow ID already exists.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(PagePink.this, "Farm already has a cow of another color.");
                    }
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(PagePink.this, "Invalid input format.");
            }
        }

        //check the required conditions
        private boolean validateInputs(int cowID, int farmID, String name, String lastName) {
            if (String.valueOf(cowID).length() != 8 || cowID < 10000000) {
                JOptionPane.showMessageDialog(PagePink.this, "Cow ID must be an 8-digit number not starting with 0.");
                return false;
            }
            if (farmID <= 0) {
                JOptionPane.showMessageDialog(PagePink.this, "Farm ID must be a positive number not equal to 0.");
                return false;
            }
            if (name.length() > 8 || !name.matches("[a-z]+")) {
                JOptionPane.showMessageDialog(PagePink.this, "Owner name must be lowercase letters only and not longer than 8 characters.");
                return false;
            }
            if (lastName.length() > 8 || !lastName.matches("[a-z]+")) {
                JOptionPane.showMessageDialog(PagePink.this, "Owner last name must be lowercase letters only and not longer than 8 characters.");
                return false;
            }
            return true;
        }
    }
}
