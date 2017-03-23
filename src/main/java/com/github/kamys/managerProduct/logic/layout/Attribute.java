package com.github.kamys.managerProduct.logic.layout;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Use in {@link Layout}. Need for records value and name is attribute.
 */
@Entity
@Table(name = "attributes")
public class Attribute {

    private static int idCounter = 0;

    {
        idCounter++;
    }

    @Id
    @Column(name = "id")
    private int id = idCounter;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "attributes_value",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_attribute"))
    private List<String> value = new ArrayList<>();
    @Column(name = "description")
    private String description;

    public Attribute() {
    }

    public Attribute(String name, String value) {
        this.name = name;
        this.value.add(value);
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

    public List<String> getValue() {
        return value;
    }

    public void setValue(List<String> value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Attribute{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", description='" + description + '\'' +
                '}';
    }
}
