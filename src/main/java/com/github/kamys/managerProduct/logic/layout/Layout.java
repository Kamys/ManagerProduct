package com.github.kamys.managerProduct.logic.layout;

import com.github.kamys.managerProduct.logic.Goods;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This model layout for {@link Goods}.
 * In layout determines unique {@link Attribute} for certain typ {@link Goods}.
 * Example: layout for milk to determines {@link Attribute} shelf life.
 */
@Entity
@Table(name = "layouts", schema = "public")
public class Layout {
    private static int idCounter = 0;

    {
        idCounter++;
    }

    @Id
    @Column(name = "id")
    private int id = idCounter;

    @Column(name = "name", nullable = false)
    private String name;
    //private Manager<Attribute> atributeManager;

    public Layout() {
    }

    public Layout(String name) {
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

    @Override
    public String toString() {
        return "Layout{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
