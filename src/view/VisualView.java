package view;

import cs3500.animator.model.EasyAnimatorModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VisualView extends JFrame implements View, ActionListener {

    EasyAnimatorModel m;
    int tick;
    Timer timer;
    ShapePanel panel;
    JScrollPane scroll;

    public VisualView(EasyAnimatorModel m){
        setSize(m.getWidth(),m.getHeight());
        setTitle("Easy Animator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //add(new JLabel("Test"));
        tick=0;
        this.m=m;
        timer=new Timer(150, this);
        panel=new ShapePanel(m.getWidth(),m.getHeight());
        scroll=new JScrollPane(panel);
        scroll.setPreferredSize(new Dimension(m.getWidth(),m.getHeight()));
        add(scroll);
    }

    @Override
    public void run() {

        setVisible(true);
        timer.start();

    }

    @Override
    public void setSpeed(int i) {
        timer.setDelay(1000/i);
    }

    @Override
    public void setAppendable(Appendable a) {

    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        tick++;
        panel.draw(m.getShapes(), tick);
        //repaint();
    }
}
