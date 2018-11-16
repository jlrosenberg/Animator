package cs3500.animator.model;


import java.util.List;
import java.util.Map;

/**
 * This interface represents the minimum functionality of a Shape object. A Shape can be interacted with by adding
 * and removing motions and keyframes. All Shape objects also have a unique string identifier, and must be able to
 * return a ShapeType that represents what type of shape it represents.
 */
public interface IShape {

    /**
     * Adds a new KeyFrame to this Shape, if it does not conflict with another KeyFrame that occurs at the same time as
     * it. If an identical KeyFrame is added at an identical time, no exception will be thrown, but if a non-identical
     * KeyFrame is added at the same time as another KeyFrame, an exception will be thrown.
     *
     * @param k the {@link KeyFrame} to be added to this IShape object.
     * @throws IllegalArgumentException
     */
    void addKeyFrame(KeyFrame k) throws IllegalArgumentException;

    /**
     * Removes the KeyFrame at tick t, if it exists. If the KeyFrame does not exist, then an IllegalArgumentException is
     * thrown.
     *
     * @param tick The tick that the KeyFrame to remove occurs at.
     * @return The KeyFrame that was removed, if the method found a KeyFrame to remove
     * @throws IllegalArgumentException if no KeyFrame exists at the specified time parameter for this shape.
     */
    KeyFrame removeKeyFrame(int tick) throws IllegalArgumentException;

    /**
     * Adds a {@link Motion} to this IShape. The added motion must occur <b>immediately after the last motion in this
     * IShape has ended</b>, in order to prevent any gaps in motion from occurring. To modify/add/change the path/motion
     * of this shape in an earlier state, add a KeyFrame instead.
     *
     * @param m
     * @throws IllegalArgumentException
     */
    void addMotion(Motion m) throws IllegalArgumentException;

    Motion removeMotion(int tick) throws IllegalArgumentException;

    /**
     * Gets the unique string identifier of this Shape.
     *
     * @return the unique string name of this shape.
     */
    String getName();

    /**
     * Returns all of the KeyFrames pertaining to this Shape.
     *
     * @return A map of all of this Shape's {@link KeyFrame}
     */
    List<KeyFrame> getKeyFrames();

    /**
     * Gets this shapes type enum.
     *
     * @return the enum ShapeType of this shape.
     */
    ShapeType getShapeType();

    /**
     * Returns a list of this shapes Motion objects, ordered by start time. The list will always contain a continuous
     * flow of back to back motions.
     *
     * @return a list of this Shape's motion objects
     */
    List<Motion> getMotions();

    //boolean isVisible();

}
