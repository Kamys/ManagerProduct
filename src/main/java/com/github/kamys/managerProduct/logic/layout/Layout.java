package com.github.kamys.managerProduct.logic.layout;

import com.github.kamys.managerProduct.logic.Goods;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This model layout for {@link Goods}.
 * In layout determines unique {@link Attribute} for certain typ {@link Goods}.
 * Example: layout for milk to determines {@link Attribute} shelf life.
 */
@Entity
@Table(name = "layouts", schema = "public")
public class Layout {

    @Id
    @GenericGenerator(name = "inc", strategy = "increment")
    @GeneratedValue(generator = "inc")
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "link_layout_and_attribute",
            joinColumns = @JoinColumn(name = "id_layout"),
            inverseJoinColumns = @JoinColumn(name = "id_attribute"))
    @GenericGenerator(name = "inc", strategy = "increment")
    @CollectionId(
            columns = @Column(name = "id"),
            type = @Type(type = "long"),
            generator = "inc"
    )
    private List<Attribute> attributeManager = new ArrayList<>();

    public Layout() {
    }

    public Layout(String name) {
        this.name = name;
    }

    public List<Attribute> getAttributeList() {
        return attributeManager;
    }

    public void setAttributeManager(List<Attribute> attributeManager) {
        this.attributeManager = attributeManager;
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

    @Override
    public String toString() {
        return "Layout{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
