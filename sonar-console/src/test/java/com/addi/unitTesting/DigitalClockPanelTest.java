package com.addi.unitTesting;

import static org.junit.jupiter.api.Assertions.*;

import com.addi.DigitalClockPanel;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.regex.Pattern;
import javax.swing.*;
import org.junit.jupiter.api.Test;

class DigitalClockPanelTest {

  private static final Pattern TIME_PATTERN = Pattern.compile("\\d{2}:\\d{2}:\\d{2}");

  @Test
  void shouldBeAJPanel() throws Exception {
    DigitalClockPanel panel = createPanelOnEdt();

    assertInstanceOf(JPanel.class, panel);
  }

  @Test
  void shouldHaveBlackBackground() throws Exception {
    DigitalClockPanel panel = createPanelOnEdt();

    assertEquals(Color.BLACK, panel.getBackground());
  }

  @Test
  void shouldContainOneLabel() throws Exception {
    DigitalClockPanel panel = createPanelOnEdt();

    assertEquals(1, panel.getComponentCount());
    assertInstanceOf(JLabel.class, panel.getComponent(0));
  }

  @Test
  void shouldDisplayTimeInHoursMinutesAndSecondsFormat() throws Exception {

    DigitalClockPanel panel = createPanelOnEdt();
    JLabel timeLabel = getTimeLabel(panel);

    assertTrue(
        TIME_PATTERN.matcher(timeLabel.getText()).matches(),
        "Expected time in HH:mm:ss format but was: " + timeLabel.getText());
  }

  @Test
  void shouldDisplayGreenText() throws Exception {
    DigitalClockPanel panel = createPanelOnEdt();
    JLabel timeLabel = getTimeLabel(panel);

    assertEquals(Color.GREEN, timeLabel.getForeground());
  }

  @Test
  void shouldUseBoldMonospacedFontAtTwentyTwoPoints() throws Exception {

    DigitalClockPanel panel = createPanelOnEdt();
    JLabel timeLabel = getTimeLabel(panel);

    Font font = timeLabel.getFont();

    assertEquals(Font.MONOSPACED, font.getFamily());
    assertTrue(font.isBold());
    assertEquals(22, font.getSize());
  }

  @Test
  void shouldUpdateDisplayedTimeAfterTimerTick() throws Exception {

    DigitalClockPanel panel = createPanelOnEdt();
    JLabel timeLabel = getTimeLabel(panel);

    String originalTime = timeLabel.getText();

    Thread.sleep(1_100);

    String updatedTime = getLabelTextOnEdt(timeLabel);

    assertNotEquals(originalTime, updatedTime, "Expected the clock to update after one second");
  }

  private DigitalClockPanel createPanelOnEdt()
      throws InvocationTargetException, InterruptedException {

    DigitalClockPanel[] result = new DigitalClockPanel[1];

    SwingUtilities.invokeAndWait(() -> result[0] = new DigitalClockPanel());

    return result[0];
  }

  private JLabel getTimeLabel(DigitalClockPanel panel) {
    return (JLabel) panel.getComponent(0);
  }

  private String getLabelTextOnEdt(JLabel label)
      throws InvocationTargetException, InterruptedException {

    String[] result = new String[1];

    SwingUtilities.invokeAndWait(() -> result[0] = label.getText());

    return result[0];
  }
}
