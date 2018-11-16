package view;

import cs3500.animator.controller.EditViewController;
import cs3500.animator.model.EasyAnimatorModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RemoveShapeDialog extends JDialog implements ActionListener {


    public static final int HEIGHT = 600;
    public static final int WIDTH = 300;
    public static final int SUBMIT_HEIGHT = 30;
    public static final int SUBMIT_WIDTH = 50;
    public static final String SUBMIT_TEXT = "Remove Shape";
    public static final String HELP_TEXT = "Please select a shape to remove:\n";
    private EditViewController c;
    private ShapeList shapes;

    public RemoveShapeDialog(List<String> shapeNames, EditViewController c){
        this.c=c;
        this.setLocation(500, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        shapes=new ShapeList(shapeNames);
        JScrollPane shapePane=new JScrollPane(shapes);
        shapePane.setPreferredSize(new Dimension( shapes.getMaximumSize()));
        shapes.setPreferredSize(new Dimension(shapes.getMaximumSize()));

        JLabel instructions = new JLabel(HELP_TEXT);
        JButton submit = new JButton(SUBMIT_TEXT);
        submit.setSize(SUBMIT_WIDTH, SUBMIT_HEIGHT);
        submit.setActionCommand("addShapeDialogSubmit");
        submit.addActionListener(this);
        this.setLayout(new BorderLayout());

        add(instructions, BorderLayout.NORTH);
        add(shapePane, BorderLayout.CENTER);
        add(submit, BorderLayout.SOUTH);



    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        c.removeShape(shapes.getNameOfSelectedShape());
        this.dispose();
    }
}
