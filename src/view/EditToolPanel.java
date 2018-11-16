package view;

import cs3500.animator.controller.EditViewController;

import javax.swing.*;
import java.awt.*;

public class EditToolPanel extends JPanel {

    private EditViewController controller;

    public EditToolPanel(EditViewController c){
        controller=c;
        setLayout(new FlowLayout());

        addButton("Add Shape", "addshape");
        addButton("Remove Shape", "removeshape");
        addButton("Add Keyframe","addkeyframe");
        addButton("Remove Keyframe", "removekeyframe");
        addButton("Modify Keyframe", "modifykeyframe");
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
