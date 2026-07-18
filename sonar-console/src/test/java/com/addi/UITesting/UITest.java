package com.addi.UITesting;

import com.addi.HomePanel;

import javax.swing.*;
import java.awt.*;

public class UITest {

    protected static JLabel findLabelByName(Container container, String name) {
        for (Component component : container.getComponents()) {
            if (component instanceof JLabel label
                    && name.equals(label.getName())) {
                return label;
            }

            if (component instanceof Container childContainer) {
                JLabel result = findLabelByName(childContainer, name);

                if (result != null) {
                    return result;
                }
            }
        }

        return null;
    }

    protected HomePanel createPanel() throws Exception {
        HomePanel[] result = new HomePanel[1];

        SwingUtilities.invokeAndWait(() -> result[0] = new HomePanel());

        return result[0];
    }
}
