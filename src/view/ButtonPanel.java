package view;

import cs3500.animator.controller.EditViewController;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {
    private EditViewController controller;
    public static final int FPS_MIN=1;
    public static final int FPS_MAX=51;
    public static final int FPS_INIT=1;


    public ButtonPanel(EditViewController c){
        this.controller=c;
        setLayout(new FlowLayout());
        addButton("Play/Pause", "playpause");
        addButton("Restart", "restart");
        addButton("Toggle/Untoggle Loopback", "toggleloop");

        JSlider framesPerSecond = new JSlider(JSlider.HORIZONTAL,
                FPS_MIN, FPS_MAX, FPS_INIT);
        framesPerSecond.addChangeListener(controller);

        //Turn on labels at major tick marks.
        framesPerSecond.setMajorTickSpacing(5);
        framesPerSecond.setMinorTickSpacing(1);
        framesPerSecond.setPaintTicks(true);
        framesPerSecond.setPaintLabels(true);
        framesPerSecond.setName("fps");
        add(framesPerSecond);

    }

    /**
     * Helper method to add buttons to the ContentPanel.
     *
     * @param text   The text to be rendered on the button
     * @param actCmd The actionCommand to set.
     */
    private void addButton(String text, String actCmd) {
        JButton b = new JButton();
        b.setText(text);
        b.setActionCommand(actCmd);
        b.addActionListener(controller);
        add(b);
    }
}
