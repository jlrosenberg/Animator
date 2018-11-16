package view;

import cs3500.animator.model.EasyAnimatorModel;
import view.ListModel.ShapeListModel;

import javax.swing.*;
import java.util.List;

public class ShapeList extends JList<String> {

    public ShapeList(List<String> shapeNames){
        super(new ShapeListModel(shapeNames));
        this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public String getNameOfSelectedShape(){
        return this.getSelectedValue();
    }
}
