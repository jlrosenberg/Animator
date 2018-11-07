package model;

public class KeyFrame {
    private double height;
    private double width;
    private double r;
    private double b;
    private double g;
    private double x;
    private double y;
    private int tick;


    public KeyFrame(double width, double height, double r, double b, double g, double x, double y, int tick) {
        this.height = height;
        this.width = width;
        this.r = r;
        this.b = b;
        this.g = g;
        this.x = x;
        this.y = y;
        this.tick=tick;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getG() {
        return g;
    }

    public void setG(double g) {
        this.g = g;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getTick(){
        return tick;
    }
}
