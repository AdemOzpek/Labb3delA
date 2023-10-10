package ademo.javafxtest;

import ademo.javafxtest.shapes.Shape;
import javafx.scene.paint.Color;

public abstract class FillableShape extends Shape {
    private boolean filled;
    protected FillableShape(double x, double y, Color color,boolean filled) {
        super(x, y, color);
        this.filled = filled;
    }
    public boolean isFilled(){
        if(filled) return true;
        else return false;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
}
