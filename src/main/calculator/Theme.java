package main.calculator;

import java.awt.*;

public class Theme {
    private String name;
    private Color backgroundColor;
    private Color numberColor;
    private Color functionColor;
    private Color controlColor;
    private Color textColor;

    public Theme(String name, Color backgroundColor, Color numberColor, Color functionColor, Color controlColor, Color textColor) {
        this.name = name;
        this.backgroundColor = backgroundColor;
        this.numberColor = numberColor;
        this.functionColor = functionColor;
        this.controlColor = controlColor;
        this.textColor = textColor;
    }

    public Color getNumberColor() {
        return numberColor;
    }

    public Color getFunctionColor() {
        return functionColor;
    }

    public Color getControlColor() {
        return controlColor;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public Color getTextColor() {
        return textColor;
    }

    @Override
    public String toString() {
        return name;
    }
}
