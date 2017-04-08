package com.github.kamys.managerProduct.data;

import com.github.kamys.managerProduct.logic.layout.Attribute;
import com.github.kamys.managerProduct.logic.layout.Layout;
import com.github.kamys.managerProduct.logic.layout.Value;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.util.Properties;

/**
 * Base class with the general logic for work Hibernate.
 */
public abstract class HibernateManager {
    private static final Logger LOGGER = Logger.getLogger(HibernateManager.class);
    protected final SessionFactory factory = createSessionFactory();
    protected final EntityManager entityManager = factory.createEntityManager();



    /**
     * Use for get properties for setting hibernate
     *
     * @return properties for setting hibernate.
     */
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
}
