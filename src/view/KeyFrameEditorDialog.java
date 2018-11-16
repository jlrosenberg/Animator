package view;

import cs3500.animator.model.KeyFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KeyFrameEditorDialog extends JDialog implements ActionListener {

    public static final int HEIGHT = 630;
    public static final int WIDTH = 450;
    public static final int TEXTFIELD_HEIGHT = 30;
    public static final int TEXTFIELD_WIDTH = 350;
    public static final int SUBMIT_HEIGHT = 30;
    public static final int SUBMIT_WIDTH = 50;
    public static final String SUBMIT_TEXT = "Add Keyframe";
    public static final String HELP_TEXT = "Please enter the data for the new keyframe\n";
    KeyFrameRunnable kr;
    JColorChooser colorChooser;
    JTextField tickField, xField, yField, wField, hField;
    JButton submit;


    public KeyFrameEditorDialog(KeyFrameRunnable kr){
        this.kr=kr;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocation(500, 500);
        this.setSize(WIDTH, HEIGHT);
        this.setLayout(new FlowLayout());

        colorChooser=new JColorChooser();
        colorChooser.setSize(new Dimension(250,250));
        add(colorChooser);
        setVisible(true);

        tickField=new JTextField();
        tickField.setPreferredSize(new Dimension(TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT));
        tickField.setText("tick");

        xField=new JTextField();
        xField.setPreferredSize(new Dimension(TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT));
        xField.setText("x value");

        yField=new JTextField();
        yField.setPreferredSize(new Dimension(TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT));
        yField.setText("y value");

        wField=new JTextField();
        wField.setPreferredSize(new Dimension(TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT));
        wField.setText("width");

        hField=new JTextField();
        hField.setPreferredSize(new Dimension(TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT));
        hField.setText("height");

        submit = new JButton(SUBMIT_TEXT);
        submit.setSize(SUBMIT_WIDTH, SUBMIT_HEIGHT);
        submit.setActionCommand("addShapeDialogSubmit");
        submit.addActionListener(this);

        add(new JLabel("tick:        "));
        add(tickField);
        add(new JLabel("x value:     "));
        add(xField);
        add(new JLabel("y value:     "));
        add(yField);
        add(new JLabel("w value:     "));
        add(wField);
        add(new JLabel("h value:     "));
        add(hField);
        add(submit);


    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        kr.run(Integer.parseInt(tickField.getText()),
                Integer.parseInt(xField.getText()),
                Integer.parseInt(yField.getText()),
        colorChooser.getColor().getRed(),
                colorChooser.getColor().getGreen(),
                colorChooser.getColor().getBlue(),
                Integer.parseInt(wField.getText()),
                Integer.parseInt(hField.getText()));

        this.dispose();
    }
}
