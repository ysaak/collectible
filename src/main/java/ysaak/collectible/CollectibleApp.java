package ysaak.collectible;

import com.formdev.flatlaf.FlatDarculaLaf;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import ysaak.collectible.data.Collection;
import ysaak.collectible.gui.MainFrame;
import ysaak.collectible.service.CollectionService;

import java.awt.EventQueue;
import java.util.List;

@SpringBootApplication
public class CollectibleApp {
    public static void main(String[] args) {
        FlatDarculaLaf.setup();

        ConfigurableApplicationContext ctx = new SpringApplicationBuilder(CollectibleApp.class)
                .headless(false).run(args);



        EventQueue.invokeLater(() -> {
            List<Collection> collections = ctx.getBean(CollectionService.class).getCollectionList();

            MainFrame ex = ctx.getBean(MainFrame.class);
            ex.setCollections(collections);
            ex.setVisible(true);
        });
    }
}
