package com.github.kamys.managerProduct.logic.layout;

import com.github.kamys.managerProduct.config.DBUnitConfig;
import com.github.kamys.managerProduct.data.managers.ManagerLayout;
import org.dbunit.Assertion;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.dbunit.Assertion.assertEqualsIgnoreCols;


public class LayoutTestDB extends DBUnitConfig {
    private ManagerLayout service = new ManagerLayout();
    //private EntityManager em = Persistence.createEntityManagerFactory("DBUnitEx").createEntityManager();

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

    @Test
    public void save() throws Exception {
        Layout person = new Layout();
        person.setName("Мёд");

        service.save(person);

        IDataSet expectedData = new FlatXmlDataSetBuilder().build(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("com/devcolibri/entity/person/layout-data-save.xml"));

        IDataSet actualData = tester.getConnection().createDataSet();

        String[] ignore = {"id"};
        assertEqualsIgnoreCols(expectedData, actualData, "person", ignore);
    }
}