package cs3500.animator.model;

import java.util.List;

public interface EasyAnimatorModel {

    void addShape(String name, ShapeType type) throws IllegalArgumentException;

    void addKeyFrame(String name,int tick, int x, int y, int r, int b, int g, int width, int height) throws IllegalArgumentException;

    void addMotion(String name, KeyFrame start, KeyFrame end) throws IllegalArgumentException;

    void removeShape(String name) throws IllegalArgumentException;

    void removeKeyFrame(String shapeName, int tick) throws IllegalArgumentException;

    void removeMotion(String shapeName, int tick) throws IllegalArgumentException;

    List<String> getShapeNames();

    List<IShape> getShapes();

    //List<ShapeState> getCurrentShapeStates();

    int getDuration();

    int getHeight();

    int getWidth();

    int getX();

    int getY();












}