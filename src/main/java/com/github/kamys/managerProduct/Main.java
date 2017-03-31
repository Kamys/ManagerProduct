package com.github.kamys.managerProduct;

import com.github.kamys.managerProduct.data.managers.ManagerImpl;
import com.github.kamys.managerProduct.logic.layout.AttrValue;
import com.github.kamys.managerProduct.logic.layout.Attribute;
import com.github.kamys.managerProduct.logic.layout.Layout;
import org.apache.log4j.Logger;


public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.info("Hello world!");
        ManagerImpl<Attribute> manager = new ManagerImpl<>();

        for (int i = 0; i < 3; i++) {
            Attribute attr_1 = new Attribute("Attr_" + i);
            attr_1.addValue(new AttrValue("Value_1"));
            attr_1.addValue(new AttrValue("Value_2"));
            attr_1.addValue(new AttrValue("Value_3"));
            manager.save(attr_1);
        }
    }

    public static void test1() {
        ManagerImpl<Layout> manager = new ManagerImpl<>();
        manager.save(new Layout("Test_1"));
    }
}
