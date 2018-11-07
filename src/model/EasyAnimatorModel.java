package model;

import java.util.List;

public interface EasyAnimatorModel {

    void addShape(String name);

    void addKeyFrame(String name, int x, int y, int r, int b, int g, int width, int height) throws IllegalArgumentException;

    List<String> getShapeNames();






}