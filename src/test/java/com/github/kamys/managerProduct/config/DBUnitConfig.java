package com.github.kamys.managerProduct.config;

import org.dbunit.DBTestCase;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;

import java.io.IOException;
import java.util.Properties;

/**
 * Setting for DBTest
 */
public class DBUnitConfig extends DBTestCase {
    protected IDatabaseTester tester;
    protected IDataSet beforeData;
    private Properties prop;

    public DBUnitConfig(String name) {
        super(name);
        prop = new Properties();
        try {
            prop.load(Thread.currentThread()
                    .getContextClassLoader().getResourceAsStream("db.config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, prop.getProperty("db.driver"));
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, prop.getProperty("db.url"));
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, prop.getProperty("db.username"));
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, prop.getProperty("db.password"));
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_SCHEMA, "");
    }

    @Before
    public void setUp() throws Exception {
        String driver = prop.getProperty("db.driver");
        String url = prop.getProperty("db.url");
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");
        tester = new JdbcDatabaseTester(driver, url, username, password);
        super.setUp();
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        return beforeData;
    }

    @Override
    protected DatabaseOperation getSetUpOperation() throws Exception {
        return DatabaseOperation.CLEAN_INSERT;
    }

    @Override
    protected DatabaseOperation getTearDownOperation() throws Exception {
        return DatabaseOperation.NONE;
    }

}
