package view;

import cs3500.animator.model.IShape;
import cs3500.animator.model.Motion;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class ShapeFactory {

    public static Shape toAwtShape(IShape s, int time) throws IllegalStateException {
        switch (s.getShapeType()) {
            case ELLIPSE:
                return toAwtEllipse(s, time);
            case RECTANGLE:
                return toAwtRectangle(s, time);
            default:
                throw new IllegalArgumentException("ShapeFactory does not know how to build this shapeType");
        }
    }

    public static Color getColorAtTime(IShape s, int time){
        Motion m=getCurrentMotion(s, time);

        int r=(int) tween(time, m.getStart().getTick(), m.getEnd().getTick(), m.getStart().getShapeState().getR(), m.getEnd().getShapeState().getR());
        int g=(int) tween(time, m.getStart().getTick(), m.getEnd().getTick(), m.getStart().getShapeState().getG(), m.getEnd().getShapeState().getG());
        int b=(int) tween(time, m.getStart().getTick(), m.getEnd().getTick(), m.getStart().getShapeState().getB(), m.getEnd().getShapeState().getB());

        return new Color(r, g, b);
    }

    private static Shape toAwtEllipse(IShape s, int time) throws IllegalStateException{
        Motion m=getCurrentMotion(s, time);

        double newX=tween(time, m.getStart().getTick(), m.getEnd().getTick(), m.getStart().getShapeState().getX(), m.getEnd().getShapeState().getX());
        double newY=tween(time, m.getStart().getTick(), m.getEnd().getTick(), m.getStart().getShapeState().getY(), m.getEnd().getShapeState().getY());
        double newW=tween(time, m.getStart().getTick(), m.getEnd().getTick(), m.getStart().getShapeState().getWidth(), m.getEnd().getShapeState().getWidth());
        double newH=tween(time, m.getStart().getTick(), m.getEnd().getTick(), m.getStart().getShapeState().getHeight(), m.getEnd().getShapeState().getHeight());

        return new Ellipse2D.Double(newX, newY, newW, newH);
    }

    private static Shape toAwtRectangle(IShape s, int time) throws IllegalStateException{
        Motion m=getCurrentMotion(s, time);

        int newX=(int)tween(time, m.getStart().getTick(), m.getEnd().getTick(), m.getStart().getShapeState().getX(), m.getEnd().getShapeState().getX());
        int newY=(int)tween(time, m.getStart().getTick(), m.getEnd().getTick(), m.getStart().getShapeState().getY(), m.getEnd().getShapeState().getY());
        int newW=(int)tween(time, m.getStart().getTick(), m.getEnd().getTick(), m.getStart().getShapeState().getWidth(), m.getEnd().getShapeState().getWidth());
        int newH=(int)tween(time, m.getStart().getTick(), m.getEnd().getTick(), m.getStart().getShapeState().getHeight(), m.getEnd().getShapeState().getHeight());

        return new Rectangle(newX, newY, newW, newH);
    }

    private static Motion getCurrentMotion(IShape s, int time) throws IllegalStateException{
        for(Motion m:s.getMotions()){
            if(m.inAction(time)){
                return m;
            }
        }

        throw new IllegalStateException("Shape "+s.getName()+" is not visible at time: "+time);

    }




    protected static double tween(double t, double startTime, double endTime, double a, double b) {
        if(a==b){
            return a;
        }

        double result = 0;

        double aMult = ((double) (endTime - t) / ((double) (endTime - startTime)));
        double bMult = ((double) (t - startTime) / ((double) (endTime - startTime)));

        double interResult = a * aMult + b * bMult;

        result = (int) interResult;

        //System.out.println(t + " result " + result);
        return result;
    }

}
