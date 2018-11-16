package view.ListModel;

import cs3500.animator.controller.EditViewController;
import cs3500.animator.model.EasyAnimatorModel;
import cs3500.animator.model.IShape;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.List;

public class ShapeListModel implements ListModel<String> {

    List<String> shapeNames;

    public ShapeListModel(List<String> shapeNames){
        this.shapeNames=shapeNames;

    }

    /**
     * Returns the length of the list.
     *
     * @return the length of the list
     */
    @Override
    public int getSize() {
        return shapeNames.size();
    }

    /**
     * Returns the value at the specified index.
     *
     * @param index the requested index
     * @return the value at <code>index</code>
     */
    @Override
    public String getElementAt(int index) {
        return shapeNames.get(index);
    }

    /**
     * Adds a listener to the list that's notified each time a change
     * to the data model occurs.
     *
     * @param l the <code>ListDataListener</code> to be added
     */
    @Override
    public void addListDataListener(ListDataListener l) {

    }

    /**
     * Removes a listener from the list that's notified each time a
     * change to the data model occurs.
     *
     * @param l the <code>ListDataListener</code> to be removed
     */
    @Override
    public void removeListDataListener(ListDataListener l) {

    }
}
