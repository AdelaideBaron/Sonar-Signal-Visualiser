package com.addi.UITesting;

import static org.junit.jupiter.api.Assertions.*;

import com.addi.HomePanel;
import com.addi.WaveGrid;
import java.awt.*;
import javax.swing.*;
import org.junit.jupiter.api.Test;

class HomePanelUITest extends UITest {

  @Test
  void panelBackgroundIsBlack() throws Exception {
    HomePanel panel = createPanel();

    assertEquals(Color.BLACK, panel.getBackground());
  }

  @Test
  void panelHasExpectedPreferredSize() throws Exception {
    HomePanel panel = createPanel();

    assertEquals(new Dimension(800, 500), panel.getPreferredSize());
  }

  @Test
  void panelContainsSonarConsoleTitle() throws Exception {
    HomePanel panel = createPanel();

    JLabel title = findLabelByName(panel, "sonarConsoleLabel");

    assertNotNull(title);
    assertEquals("SONAR CONSOLE", title.getText());
  }

  @Test
  void titleTextIsGreen() throws Exception {
    HomePanel panel = createPanel();

    JLabel title = findLabelByName(panel, "sonarConsoleLabel");

    assertNotNull(title);
    assertEquals(Color.GREEN, title.getForeground());
  }

  @Test
  void titleIsCentred() throws Exception {
    HomePanel panel = createPanel();

    JLabel title = findLabelByName(panel, "sonarConsoleLabel");

    assertNotNull(title);
    assertEquals(SwingConstants.CENTER, title.getHorizontalAlignment());
  }

  @Test
  void panelContainsWaveGrid() throws Exception {
    HomePanel panel = createPanel();

    assertNotNull(panel.getWaveGrid());
    assertTrue(panel.getWaveGrid() instanceof WaveGrid);
  }
}
