package ysaak.collectible.gui;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import java.awt.BorderLayout;
import java.util.List;

public abstract class GenericListPanel<T> {
    private JPanel mainPanel;

    private final DefaultListModel<T> itemListModel;
    private final JList<T> itemList;


    public GenericListPanel() {
        this.mainPanel = new JPanel(new BorderLayout(10, 10));

        JButton createButton = new JButton("(+) Create");
        createButton.addActionListener(e -> handleCreateAction());

        itemListModel = new DefaultListModel<>();
        itemList = new JList<>(itemListModel);
        itemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        itemList.setVisibleRowCount(-1);


        this.mainPanel.add(new JScrollPane(itemList));
        this.mainPanel.add(createButton, BorderLayout.SOUTH);
    }

    protected void setCellRenderer(ListCellRenderer<?> cellRenderer) {
        this.itemList.setCellRenderer((ListCellRenderer<? super T>) cellRenderer);
    }

    public JPanel getPanel() {
        return this.mainPanel;
    }

    public void setData(List<T> data) {
        this.itemListModel.addAll(data);
    }

    protected void handleCreateAction() {

    }
}
