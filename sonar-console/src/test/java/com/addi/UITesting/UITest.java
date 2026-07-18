package com.addi.UITesting;

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
}
