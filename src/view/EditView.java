package view;

import cs3500.animator.controller.EditViewController;
import cs3500.animator.model.EasyAnimatorModel;
import cs3500.animator.model.IShape;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.*;
import java.util.List;
import java.util.function.Consumer;


public class EditView extends JFrame implements View {
    EasyAnimatorModel m;
    int tick;
    ShapePanel panel;
    JScrollPane scroll;
    EditViewController c;

    public EditView(EasyAnimatorModel m){
        setSize(1000,700);
        setTitle("Easy Animator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //add(new JLabel("Test"));
        setLayout(new BorderLayout());
        tick=0;
        panel=new ShapePanel(m.getWidth(),m.getHeight());
        scroll=new JScrollPane(panel);
        scroll.setPreferredSize(new Dimension(m.getWidth(),m.getHeight()));


        c=new EditViewController(this,m);
        EditToolPanel editTools=new EditToolPanel(c);
        ButtonPanel b=new ButtonPanel(c);
        add(b, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(editTools, BorderLayout.SOUTH);





    }

    public void displayAddShapeDialog(){
        AddShapeDialog.getInstance(c).setVisible(true);
        AddShapeDialog.getInstance(c).transferFocus();
    }



    @Override
    public void run() {

        setVisible(true);
        c.go();

    }

    @Override
    public void setSpeed(int i) {
        c.setSpeed(i);

    }

    private void showKeyframeCreator(String s){
        //TODO Make a dialog for creating a keyframe...
        //Parameter s is the name of the shape that we are adding a shape to.
        c.addKeyFrame(s, 100, 100,100,100,100,100,100,100);
    }

    public void displayAddKeyFrameDialog(List<String> shapeNames){
        Consumer<String> con=new Consumer<String>(){
            @Override
            public void accept(String s) {
                showKeyframeCreator(s);
            }
        };
        SelectShapeDialog s=new SelectShapeDialog(shapeNames,c, con);
        s.setVisible(true);
    }

    public void displayRemoveShapeDialog(List<String> shapeNames){
        RemoveShapeDialog d=new RemoveShapeDialog(shapeNames, c);
        d.setVisible(true);
    }

    public void draw(List<IShape> l, int time){
        panel.draw(l, time);
    }

    @Override
    public void setAppendable(Appendable a) {

    }

}
