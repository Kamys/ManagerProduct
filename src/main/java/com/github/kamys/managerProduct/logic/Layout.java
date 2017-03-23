package com.github.kamys.managerProduct.logic;

/**
 * This model layout for {@link Goods}.
 * In layout determines unique parameters for certain typ {@link Goods}.
 * Example: layout for milk to determines parameter shelf life.
 */
class Layout {
    private String name;

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }
}
