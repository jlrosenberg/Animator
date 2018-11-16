package view;

import cs3500.animator.model.EasyAnimatorModel;
import cs3500.animator.model.IShape;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ShapePanel extends JPanel {

    private List<IShape> shapes;
    private int time;

    public ShapePanel(int width, int height){
        setPreferredSize(new Dimension(width, height));
        setVisible(true);
        time=0;
        shapes=new ArrayList<>();
    }


    public void draw(List<IShape> l, int time){
        shapes=l;
        this.time=time;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d=(Graphics2D)g;
        for(IShape s:shapes){
            try {
                Shape awtShape = ShapeFactory.toAwtShape(s, time);
                g2d.setColor(ShapeFactory.getColorAtTime(s, time));
                g2d.fill(awtShape);
            }catch(Exception e){
                //System.out.println(e.getMessage());
            }

        }
    }



}
