package com.addi.UITesting;

import com.addi.InfoTablePanel;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class InfoTableUITest extends UITest {
    @Test
    void backgroundIsBlack() {
        InfoTablePanel panel = new InfoTablePanel(0.5);

        assertEquals(Color.BLACK, panel.getBackground());
    }

    @Test
    void frequencyLabelExists() {
        InfoTablePanel panel = new InfoTablePanel(0.5);

        JLabel label = findLabelByName(panel, "frequencyLabel");

        assertNotNull(label);
    }

    @Test
    void frequencyTextIsCorrect() {
        InfoTablePanel panel = new InfoTablePanel(0.5);

        JLabel label = findLabelByName(panel, "frequencyLabel"); // todo update this one

        assertEquals("frequency: 0.500000 Hz", label.getText());
    }

    @Test
    void frequencyLabelIsGreen() {
        InfoTablePanel panel = new InfoTablePanel(0.5);

        JLabel label = findLabelByName(panel, "frequencyLabel");

        assertEquals(Color.GREEN, label.getForeground());
    }
}
