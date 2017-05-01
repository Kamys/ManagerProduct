package com.github.kamys.managerProduct.logic.layout;

import com.github.kamys.managerProduct.config.DBUnitConfig;
import com.github.kamys.managerProduct.data.managers.ManagerLayout;
import com.github.kamys.managerProduct.data.managers.criteria.Parameters;
import org.dbunit.Assertion;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Before;

import java.util.Collection;


public class LayoutTestDB extends DBUnitConfig {
    private ManagerLayout service = new ManagerLayout();

    @Before
    public void setUp() throws Exception {


        beforeData = new FlatXmlDataSetBuilder().build(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("entity/layout-data.xml"));

        super.setUp();
        tester.setDataSet(beforeData);
        tester.onSetup();
    }

    public LayoutTestDB(String name) {
        super(name);
    }


    public void testGetAll() throws Exception {
        Collection<Layout> layouts = service.getAll();

        IDataSet expectedData = new FlatXmlDataSetBuilder().build(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("entity/layout-data.xml"));

        IDataSet actualData = tester.getConnection().createDataSet();
        Assertion.assertEquals(expectedData, actualData);
        final int rowCount = expectedData.getTable("layouts").getRowCount();
        assertEquals(rowCount, layouts.size());
    }

    public void testSave() throws Exception {
        Layout honey = createLayout();
        service.save(honey);

        IDataSet expectedData = new FlatXmlDataSetBuilder().build(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("entity/layout-data-save.xml"));

        IDataSet actualData = tester.getConnection().createDataSet();

        Assertion.assertEquals(expectedData, actualData);
    }

    private Layout createLayout() {
        Layout honey = new Layout();
        honey.setName("Мёд");
        honey.setId(3);
        return honey;
    }

    public void testUpdate() throws Exception {
        Layout layout = createLayout();
        Parameters newParameters = new Parameters();
        service.update(criteriaHelper, newParameters);

        IDataSet expectedData = new FlatXmlDataSetBuilder().build(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("entity/layout-data-save.xml"));

        IDataSet actualData = tester.getConnection().createDataSet();

        Assertion.assertEquals(expectedData, actualData);
    }
}