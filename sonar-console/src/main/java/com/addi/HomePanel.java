package com.addi;

import java.awt.*;
import javax.swing.*;

public class HomePanel extends JPanel {

  private static final double INITIAL_FREQUENCY_HZ = 0.5;

  private final WaveGrid waveGrid;

  public HomePanel() {
    setLayout(new BorderLayout());
    setPreferredSize(new Dimension(800, 500));
    setBackground(Color.BLACK);

    setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

    JLabel title = createTitle();

    waveGrid = new WaveGrid(INITIAL_FREQUENCY_HZ);

    add(title, BorderLayout.NORTH);
    add(waveGrid, BorderLayout.CENTER);

    add(new InfoTablePanel(INITIAL_FREQUENCY_HZ), BorderLayout.SOUTH);

    waveGrid.startAnimation();
  }

  private JLabel createTitle() {
    JLabel title = new JLabel("SONAR CONSOLE", SwingConstants.CENTER);

    title.setName("sonarConsoleLabel");

    title.setForeground(Color.GREEN);
    title.setFont(new Font("Monospaced", Font.BOLD, 24));

    return title;
  }

  public WaveGrid getWaveGrid() {
    return waveGrid;
  }
}
