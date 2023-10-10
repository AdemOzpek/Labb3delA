package ademo.javafxtest.shapes;

import ademo.javafxtest.FillableShape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends FillableShape {
    private double width;
    private double height;

    public Rectangle(double x, double y, double width, double height, Color color,boolean filled) {
        super(x, y, color, filled);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public void paint(GraphicsContext gc) {
        if (isFilled()){
        gc.setFill(getColor());
        gc.fillRect(getX()-width/2, getY()-height/2,width,height);}
        else {
            gc.setStroke(getColor());
            gc.strokeRect(getX()-width/2, getY()-height/2,width,height);
        }

    }
    @Override
    public void constrain(double boxX, double boxY, double boxWidth, double boxHeight) {
        super.constrain(boxX, boxY, boxWidth, boxHeight);

        // Calculate the minimum and maximum x and y coordinates within the bounding box
        double minX = boxX + width / 2;
        double maxX = boxX + boxWidth - width / 2;
        double minY = boxY + height / 2;
        double maxY = boxY + boxHeight - height / 2;

        // Constrain the rectangle within the bounding box
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
                ", width=" + width +
                ", height=" + height;
    }

}
