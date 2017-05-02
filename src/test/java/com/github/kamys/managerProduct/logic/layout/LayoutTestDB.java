package com.github.kamys.managerProduct.logic.layout;

import com.github.kamys.managerProduct.config.DBUnitConfig;
import com.github.kamys.managerProduct.data.managers.ManagerLayout;
import com.github.kamys.managerProduct.data.managers.criteria.Parameters;
import com.github.kamys.managerProduct.data.managers.criteria.ParametersFactory;
import org.dbunit.Assertion;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Before;

import java.util.Collection;


public class LayoutTestDB extends DBUnitConfig {
    private ManagerLayout service = new ManagerLayout();

    @Before
    public void setUp() throws Exception {


        beforeData = createDataSet("entity/layout-data-default.xml");

        super.setUp();
        tester.setDataSet(beforeData);
        tester.onSetup();
    }

    public LayoutTestDB(String name) {
        super(name);
    }


    public void testGetAll() throws Exception {
        Collection<Layout> layouts = service.getAll();

        IDataSet expectedData = createDataSet("entity/layout-data-default.xml");

        IDataSet actualData = tester.getConnection().createDataSet();
        Assertion.assertEquals(expectedData, actualData);
        final int rowCount = expectedData.getTable("layouts").getRowCount();
        assertEquals(rowCount, layouts.size());
    }

    public void testSave() throws Exception {
        Layout honey = createLayout("Мёд", 3);
        service.save(honey);

        IDataSet expectedData = createDataSet("entity/layout-data-save.xml");
        IDataSet actualData = tester.getConnection().createDataSet();
        Assertion.assertEquals(expectedData, actualData);
    }

    private static Layout createLayout(String name, int id) {
        Layout honey = new Layout();
        honey.setName(name);
        honey.setId(id);
        return honey;
    }

    public void testUpdateOnName() throws Exception {
        Layout oldLayout = createLayout("Молоко", -1);
        Parameters oldParameter = ParametersFactory.createParameter(oldLayout);
        oldParameter.setUseForSelect("name", true);

        Layout newLayout = createLayout("Сырок", -1);
        Parameters newParameter = ParametersFactory.createParameter(newLayout);
        newParameter.setUseForUpdate("name", true);
        service.update(oldParameter, newParameter);

        IDataSet expectedData = createDataSet("entity/layout-data-update.xml");

        IDataSet actualData = tester.getConnection().createDataSet();

        Assertion.assertEquals(expectedData, actualData);
    }

    public void testUpdateOnId() throws Exception {
        Layout oldLayout = createLayout("", 1);
        Parameters oldParameter = ParametersFactory.createParameter(oldLayout);
        oldParameter.setUseForSelect("id", true);

        Layout newLayout = createLayout("Сырок", -1);
        Parameters newParameter = ParametersFactory.createParameter(newLayout);
        newParameter.setUseForUpdate("name", true);
        service.update(oldParameter, newParameter);

        IDataSet expectedData = createDataSet("entity/layout-data-update.xml");

        IDataSet actualData = tester.getConnection().createDataSet();

        Assertion.assertEquals(expectedData, actualData);
    }

    private IDataSet createDataSet(String path) throws Exception {
        return new FlatXmlDataSetBuilder().build(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream(path));
    }
}