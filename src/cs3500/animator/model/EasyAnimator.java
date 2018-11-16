package cs3500.animator.model;

import cs3500.animator.util.AnimationBuilder;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class EasyAnimator implements EasyAnimatorModel {

    private Map<String, IShape> shapes;
    private int x, y, width, height;
    private int lastTick;

    public EasyAnimator(){
        shapes=new LinkedHashMap<>();
        lastTick=-1;
        x=0;
        y=0;
        width=900;
        height=900;
    }


    @Override
    public void addShape(String name, ShapeType type) throws IllegalArgumentException {
        if(shapes.containsKey(name)){
            throw new IllegalArgumentException("A Shape with this name already exists in this EasyAnimator");
        }

        shapes.put(name, new Shape(name, type));
    }

    @Override
    public void addMotion(String name, KeyFrame start, KeyFrame end) throws IllegalArgumentException {
        if(!shapes.containsKey(name)){
            throw new IllegalArgumentException("A shape with the name \""+name+"\" does not exist in this cs3500.animator.model");
        }

        shapes.get(name).addMotion(new Motion(start, end));
        if(end.getTick()>lastTick){
            lastTick=end.getTick();
        }

    }

    @Override
    public void removeShape(String name) throws IllegalArgumentException {
        if(!shapes.containsKey(name)){
            throw new IllegalArgumentException("A shape with the name \""+name+"\" does not exist in this cs3500.animator.model");
        }

        shapes.remove(name);

    }

    @Override
    public void removeMotion(String shapeName, int tick) throws IllegalArgumentException {
        throw new UnsupportedOperationException("This feature has not yet been implemented");
    }

    @Override
    public void addKeyFrame(String name,int tick, int x, int y, int r, int g, int b, int width, int height) throws IllegalArgumentException {
        KeyFrame k=new KeyFrame(tick, x, y, r, g, b, width, height);
        shapes.get(name).addKeyFrame(k);
    }

    @Override
    public void removeKeyFrame(String shapeName, int tick) throws IllegalArgumentException {

    }

    @Override
    public List<String> getShapeNames() {
        return new ArrayList(shapes.keySet());
    }

    @Override
    public List<IShape> getShapes() {
        return new ArrayList<IShape>(shapes.values());
    }

    @Override
    public int getDuration() {
        return 0;
    }

    private boolean validate(){
        return true;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    public static class Builder implements AnimationBuilder<EasyAnimator>{

        private EasyAnimator model=new EasyAnimator();

        /**
         * Constructs a final document
         *
         * @return the newly constructed document
         */
        @Override
        public EasyAnimator build() {
            if(model.validate()) {
                return model;
            }

            throw new IllegalStateException("Model is in an inconsistent state and cannot be built");
        }

        /**
         * Specify the bounding box to be used for the animation
         *
         * @param x      The leftmost x value
         * @param y      The topmost y value
         * @param width  The width of the bounding box
         * @param height The height of the bounding box
         * @return This {@link AnimationBuilder}
         */
        @Override
        public AnimationBuilder<EasyAnimator> setBounds(int x, int y, int width, int height) {
            model.x=x;
            model.y=y;
            model.width=width;
            model.height=height;
            return this;
        }

        /**
         * Adds a new shape to the growing document
         *
         * @param name The unique name of the shape to be added.
         *             No shape with this name should already exist.
         * @param type The type of shape (e.g. "ellipse", "rectangle") to be added.
         *             The set of supported shapes is unspecified, but should
         *             include "ellipse" and "rectangle" as a minimum.
         * @return This {@link AnimationBuilder}
         */
        @Override
        public AnimationBuilder<EasyAnimator> declareShape(String name, String type) {
            model.addShape(name, typeFactory(type));
            return this;
        }

        private static ShapeType typeFactory(String type){
            if(type.equals("rectangle")){
                return ShapeType.RECTANGLE;
            }else if(type.equals("ellipse")){
                return ShapeType.ELLIPSE;
            }

            throw new IllegalArgumentException("No shapetype with type \""+type+"\" exists");
        }

        /**
         * Adds a transformation to the growing document
         *
         * @param name The name of the shape (added with {@link AnimationBuilder#declareShape})
         * @param t1   The start time of this transformation
         * @param x1   The initial x-position of the shape
         * @param y1   The initial y-position of the shape
         * @param w1   The initial width of the shape
         * @param h1   The initial height of the shape
         * @param r1   The initial red color-value of the shape
         * @param g1   The initial green color-value of the shape
         * @param b1   The initial blue color-value of the shape
         * @param t2   The end time of this transformation
         * @param x2   The final x-position of the shape
         * @param y2   The final y-position of the shape
         * @param w2   The final width of the shape
         * @param h2   The final height of the shape
         * @param r2   The final red color-value of the shape
         * @param g2   The final green color-value of the shape
         * @param b2   The final blue color-value of the shape
         * @return This {@link AnimationBuilder}
         */
        @Override
        public AnimationBuilder<EasyAnimator> addMotion(String name, int t1, int x1, int y1, int w1, int h1, int r1, int g1, int b1, int t2, int x2, int y2, int w2, int h2, int r2, int g2, int b2) {
            KeyFrame start=new KeyFrame(t1, x1, y1, r1, g1, b1, w1, h1);
            KeyFrame end=new KeyFrame(t2, x2, y2, r2, g2, b2, w2, h2);
            model.addMotion(name, start, end);
            return this;
        }

        /**
         * Adds an individual keyframe to the growing document
         *
         * @param name The name of the shape (added with {@link AnimationBuilder#declareShape})
         * @param t    The time for this keyframe
         * @param x    The x-position of the shape
         * @param y    The y-position of the shape
         * @param w    The width of the shape
         * @param h    The height of the shape
         * @param r    The red color-value of the shape
         * @param g    The green color-value of the shape
         * @param b    The blue color-value of the shape
         * @return This {@link AnimationBuilder}
         */
        @Override
        public AnimationBuilder<EasyAnimator> addKeyframe(String name, int t, int x, int y, int w, int h, int r, int g, int b) {
            //TODO Implement the addKeyFrame method of the builder.
            return this;
        }
    }
}
