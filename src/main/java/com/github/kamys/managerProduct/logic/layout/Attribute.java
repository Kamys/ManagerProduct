package com.github.kamys.managerProduct.logic.layout;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Use in {@link Layout}. Need for records values and name is attribute.
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
    @GenericGenerator(name = "inc", strategy = "increment")
    @CollectionId(
            columns = @Column(name = "id"),
            type = @Type(type = "long"),
            generator = "inc"
    )
    private List<Value> values = new ArrayList<>();

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

    public List<Value> getValues() {
        return values;
    }

    public void setValues(List<Value> values) {
        this.values = values;
    }

    public void addValue(Value value) {
        this.values.add(value);
    }

    @Override
    public String toString() {
        return "Attribute{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", values=" + values +
                '}';
    }
}
