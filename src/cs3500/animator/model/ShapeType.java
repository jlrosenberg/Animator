package cs3500.animator.model;

public enum ShapeType {

    RECTANGLE("Rectangle"), ELLIPSE("Ellipse");

    private String value;

    ShapeType(String toString){
        value=toString;
    }

    public String toString(){
        return value;
    }

}
