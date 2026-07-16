        package com.addi;

import javax.swing.*;
import java.awt.*;

public class HomePanel extends JPanel {

    private static final double INITIAL_FREQUENCY_HZ = 0.5;

    private final WaveGrid waveGrid;

    public HomePanel() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(800, 500));
        setBackground(Color.BLACK);

        setBorder(
                BorderFactory.createEmptyBorder(
                        30,
                        30,
                        30,
                        30
                )
        );

        JLabel title = createTitle();
        JLabel frequencyText = createFrequencyDisplay(INITIAL_FREQUENCY_HZ);

        waveGrid = new WaveGrid(INITIAL_FREQUENCY_HZ);

        add(title, BorderLayout.NORTH);
        add(waveGrid, BorderLayout.CENTER);

        // todo move this into a new class, should be 'infotable' or something
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.BLACK);

        bottomPanel.add(new DigitalClockPanel());
        bottomPanel.add(frequencyText);

        add(bottomPanel, BorderLayout.SOUTH);


//        add(new DigitalClockPanel(), BorderLayout.SOUTH);
//        add(frequencyText, BorderLayout.SOUTH);

        waveGrid.startAnimation();
    }

    private JLabel createTitle() {
        JLabel title = new JLabel(
                "SONAR CONSOLE",
                SwingConstants.CENTER
        );

        title.setForeground(Color.GREEN);
        title.setFont(
                new Font("Monospaced", Font.BOLD, 24)
        );

        return title;
    }

    private JLabel createFrequencyDisplay(double frequency){
        JLabel frequencyDisplay = new JLabel("frequency: {}".formatted(frequency));

        frequencyDisplay.setForeground(Color.GREEN);
        frequencyDisplay.setFont(
                new Font("Monospaced", Font.BOLD, 12)
        );

        return frequencyDisplay;

    }

    public WaveGrid getWaveGrid() {
        return waveGrid;
    }
}
