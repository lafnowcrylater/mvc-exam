import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FirstPage extends JPanel {
    public FirstPage(CardLayout cardLayout, JPanel cardPanel) {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        //add padding and space
        c.insets = new Insets(10, 10, 10, 10);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 3; // set to three column to center the text
        add(new JLabel("Select The Color of The Cow", JLabel.CENTER), c);

        //new buttons
        JButton whiteButton = new JButton("White Cow");
        JButton brownButton = new JButton("Brown Cow");
        JButton pinkButton = new JButton("Pink Cow");

        //add actions to buttons
        whiteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "White");
            }
        });
        brownButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Brown");
            }
        });
        pinkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Pink");
            }
        });

        //add buttons to panel
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1; //reset to single width
        c.gridx = 0;
        c.gridy = 1;
        add(whiteButton, c);
        whiteButton.setBackground(Color.WHITE);

        c.gridx = 1;
        add(brownButton, c);
        brownButton.setBackground(new Color(139,69,19));

        c.gridx = 2;
        add(pinkButton, c);
        pinkButton.setBackground(Color.PINK);
    }
}

