package com.github.kamys.managerProduct.data.managers;

import com.github.kamys.managerProduct.data.HibernateManager;
import com.github.kamys.managerProduct.data.managers.criteria.CriteriaQueryBuilder;
import com.github.kamys.managerProduct.data.managers.criteria.Parameters;
import com.github.kamys.managerProduct.logic.layout.Layout;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import java.util.Collection;

/**
 * Need for management Attribute.
 */
public class ManagerLayout extends HibernateManager implements Manager<Layout> {
    private static final Logger LOGGER = Logger.getLogger(ManagerLayout.class);

    @Override
    public void save(Layout layout) {
        LOGGER.info("save: " + layout);
        Transaction tr = null;
        try (Session session = factory.openSession()) {
            tr = session.beginTransaction();
            session.save(layout);
            tr.commit();
        } catch (HibernateException e) {
            if (tr != null) tr.rollback();
            LOGGER.warn(e);
        }
    }

    @Override
    public void update(CriteriaQueryBuilder<Layout> builderCriteria, Parameters newParameters) {
        LOGGER.info("update:" + builderCriteria);
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaUpdate<Layout> criteriaUpdate = builderCriteria
                .createCriteriaUpdate(criteriaBuilder, newParameters);
        entityManager.createQuery(criteriaUpdate).executeUpdate();
    }

    @Override
    public Collection<Layout> delete(CriteriaQueryBuilder<Layout> criteriaQueryBuilder) {
        return null;
    }

    @Override
    public Collection<Layout> select(CriteriaQueryBuilder<Layout> builderCriteria) {
        LOGGER.info("select:" + builderCriteria);
        javax.persistence.criteria.CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Layout> criteria = builderCriteria.createCriteriaSelect(criteriaBuilder);
        return entityManager.createQuery(criteria).getResultList();
    }

    @Override
    public Collection<Layout> selectAll() {
        return null;
    }

    @Override
    public void close() {
        if (!factory.isClosed()) {
            factory.close();
        }
    }

}
