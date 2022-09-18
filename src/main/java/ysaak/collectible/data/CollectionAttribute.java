package ysaak.collectible.data;

import java.util.Set;

public class CollectionAttribute {
    private String key;
    private String name;
    private int order;
    private CollectionAttributeType type;
    private Set<String> fixedChoices;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public CollectionAttributeType getType() {
        return type;
    }

    public void setType(CollectionAttributeType type) {
        this.type = type;
    }

    public Set<String> getFixedChoices() {
        return fixedChoices;
    }

    public void setFixedChoices(Set<String> fixedChoices) {
        this.fixedChoices = fixedChoices;
    }
}
