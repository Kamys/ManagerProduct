package com.github.kamys.managerProduct.logic.section;

/**
 * This model contains goods and other Section.
 */
public abstract class Section {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
