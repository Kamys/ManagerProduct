package com.github.kamys.managerProduct.logic.layout;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Use in {@link Layout}. Need for records attrValues and name is attribute.
 */
@Entity
@Table(name = "attributes")
public class Attribute {
    @Id
    @GenericGenerator(name = "inc", strategy = "increment")
    @GeneratedValue(generator = "inc")
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", nullable = false)
    private String name;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "link_attribute_and_value",
            joinColumns = @JoinColumn(name = "id_attribute"),
            inverseJoinColumns = @JoinColumn(name = "id_value"))
    private List<AttrValue> attrValues = new ArrayList<>();

    public Attribute() {
    }

    public Attribute(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AttrValue> getAttrValues() {
        return attrValues;
    }

    public void setAttrValues(List<AttrValue> attrValues) {
        this.attrValues = attrValues;
    }

    public void addValue(AttrValue attrValue) {
        this.attrValues.add(attrValue);
    }

    @Override
    public String toString() {
        return "Attribute{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", attrValues=" + attrValues +
                '}';
    }
}
