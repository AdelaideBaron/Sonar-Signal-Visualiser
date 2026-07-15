package com.addi;

import javax.swing.*;
import java.awt.*;

public class Main {
    static void main() {
        JFrame frame = new JFrame("sonar-console");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        HomePanel homePanel = new HomePanel();
        frame.setContentPane(homePanel);

        frame.pack();
        frame.setVisible(true);
    }
}
