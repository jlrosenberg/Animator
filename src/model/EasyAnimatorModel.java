package model;

import java.util.List;
import java.util.Map;

public interface EasyAnimatorModel {

    void addShape(String name) throws IllegalArgumentException;

    //void addKeyFrame(String name, int x, int y, int r, int b, int g, int width, int height) throws IllegalArgumentException;

    void addMotion(String name, KeyFrame start, KeyFrame end) throws IllegalArgumentException;

    void removeShape(String name) throws IllegalArgumentException;

    //void removeKeyFrame(String shapeName, int tick) throws IllegalArgumentException;

    void removeMotion(String shapeName, int tick) throws IllegalArgumentException;

    List<String> getShapeNames();

    List<IShape> getShapes();

    //List<ShapeState> getCurrentShapeStates();

    int getDuration();










}