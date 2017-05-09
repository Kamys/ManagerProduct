package com.github.kamys.managerProduct;

import com.github.kamys.managerProduct.data.managers.Manager;
import com.github.kamys.managerProduct.data.managers.ManagerLayout;
import com.github.kamys.managerProduct.data.managers.criteria.CriteriaFactory;
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
        delete();
    }

    private static void getAll() {
        Manager<Layout> manager = new ManagerLayout();

        Collection<Layout> layouts = manager.getAll();
        for (Layout layout : layouts) {
            LOGGER.info(layout);
        }
        manager.close();
    }

    private static void delete() {
        Layout layout = new Layout();
        layout.setName("Кифир");
        layout.setId(1);

        Parameters parameters = ParametersFactory.createParameter(layout);
        parameters.setUseForSelect("id", false);
        parameters.setUseForSelect("name", true);

        Manager<Layout> manager = new ManagerLayout();
        manager.delete(parameters);
        manager.close();
    }

    private static void save() {
        Layout layout = new Layout();
        layout.setName("Пельмешки");

        Attribute attr0 = new Attribute("Срок годности");
        Attribute attr1 = new Attribute("Производитель");
        Attribute attr2 = new Attribute("Состав");

        layout.getAttributeList().add(attr0);
        layout.getAttributeList().add(attr1);
        layout.getAttributeList().add(attr2);

        Manager<Layout> manager = new ManagerLayout();
        manager.save(layout);
        manager.close();
    }

    private static void select() {
        Layout layout = new Layout();
        layout.setName("Пельмешки");
        layout.setId(2);

        CriteriaHelper<Layout> criteriaHelper = CriteriaFactory.createCriteria(layout);

        Parameters parameters = criteriaHelper.getParameters();
        parameters.setUseForSelect("id", false);
        parameters.setUseForSelect("name", true);

        Manager<Layout> manager = new ManagerLayout();
        Collection<Layout> select = manager.select(criteriaHelper);
        LOGGER.info("Select = " + select);
        manager.close();
    }

    private static void update() {
        Layout layoutForFind = new Layout();
        layoutForFind.setName("Молоко");

        Parameters oldParameters = ParametersFactory.createParameter(layoutForFind);
        oldParameters.setUseForSelect("name", true);

        Parameters newParameters = ParametersFactory.createParameter(new Layout("Хлеб"));
        newParameters.setUseForUpdate("name", true);

        Manager<Layout> manager = new ManagerLayout();
        manager.update(oldParameters, newParameters);
        manager.close();
    }

}
