package view;

import cs3500.animator.controller.EditViewController;
import cs3500.animator.model.ShapeType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddShapeDialog extends JDialog implements ActionListener {
    private EditViewController c;

    private JTextField inputText;
    private JRadioButton rect, ellipse;
    private JButton submit;
    public static final int HEIGHT = 200;
    public static final int WIDTH = 400;
    public static final int TEXTFIELD_HEIGHT = 30;
    public static final int TEXTFIELD_WIDTH = 200;
    public static final String TEXTFIELD_DEFAULT_TEXT = "shape name";
    public static final int SUBMIT_HEIGHT = 30;
    public static final int SUBMIT_WIDTH = 50;
    public static final String SUBMIT_TEXT = "Add Shape";
    public static final String HELP_TEXT = "Please enter the name of the shape and then select its type\n";


    private static AddShapeDialog obj;

    private AddShapeDialog(){
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocation(500, 500);
        this.setSize(WIDTH, HEIGHT);
        inputText = new JTextField();
        inputText.setPreferredSize(new Dimension(TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT));
        inputText.setText(TEXTFIELD_DEFAULT_TEXT);
        JLabel instructions = new JLabel(HELP_TEXT);
        submit = new JButton(SUBMIT_TEXT);
        submit.setSize(SUBMIT_WIDTH, SUBMIT_HEIGHT);
        submit.setActionCommand("addShapeDialogSubmit");
        submit.addActionListener(this);
        this.setLayout(new FlowLayout());


        rect=new JRadioButton("Rectangle", true);
        ellipse=new JRadioButton("Ellipse");
        ButtonGroup g=new ButtonGroup();
        g.add(rect);
        g.add(ellipse);
        add(instructions);
        add(inputText);
        //add(new JSeparator());
        JPanel radPane=new JPanel();
        radPane.add(rect);
        radPane.add(ellipse);
        radPane.setPreferredSize(new Dimension(WIDTH, 30));
        add(radPane);




        add(submit);

    }



    private String getShapeName() {
        //System.out.println(inputText.getText());
        return inputText.getText();
    }

    private ShapeType getShapeType(){
        if(rect.isSelected()){
            return ShapeType.RECTANGLE;
        }else{
            return ShapeType.ELLIPSE;
        }
    }


    public static AddShapeDialog getInstance(EditViewController c){
        if(obj==null){
            obj=new AddShapeDialog();

        }

        obj.c=c;
        return obj;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        c.addShape(getShapeName(), getShapeType());
        this.dispose();
    }
}
