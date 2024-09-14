import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        //ensures concurrency safety
        SwingUtilities.invokeLater(() -> {
            //adding frame
            JFrame frame = new JFrame("Cow Registration");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300); 
            CardLayout cardLayout = new CardLayout();
            JPanel cardPanel = new JPanel(cardLayout);

            Farms farm = new Farms();

            //create and add pages
            FirstPage page1 = new FirstPage(cardLayout, cardPanel);
            PageWhite pageWhite = new PageWhite(cardLayout, cardPanel, farm);
            PageBrown pageBrown = new PageBrown(cardLayout, cardPanel, farm);
            PagePink pagePink = new PagePink(cardLayout, cardPanel, farm);
            StatusPage statusPage = new StatusPage(cardLayout, cardPanel, farm);

            cardPanel.add(page1, "Home");
            cardPanel.add(pageWhite, "White");
            cardPanel.add(pageBrown, "Brown");
            cardPanel.add(pagePink, "Pink");
            cardPanel.add(statusPage, "Status");

            frame.add(cardPanel);
            frame.setVisible(true);
        });
    }
}
