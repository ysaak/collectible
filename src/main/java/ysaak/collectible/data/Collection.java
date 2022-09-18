package ysaak.collectible.data;

import java.util.Set;

public class Collection {
    private String id;
    private String name;
    private Set<CollectionAttribute> attributes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<CollectionAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(Set<CollectionAttribute> attributes) {
        this.attributes = attributes;
    }
}
