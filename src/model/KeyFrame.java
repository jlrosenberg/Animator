package model;

import java.util.Objects;

public class KeyFrame {
    private ShapeState state;
    private int tick;


    public KeyFrame(int tick, int x, int y, int r, int b, int g, int width, int height){
        state=new ShapeState(x,  y, r, b, g, width, height);
        this.tick=tick;
    }


    public ShapeState getShapeState(){
        return state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeyFrame keyFrame = (KeyFrame) o;
        return tick == keyFrame.tick &&
                Objects.equals(state, keyFrame.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(state, tick);
    }

    public int getTick() {
        return tick;
    }
}

