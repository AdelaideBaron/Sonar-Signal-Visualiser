package com.addi;

import java.awt.*;
import javax.swing.*;

public class InfoTablePanel extends JPanel {

  public InfoTablePanel(double frequency) {
    setBackground(Color.BLACK);

    add(new DigitalClockPanel());
    add(createFrequencyDisplay(frequency));
  }

  private JLabel createFrequencyDisplay(double frequency) {
    JLabel frequencyDisplay = new JLabel(String.format("frequency: %g Hz", frequency));

    frequencyDisplay.setName("frequencyLabel");
    frequencyDisplay.setForeground(Color.GREEN);
    frequencyDisplay.setFont(new Font("Monospaced", Font.BOLD, 12));

    return frequencyDisplay;
  }
}
