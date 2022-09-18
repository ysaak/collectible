package ysaak.collectible.service;

import org.springframework.stereotype.Service;
import ysaak.collectible.data.Collection;
import ysaak.collectible.data.CollectionAttribute;
import ysaak.collectible.data.CollectionAttributeType;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class CollectionService {
    private final List<Collection> collectionList = new ArrayList<>();

    @PostConstruct
    public void init() {
        Collection testCollection = new Collection();
        testCollection.setId(UUID.randomUUID().toString());
        testCollection.setName("Test collection");

        CollectionAttribute attr1 = new CollectionAttribute();
        attr1.setName("First field");
        attr1.setKey(nameToKey(attr1.getName()));
        attr1.setOrder(1);
        attr1.setType(CollectionAttributeType.STRING);

        CollectionAttribute attr2 = new CollectionAttribute();
        attr2.setName("2 & 3 testing spécials");
        attr2.setKey(nameToKey(attr2.getName()));
        attr2.setOrder(2);
        attr2.setType(CollectionAttributeType.CHOICE);
        attr2.setFixedChoices(Set.of("Beta", "Alpha", "Gamma", "Epsilon"));

        testCollection.setAttributes(Set.of(attr1, attr2));
        collectionList.add(testCollection);
    }

    public List<Collection> getCollectionList() {
        return collectionList;
    }

    private String nameToKey(String name) {
        return name.replaceAll("[^a-zA-Z0-9]", " ") // Remove all specials chars
                .replaceAll("( )+", " ") // Remove consecutive spaces
                .replace(' ', '_'); // Replace spaces by underscore
    }
}
