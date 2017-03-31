package com.github.kamys.managerProduct.data;

import com.github.kamys.managerProduct.logic.layout.Attribute;
import com.github.kamys.managerProduct.logic.layout.Layout;
import com.github.kamys.managerProduct.logic.layout.Value;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;

/**
 * Use for save object in database through hibernate.
 */
public class DataBaseHibernate {
    private static final Logger LOGGER = Logger.getLogger(DataBaseHibernate.class);
    private final SessionFactory factory = createSessionFactory();

    /**
     * Save object with hibernate annotation in data base.
     *
     * @param t which need save in data base.
     */
    public void saveObject(Object t) {
        LOGGER.info("saveObject: " + t);
        Transaction tr = null;
        try (Session session = factory.openSession()) {
            tr = session.beginTransaction();
            session.save(t);
            tr.commit();
        } catch (HibernateException e) {
            if (tr != null) tr.rollback();
            LOGGER.warn(e);
        }
    }

    private Properties getProperties() {
        Properties properties = new Properties();
        try {
            properties.load(getClass().getResourceAsStream("/hibernate.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }


    private SessionFactory createSessionFactory() {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Layout.class)
                .addAnnotatedClass(Attribute.class)
                .addAnnotatedClass(Value.class)
                .setProperties(getProperties());

        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());

        return configuration.buildSessionFactory(builder.build());
    }

    public void colese() {
        if (!factory.isClosed()) {
            factory.close();
        }
    }
}
