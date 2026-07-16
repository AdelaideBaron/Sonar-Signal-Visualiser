# What the app will do 

### inputs
The user enters:

- Frequency (Hz)
- Amplitude
- Noise Level
- Phase Offset (degrees)

Then clicks Display Signal, and a custom Swing panel draws the waveform

### output 

The application will display:

- A waveform
- Current frequency
- Current amplitude
- Current phase
- Current noise level

The waveform should redraw whenever new values are submitted

### validations
- reject invalid values:
  - Frequency must be greater than zero.
  - Amplitude must be greater than zero.
  - Noise level cannot be negative.
  - Phase should be between 0° and 360°.

Display a dialog explaining the error.

# Example layout 
```
+-----------------------------------------------------------+
| Frequency: [      ] Hz                                    |
| Amplitude: [      ]                                       |
| Phase:     [      ] °                                     |
| Noise:     [      ]                                       |
|                                                          |
|              [ Display Signal ]                          |
+-----------------------------------------------------------+
|                                                          |
|                                                          |
|             Signal Display Area                          |
|                                                          |
|                                                          |
+-----------------------------------------------------------+
| Status Bar                                               |
+-----------------------------------------------------------+
```

# Maths 

The signal is represented by a sine wave.

### Basic equation

`signal = amplitude × sin(angle)`

where `angle = 2π × frequency × time`

## Phase 
**Phase shifts the waveform**

* Convert degrees to radians
`phaseRadians = phaseDegrees × π / 180`

### Updated equation

`signal = amplitude × sin(2π × frequency × time + phaseRadians)`

## Noise

**Noise is unwanted random interference**

`displayedSignal = signal + noise`

# Resources
As this is a development project for me, I'll document some resources 

* https://web.mit.edu/6.005/www/sp14/psets/ps4/java-6-tutorial/components.html

### Wave mover
timer ticks -> increase phase -> store new phase in SineWave -> call repaint() -> Swing calls paintComponent() -> wave is drawn at its new position

To draw, we want to call Wave Grid paintComponent multiple times, perhaps every second? And just update the phase and then re-display?

To start, I'll implement a timer and just display the seconds... 

So now, I'll need the frequency? This is in Hz -> /s 
- so repaint every 1/4 second? 
- I'll want to move the wave phase pi / 2?

Logic: 
- get the frequency 
- Every 1/4 second, repaint 
- want to figure out where it'll be at 0.25 seconds later 
- so it'll have moved 1/4 * the frequency * 360° 
- phase for the sine wave: 
```java
    /**
     * PHASES
     *
     * 0°    normal starting position
     * 90°   shifted right by one quarter-cycle
     * 180°  shifted right by half a cycle
     * 270°  shifted right by three quarters
     * 360°  visually identical to 0°
     */
```

So if the frequency is 2Hz - after 0.25 seconds it'll have moved 2 * 0.25 * 360° -> 180°