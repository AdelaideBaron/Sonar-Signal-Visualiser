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