package com.github.kamys.managerProduct;

import com.github.kamys.managerProduct.data.managers.Manager;
import com.github.kamys.managerProduct.data.managers.ManagerLayout;
import com.github.kamys.managerProduct.logic.layout.Attribute;
import com.github.kamys.managerProduct.logic.layout.Layout;
import com.github.kamys.managerProduct.logic.layout.Value;
import org.apache.log4j.Logger;


public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.info("Hello world!");
        Manager<Layout> manager = new ManagerLayout();

        for (int i = 0; i < 5; i++) {
            Layout layout = new Layout();
            layout.setName("Layout_" + i);
            for (int j = 0; j < 5; j++) {
                Attribute attr = new Attribute("Attr_" + j);
                layout.getAttributeList().add(attr);
                attr.addValue(new Value("Value_1"));
                attr.addValue(new Value("Value_2"));
                attr.addValue(new Value("Value_3"));
            }
            manager.save(layout);
        }
        manager.close();
    }
}
