package ademo.javafxtest.shapes;

import ademo.javafxtest.FillableShape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends FillableShape{
    private double diameter;
    public Circle(double x, double y, double diameter, Color color, boolean filled){
        super(x, y, color,filled);
        this.diameter = diameter;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    @Override
    public void paint(GraphicsContext gc) {
        if(isFilled()){
            gc.setFill(getColor());
            gc.fillOval(getX()-diameter/2,getY()-diameter/2,diameter,diameter);
        }

        else {
            gc.setStroke(getColor());
            gc.strokeOval(getX() - diameter / 2, getY() - diameter / 2, diameter, diameter);
        }
    }
    @Override
    public void constrain(double boxX, double boxY, double boxWidth, double boxHeight) {
        super.constrain(boxX, boxY, boxWidth, boxHeight);

        // Calculate the minimum and maximum x and y coordinates within the bounding box
        double minX = boxX + diameter / 2;
        double maxX = boxX + boxWidth - diameter / 2;
        double minY = boxY + diameter / 2;
        double maxY = boxY + boxHeight - diameter / 2;

        // Constrain the circle within the bounding box
        if (getX() < minX) {
            setVelocity(Math.abs(getDx()),getDy());
        } else if (getX() > maxX) {
            setVelocity(-Math.abs(getDx()),getDy());
        }

        if (getY() < minY) {
            setVelocity(getDx(),Math.abs(getDy()));
        } else if (getY() > maxY) {
            setVelocity(getDx(),-Math.abs(getDy()));
        }

    }

    @Override
    public String toString() {
        return super.toString() +
                ", diameter=" + diameter;
    }
}
