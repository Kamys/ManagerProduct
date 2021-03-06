package com.github.kamys.managerProduct;

import com.github.kamys.managerProduct.data.managers.Manager;
import com.github.kamys.managerProduct.data.managers.ManagerLayout;
import com.github.kamys.managerProduct.data.managers.criteria.CriteriaBuilderFactory;
import com.github.kamys.managerProduct.data.managers.criteria.CriteriaHelper;
import com.github.kamys.managerProduct.data.managers.criteria.Parameters;
import com.github.kamys.managerProduct.data.managers.criteria.ParametersFactory;
import com.github.kamys.managerProduct.logic.layout.Attribute;
import com.github.kamys.managerProduct.logic.layout.Layout;
import org.apache.log4j.Logger;

import java.util.Collection;


public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        Manager<Layout> manager = new ManagerLayout();

        Collection<Layout> layouts = manager.selectAll();
        for (Layout layout : layouts) {
            LOGGER.info(layout);
        }
    }

    private static void delete() {
        Manager<Layout> manager = new ManagerLayout();

        Layout layout = new Layout();
        layout.setName("Мясо");
        layout.setId(2);

        CriteriaBuilderFactory factory = new CriteriaBuilderFactory();
        CriteriaHelper<Layout> criteria = factory.createLayout(layout);

        Parameters parameters = criteria.getParameters();
        parameters.setUseForSelect("id", false);
        parameters.setUseForSelect("name", true);

        manager.delete(criteria);
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

    private static void select() {
        Manager<Layout> manager = new ManagerLayout();


        Layout layout = new Layout();
        layout.setName("Пельмешки");
        layout.setId(2);

        CriteriaBuilderFactory factory = new CriteriaBuilderFactory();
        CriteriaHelper<Layout> criteriaHelper = factory.createLayout(layout);

        Parameters parameters = criteriaHelper.getParameters();
        parameters.setUseForSelect("id", false);
        parameters.setUseForSelect("name", true);

        Collection<Layout> select = manager.select(criteriaHelper);
        LOGGER.info("Select = " + select);
        manager.close();
    }

    private static void update() {
        Manager<Layout> manager = new ManagerLayout();

        Layout layoutForFind = new Layout();
        layoutForFind.setName(null);
        layoutForFind.setId(4);

        CriteriaBuilderFactory factory = new CriteriaBuilderFactory();
        CriteriaHelper<Layout> criteriaHelper = factory.createLayout(layoutForFind);
        criteriaHelper.getParameters().setUseForSelect("id", true);

        ParametersFactory parametersFactory = new ParametersFactory();
        Parameters newParameters = parametersFactory.createCriteriaManagerLayout(new Layout("Банан"));
        newParameters.setUseForUpdate("name", true);
        manager.update(criteriaHelper, newParameters);
        manager.close();
    }

}
