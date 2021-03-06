package com.github.kamys.managerProduct.logic.layout;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * This value for {@link Attribute}.
 */
@Entity
@Table(name = "values")
public class Value {
    @Id
    @GenericGenerator(name = "inc", strategy = "increment")
    @GeneratedValue(generator = "inc")
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "value")
    private String value;

    public Value() {
    }

    public Value(String value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Value{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}
