package com.addi;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

class HomePanelTest {

    @Test
    void shouldHaveExpectedPreferredSize() throws Exception {
        HomePanel panel = createPanelOnEdt();

        assertEquals(new Dimension(800, 500), panel.getPreferredSize());
    }

    @Test
    void shouldHaveBlackBackground() throws Exception {
        HomePanel panel = createPanelOnEdt();

        assertEquals(Color.BLACK, panel.getBackground());
    }

    @Test
    void shouldDisplaySonarConsoleTitle() throws Exception {
        HomePanel panel = createPanelOnEdt();
//         todo update tests to use a beforeeach

        assertEquals(1, panel.getComponentCount());

        JLabel title = (JLabel) panel.getComponent(0);

        assertEquals("SONAR CONSOLE", title.getText());    }

    @Test
    void shouldDisplayTitleInGreen() throws Exception {
        HomePanel panel = createPanelOnEdt();

        JLabel title = (JLabel) panel.getComponent(0);

        assertEquals(Color.GREEN, title.getForeground());

    }

    private HomePanel createPanelOnEdt()
            throws InvocationTargetException, InterruptedException {

        HomePanel[] result = new HomePanel[1];

        SwingUtilities.invokeAndWait(() ->
                result[0] = new HomePanel()
        );

        return result[0];
    }
}
