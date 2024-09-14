import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PageWhite extends JPanel {
    private JTextField cowIDField;
    private JTextField farmIDField;
    private JTextField yearField;
    private JTextField monthField;
    private Farms farm;
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public PageWhite(CardLayout cardLayout, JPanel cardPanel, Farms farm) {
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

        add(new JLabel("Year:"));
        yearField = new JTextField();
        add(yearField);

        add(new JLabel("Month:"));
        monthField = new JTextField();
        add(monthField);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new SubmitButtonListener());
        add(submitButton);
    }

    private class SubmitButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                int cowID = Integer.parseInt(cowIDField.getText());
                int farmID = Integer.parseInt(farmIDField.getText());
                int year = Integer.parseInt(yearField.getText());
                int month = Integer.parseInt(monthField.getText());

                if (validateInputs(cowID, farmID, year, month)) {
                    WhiteCow whiteCow = new WhiteCow(cowID, farmID, year, month);
                    if (farm.canAddCow(farmID, "White")) {
                        if (farm.isCowIDUnique(cowID)) {
                            farm.addCow(cowID, farmID, "White", whiteCow);
                            JOptionPane.showMessageDialog(PageWhite.this, "White Cow registered successfully.");
                            ((StatusPage) cardPanel.getComponent(4)).refresh(); //refresh status page
                            cardLayout.show(cardPanel, "Status");
                        } else {
                            JOptionPane.showMessageDialog(PageWhite.this, "Cow ID already exists.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(PageWhite.this, "Farm already has a cow of another color.");
                    }
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(PageWhite.this, "Invalid input format.");
            }
        }

        //check the required conditions
        private boolean validateInputs(int cowID, int farmID, int year, int month) {
            if (String.valueOf(cowID).length() != 8 || cowID < 10000000) {
                JOptionPane.showMessageDialog(PageWhite.this, "Cow ID must be an 8-digit number not starting with 0.");
                return false;
            }
            if (farmID <= 0 || farmID > 9) {
                JOptionPane.showMessageDialog(PageWhite.this, "Farm ID must be a 1-digit positive number not equal to 0.");
                return false;
            }
            if (year < 0 || year > 10) {
                JOptionPane.showMessageDialog(PageWhite.this, "Year must be between 0 and 10.");
                return false;
            }
            if (month < 1 || month > 12) {
                JOptionPane.showMessageDialog(PageWhite.this, "Month must be between 1 and 12.");
                return false;
            }
            return true;
        }
    }
}

