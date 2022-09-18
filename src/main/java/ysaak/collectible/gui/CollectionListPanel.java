package ysaak.collectible.gui;

import ysaak.collectible.data.Collection;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import java.awt.Component;
import java.awt.Dimension;

public class CollectionListPanel extends GenericListPanel<Collection> {
    public CollectionListPanel() {
        super();
        setCellRenderer(new CollectionCellRenderer());

        Dimension dimension = getPanel().getPreferredSize();
        Dimension minDimension = new Dimension(200, dimension.height);
        getPanel().setMinimumSize(minDimension);
        getPanel().setPreferredSize(minDimension);

    }

    @Override
    protected void handleCreateAction() {
        System.out.println("Create collection !");
    }

    private class CollectionCellRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList<? extends Object> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value instanceof Collection) {
                JLabel label = (JLabel) c;
                Collection collect = (Collection) value;
                label.setText(collect.getName());
                /*
                if (!isSelected) {
                    label.setBackground(index % 2 == 0 ? background : defaultBackground);
                }
                */
            }
            return c;
        }
    }
}
