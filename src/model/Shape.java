package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shape implements IShape {
    private String name;
    //private List<Integer> sortedKeyTimes;
    private Map<Integer, KeyFrame> keyFrames;
    private List<Motion> motions;
    private ShapeType type;

    /**
     * Creates a new shape object.
     * @param name
     * @param type
     */
    public Shape(String name, ShapeType type) {
        this.name = name;
        this.type = type;
        motions = new ArrayList<Motion>();
        keyFrames = new HashMap<Integer, KeyFrame>();
    }


    //TODO implement addKeyFrame
    @Override
    public void addKeyFrame(KeyFrame k) throws IllegalArgumentException {
        throw new UnsupportedOperationException("The addKeyFrame() method has not yet been implemented in this class");
    }

    //TODO implement removeKeyFrame
    @Override
    public KeyFrame removeKeyFrame(int tick) {
        throw new UnsupportedOperationException("The removeKeyFrame() method has not yet been implemented in this class");
    }

    @Override
    public void addMotion(Motion m) throws IllegalArgumentException {
        for (Integer i : keyFrames.keySet()) {
            //If there is any overlap at all, this will be true for said keyFrame
            if (i >= m.getStart().getTick() && i <= m.getEnd().getTick()) {
                //This if statement will be false iff the keyFrame occurs at the start or end tick of the motion AND
                //has all of the same values (i.e. is equal). If it is true, then we throw an exception since there
                //is conflict with this motion we are trying to add.
                if (!(keyFrames.get(i).equals(m.getStart()) || keyFrames.get(i).equals(m.getEnd()))) {
                    throw new IllegalArgumentException("This motion conflicts with one or more motions/keyFrames " +
                            "that have already been applied to this Shape.");
                }
            }
        }


        //If we have made it to here, them motion does not conflict, so we can add it to the model, and also add the new
        //KeyFrame
        motions.add(m);
        if(!keyFrames.containsKey(m.getStart().getTick())){
            keyFrames.put(m.getStart().getTick(), m.getStart());
        }
        keyFrames.put(m.getEnd().getTick(), m.getEnd());

        //Check if we have conflicting KeyFrame objects. If we do then throw an exception - this will
        // prevent overlapping motions. It will not enforce that there are no gaps in the animation however, perhaps we can tackle that later...
    }

    //TODO implement removeMotions
    @Override
    public Motion removeMotion(int tick) throws IllegalArgumentException {
        throw new UnsupportedOperationException("The removeMotion() method has not yet been implemented in this class");
        //return null;
    }


    @Override
    public String getName() {
        return name;
    }

    /**
     * Returns all of the KeyFrames pertaining to this Shape.
     *
     * @return A map of all of this Shape's {@link KeyFrame}
     */
    @Override
    public Map<Integer, KeyFrame> getKeyFrames() {
        return null;
    }

    @Override
    public ShapeType getShapeType() {
        return type;
    }


}
