package com.github.kamys.managerProduct;

import com.github.kamys.managerProduct.data.managers.ManagerImpl;
import com.github.kamys.managerProduct.logic.layout.Layout;
import org.apache.log4j.Logger;


public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.info("Hello world!");
        ManagerImpl<Layout> manager = new ManagerImpl<>();
        manager.save(new Layout("Test"));
    }
}
