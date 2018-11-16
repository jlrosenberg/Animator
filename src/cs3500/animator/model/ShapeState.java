package cs3500.animator.model;

import java.util.Objects;

public class ShapeState {
    private double height;
    private double width;
    private double r;
    private double b;
    private double g;
    private double x;
    private double y;

    public ShapeState(double x, double y, double r, double g, double b, double width, double height) {
        this.height = height;
        this.width = width;
        this.r = r;
        this.b = b;
        this.g = g;
        this.x = x;
        this.y = y;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getR() {
        return r;
    }

    public double getB() {
        return b;
    }

    public double getG() {
        return g;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShapeState that = (ShapeState) o;
        return Double.compare(that.height, height) == 0 &&
                Double.compare(that.width, width) == 0 &&
                Double.compare(that.r, r) == 0 &&
                Double.compare(that.b, b) == 0 &&
                Double.compare(that.g, g) == 0 &&
                Double.compare(that.x, x) == 0 &&
                Double.compare(that.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, width, r, b, g, x, y);
    }
}
