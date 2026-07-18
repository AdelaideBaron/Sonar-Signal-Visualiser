package com.addi;

import javax.swing.*;
import java.awt.*;

public class InfoTablePanel extends JPanel {

    //   JPanel bottomPanel = new JPanel();
    //        bottomPanel.setBackground(Color.BLACK);

    public InfoTablePanel(double frequency){
        setBackground(Color.BLACK);

        add(new DigitalClockPanel());
        add(createFrequencyDisplay(frequency));
    }

    private JLabel createFrequencyDisplay(double frequency){
        JLabel frequencyDisplay = new JLabel(String.format("frequency: %g Hz",frequency));

        frequencyDisplay.setForeground(Color.GREEN);
        frequencyDisplay.setFont(
                new Font("Monospaced", Font.BOLD, 12)
        );

        return frequencyDisplay;

    }

}
