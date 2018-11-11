package model;

import java.util.Objects;

public class Motion {

    private KeyFrame start;
    private KeyFrame end;

    public Motion(KeyFrame start, KeyFrame end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Motion motion = (Motion) o;
        return start.equals(motion.start) &&
               end.equals(motion.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    public KeyFrame getStart() {
        return start;
    }

    public KeyFrame getEnd() {
        return end;
    }
}
