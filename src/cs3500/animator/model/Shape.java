package cs3500.animator.model;

import java.util.*;

/**
 * This class defines a Shape to be a collection of {@link Motion}s. It enforces the idea that Motions must be placed
 * back to back in a continuous order with no gaps. Thus, Motions can only be added at the end of the current last
 * Motion in this object. However, the motion of a Shape can be modified by adding a {@link KeyFrame}. KeyFrames at any
 * positive, nonzerotick, and will break apart motions and interpolate them as needed.
 *
 * All Shape objects also have an associated {@link ShapeType} that represents the type of Shape it is.
 */
public class Shape implements IShape {
    private String name;
    //private List<Integer> sortedKeyTimes;
    private Map<Integer, KeyFrame> keyFrames;
    private List<Motion> motions;
    private ShapeType type;

    /**
     * Creates a new shape object.
     * @param name the string name of this Shape - should be unique.
     * @param type the {@link ShapeType} of this Shape that describes what type of Shape that it is.
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
        if(keyFrames.containsKey(k.getTick())){
            throw new IllegalArgumentException("A Keyframe at time +"+k.getTick()+" already exists");
        }

        try{
            Motion toSplit = getMotionInAction(k.getTick());
            Motion new1=new Motion(toSplit.getStart(), k);
            Motion new2=new Motion(k, toSplit.getEnd());
            motions.add(new1);
            motions.add(new2);
            Collections.sort(motions);
        }catch(IllegalArgumentException e){
            Motion last=motions.get(motions.size()-1);
            motions.add(new Motion(last.getEnd(), k));
            //We're adding on after the last motion has completed.
        }


    }

    private Motion getMotionInAction(int t){
        for(Motion m:motions){
            if(m.inAction(t)){
                return m;
            }

        }

        throw new IllegalArgumentException("No motion in action for this shape at time "+t);
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


        //If we have made it to here, them motion does not conflict, so we can add it to the cs3500.animator.model, and also add the new
        //KeyFrame
        motions.add(m);
        if(!keyFrames.containsKey(m.getStart().getTick())){
            keyFrames.put(m.getStart().getTick(), m.getStart());
        }

        if(!keyFrames.containsKey(m.getEnd().getTick())){
            keyFrames.put(m.getEnd().getTick(), m.getEnd());
        }


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

    //TODO Do we really want to return a map of keyFrames? or would it be better to return an (ordered) list.
    /**
     * Returns all of the KeyFrames pertaining to this Shape.
     *
     * @return A map of all of this Shape's {@link KeyFrame}
     */
    @Override
    public List<KeyFrame> getKeyFrames() {
        List<KeyFrame> l=new ArrayList<>(keyFrames.values());
        Collections.sort(l);
        return l;
    }

    @Override
    public ShapeType getShapeType() {
        return type;
    }

    /**
     * Returns a list of this shapes Motion objects, ordered by start time. The list will always contain a continuous
     * flow of back to back motions.
     *
     * @return a list of this Shape's motion objects
     */
    @Override
    public List<Motion> getMotions() {
        List<Motion> temp=new ArrayList<Motion>();
        temp.addAll(this.motions);
        return temp;
    }
}
