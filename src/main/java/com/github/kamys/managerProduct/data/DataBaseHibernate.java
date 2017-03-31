package com.github.kamys.managerProduct.data;

import com.github.kamys.managerProduct.logic.layout.AttrValue;
import com.github.kamys.managerProduct.logic.layout.Attribute;
import com.github.kamys.managerProduct.logic.layout.Layout;
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

    /**
     * Save object with hibernate annotation in data base.
     *
     * @param t which need save in data base.
     */
    public void saveObject(Object t) {
        LOGGER.info("Save: " + t);
        Transaction tr = null;
        SessionFactory factory = createSessionFactory();
        Session session = factory.openSession();
        try {
            tr = session.beginTransaction();
            session.save(t);
            tr.commit();
        } catch (HibernateException e) {
            if (tr != null) tr.rollback();
            LOGGER.warn(e);
        } finally {
            session.close();
            factory.close();
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
                .addAnnotatedClass(AttrValue.class)
                .setProperties(getProperties());

        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());

        return configuration.buildSessionFactory(builder.build());
    }
}
