package com.github.kamys.managerProduct;

import com.github.kamys.managerProduct.data.managers.Manager;
import com.github.kamys.managerProduct.data.managers.ManagerLayout;
import com.github.kamys.managerProduct.data.managers.criteria.CriteriaBuilderFactory;
import com.github.kamys.managerProduct.data.managers.criteria.CriteriaQueryBuilder;
import com.github.kamys.managerProduct.logic.layout.Attribute;
import com.github.kamys.managerProduct.logic.layout.Layout;
import org.apache.log4j.Logger;

import java.util.Collection;


public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.info("Hello world!");
        select();
    }

    private static void save() {
        Manager<Layout> manager = new ManagerLayout();


        Layout layout = new Layout();
        layout.setName("Пельмешки");

        Attribute attr0 = new Attribute("Срок годности");
        Attribute attr1 = new Attribute("Производитель");
        Attribute attr2 = new Attribute("Состав");

        layout.getAttributeList().add(attr0);
        layout.getAttributeList().add(attr1);
        layout.getAttributeList().add(attr2);

        manager.save(layout);
        manager.close();
    }

    //TODO: Selecting multiple.
    private static void select() {
        Manager<Layout> manager = new ManagerLayout();


        Layout layout = new Layout();
        layout.setName("Молоко");
        layout.setId(1);

        CriteriaBuilderFactory factory = new CriteriaBuilderFactory();
        CriteriaQueryBuilder<Layout> criteriaQueryBuilder = factory.createLayout(layout);
        criteriaQueryBuilder.setUseInCriteria("id", false);
        criteriaQueryBuilder.setUseInCriteria("name", true);

        Collection<Layout> select = manager.select(criteriaQueryBuilder);
        LOGGER.info("Select = " + select);
        manager.close();
    }

}
