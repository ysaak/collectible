package ysaak.collectible.gui;

import org.springframework.stereotype.Component;
import ysaak.collectible.data.Collection;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.util.List;

@Component
public class MainFrame extends JFrame {
    private final CollectionListPanel collectionListPanel;
    
    public MainFrame() {
        collectionListPanel = new CollectionListPanel();
        initUI();
    }

    private void initUI() {

        var quitButton = new JButton("Quit");

        quitButton.addActionListener((ActionEvent event) -> {
            System.exit(0);
        });

        createLayout(quitButton);

        setTitle("Collectible");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createLayout(JComponent... arg) {

        Container pane = getContentPane();
        pane.setLayout(new BorderLayout(10, 10));

        JPanel panel = new JPanel();
        GroupLayout gl = new GroupLayout(panel);
        panel.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
        );

        pane.add(collectionListPanel.getPanel(), BorderLayout.WEST);
        pane.add(panel, BorderLayout.CENTER);
    }

    public void setCollections(List<Collection> collections) {
        collectionListPanel.setData(collections);
    }
}
