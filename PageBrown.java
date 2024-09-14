import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PageBrown extends JPanel {
    private JTextField cowIDField;
    private JTextField farmIDField;
    private JTextField parentIDField;
    private Farms farm;
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public PageBrown(CardLayout cardLayout, JPanel cardPanel, Farms farm) {
        this.farm = farm;
        this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Cow ID:"));
        cowIDField = new JTextField();
        add(cowIDField);

        add(new JLabel("Farm ID:"));
        farmIDField = new JTextField();
        add(farmIDField);

        add(new JLabel("Parent ID:"));
        parentIDField = new JTextField();
        add(parentIDField);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new SubmitButtonListener());
        add(submitButton);
    }

    private class SubmitButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                int cowID = Integer.parseInt(cowIDField.getText());
                int farmID = Integer.parseInt(farmIDField.getText());
                int parentID = Integer.parseInt(parentIDField.getText());

                if (validateInputs(cowID, farmID, parentID)) {
                    BrownCow brownCow = new BrownCow(cowID, farmID, parentID);
                    if (farm.canAddCow(farmID, "Brown")) {
                        if (farm.isCowIDUnique(cowID)) {
                            farm.addCow(cowID, farmID, "Brown", brownCow); //add cow to model
                            JOptionPane.showMessageDialog(PageBrown.this, "Brown Cow registered successfully.");
                            ((StatusPage) cardPanel.getComponent(4)).refresh(); //refresh status page
                            cardLayout.show(cardPanel, "Status");
                        } else {
                            JOptionPane.showMessageDialog(PageBrown.this, "Cow ID already exists.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(PageBrown.this, "Farm already has a cow of another color.");
                    }
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(PageBrown.this, "Invalid input format.");
            }
        }

        //check the required conditions
        private boolean validateInputs(int cowID, int farmID, int parentID) {
            if (String.valueOf(cowID).length() != 8 || cowID < 10000000) {
                JOptionPane.showMessageDialog(PageBrown.this, "Cow ID must be an 8-digit number not starting with 0.");
                return false;
            }
            if (farmID <= 0) {
                JOptionPane.showMessageDialog(PageBrown.this, "Farm ID must be a positive number not equal to 0.");
                return false;
            }
            if (parentID < 10000000) {
                JOptionPane.showMessageDialog(PageBrown.this, "Parent ID must be a valid 8-digit cow ID.");
                return false;
            }
            return true;
        }
    }
}
