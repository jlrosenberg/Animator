package cs3500.animator;

import cs3500.animator.model.EasyAnimator;
import cs3500.animator.util.AnimationReader;
import view.EditView;
import view.VisualView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        EasyAnimator m= AnimationReader.parseFile(new FileReader(new File("buildings.txt")), new EasyAnimator.Builder());

        EditView v=new EditView(m);
        v.run();
    }
}
