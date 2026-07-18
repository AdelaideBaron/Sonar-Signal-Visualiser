package com.addi;



import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DigitalClockPanel extends JPanel {

    private static final DateTimeFormatter TIME_FORMAT =
            DateTimeFormatter.ofPattern("HH:mm:ss");

    private final JLabel timeLabel = new JLabel();

    public DigitalClockPanel() {
        setBackground(Color.BLACK);
        timeLabel.setName("timeLabel");
        timeLabel.setForeground(Color.GREEN);
        timeLabel.setFont(
                new Font("Monospaced", Font.BOLD, 22)
        );

        add(timeLabel);

        updateClock();

        Timer timer = new Timer(
                1000,
                event -> updateClock()
        );

        timer.start();
    }

    private void updateClock() {
        String currentTime =
                LocalTime.now().format(TIME_FORMAT);

        timeLabel.setText(currentTime);
    }
}

