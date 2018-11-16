package cs3500.animator.controller;

import cs3500.animator.model.*;
import view.EditView;
import view.View;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.util.HashMap;

public class EditViewController implements ActionListener, ChangeListener {
    private EasyAnimatorModel m;
    private EditView v;
    private Timer timer;
    private int tick;
    private boolean isLooping;
    private boolean isPaused;
    private int lastTick;
    private HashMap<String, Runnable> commands;

    public EditViewController(EditView v, EasyAnimatorModel m){
        this.v=v;
        this.m=m;
        lastTick=0;
        timer=new Timer(1000, this);
        timer.setActionCommand("tick");
        tick=0;
        isLooping=false;
        isPaused=true;
        calculateLastTick();
        commands=new HashMap<>();
        initCommands();
    }

    private void initCommands(){
        commands.put("tick", new Runnable(){
            @Override
            public void run() {
                if(tick<lastTick) {
                    tick++;
                    v.draw(m.getShapes(), tick);
                }else if(tick>=lastTick && isLooping){
                    tick=1;
                    v.draw(m.getShapes(), tick);
                }

            }
        });

        commands.put("playpause", new Runnable(){
            @Override
            public void run() {
                if(timer.isRunning()){
                    timer.stop();
                }else{
                    timer.start();
                }
            }
        });

        commands.put("toggleloop", new Runnable(){
            @Override
            public void run() {
                isLooping = !isLooping;
            }
        });

        commands.put("restart", new Runnable(){
            @Override
            public void run() {
                tick=1;
                v.draw(m.getShapes(), 1);
            }
        });

        commands.put("addshape", new Runnable(){
            @Override
            public void run() {
                v.displayAddShapeDialog();
            }
        });

        commands.put("removeshape", new Runnable(){
            @Override
            public void run() {
                v.displayRemoveShapeDialog(m.getShapeNames());
            }
        });

        commands.put("addkeyframe", new Runnable(){
            @Override
            public void run() {
                v.displayAddKeyFrameDialog(m.getShapeNames());
            }
        });
    }

    private void calculateLastTick(){
        for(IShape s: m.getShapes()){
            for(KeyFrame k:s.getKeyFrames()){
                if(k.getTick()>lastTick){
                    lastTick=k.getTick();
                }
            }
        }
    }

    public void setSpeed(int s){
        timer.setDelay(1000/s);
    }

    public void go(){
        v.draw(m.getShapes(), 0);
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if(commands.containsKey(e.getActionCommand())){
            commands.get(e.getActionCommand()).run();
        }else{
            throw new IllegalArgumentException("Action command not recognized");
        }
        /*switch (e.getActionCommand()){
            case "tick":
                System.out.println("Tick is: "+tick+"   and LastTick is: "+lastTick);
                if(tick<lastTick) {
                    tick++;
                    v.draw(m.getShapes(), tick);
                }else if(tick>=lastTick && isLooping){
                    tick=0;
                    v.draw(m.getShapes(), tick);
                }
                break;
            case"playpause":
                if(timer.isRunning()){
                    timer.stop();
                }else{
                    timer.start();
                }
                break;
            case "toggleloop":
                isLooping = !isLooping;
                System.out.println("LOOPING IS: "+isLooping);
                break;
            case "restart":
                tick=0;
                v.draw(m.getShapes(), 0);
                break;
            case "addshape":
                v.displayAddShapeDialog();
                break;
            default:
                throw new IllegalArgumentException("Action command not recognized");
        }*/

    }



    /**
     * Listener method that is called when a state changes.
     *
     * @param e The stateChange event.
     */
    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider) e.getSource();
        if (source.getName().equals("fps")) {
            if (!source.getValueIsAdjusting()) {
                int fps = (int) source.getValue();
                setSpeed(fps);
            }
        }
    }


    public void addShape(String name, ShapeType type){
        try {
            m.addShape(name, type);
        }catch(IllegalArgumentException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void removeShape(String name){
        try{
            m.removeShape(name);
        }catch(IllegalArgumentException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void addKeyFrame(String shapename, int tick, int x, int y, int r, int g, int b, int width, int height){
        try{
            m.addKeyFrame(shapename, tick, x, y, r, g, b, width, height);
        }catch(IllegalArgumentException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
