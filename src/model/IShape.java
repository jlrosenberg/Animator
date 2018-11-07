package model;


import java.util.List;
import java.util.Map;

public interface IShape {

    void addKeyFrame(int tick, KeyFrame k) throws IllegalArgumentException;

    KeyFrame removeKeyFrame(int tick);

    String getName();

    /**
     * Returns all of the KeyFrames pertaining to this Shape.
     * @return A map of all of this Shape's {@link KeyFrame}
     */
    Map<Integer, KeyFrame> getKeyFrames();

    ShapeType getShapeType();

}
