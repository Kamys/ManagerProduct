package com.github.kamys.managerProduct.data.managers;

import com.github.kamys.managerProduct.data.HibernateManager;
import com.github.kamys.managerProduct.data.managers.criteria.CriteriaHelper;
import com.github.kamys.managerProduct.data.managers.criteria.Parameters;
import com.github.kamys.managerProduct.logic.layout.Layout;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import java.util.Collection;
import java.util.List;

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
    public void update(CriteriaHelper<Layout> criteriaHelper, Parameters newParameters) {
        LOGGER.info("update: criteriaHelper = " + criteriaHelper + " newParameters = " + newParameters);
        Transaction tr = null;
        try (Session session = factory.openSession()) {
            tr = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaUpdate<Layout> delete = criteriaHelper
                    .createCriteriaUpdate(builder, newParameters);

            session.createQuery(delete).executeUpdate();
            tr.commit();

        } catch (HibernateException e) {
            if (tr != null) tr.rollback();
            LOGGER.warn(e);
        }
        LOGGER.debug("update: stop");
    }

    @Override
    public Collection<Layout> delete(CriteriaHelper<Layout> criteriaHelper) {
        LOGGER.info("delete: criteriaHelper = " + criteriaHelper);
        Transaction tr = null;
        try (Session session = factory.openSession()) {
            tr = session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaDelete<Layout> delete = criteriaHelper
                    .createCriteriaDelete(builder);

            session.createQuery(delete).executeUpdate();
            tr.commit();

        } catch (HibernateException e) {
            if (tr != null) tr.rollback();
            LOGGER.warn(e);
        }
        LOGGER.debug("delete: stop");
        return null;
    }

    @Override
    public Collection<Layout> select(CriteriaHelper<Layout> criteriaHelper) {
        LOGGER.info("select: criteriaHelper = " + criteriaHelper);
        Transaction tr = null;
        try (Session session = factory.openSession()) {
            tr = session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Layout> select = criteriaHelper
                    .createCriteriaSelect(builder);

            Query<Layout> query = session.createQuery(select);
            List<Layout> resultList = query.getResultList();
            tr.commit();
            return resultList;
        } catch (HibernateException e) {
            if (tr != null) tr.rollback();
            LOGGER.warn(e);
            throw e;
        }
    }

    @Override
    public Collection<Layout> selectAll() {
        Transaction tr = null;
        try (Session session = factory.openSession()) {
            LOGGER.info("selectAll()");
            tr = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaQuery<Layout> criteria = builder.createQuery(Layout.class);
            criteria.from(Layout.class);
            Query<Layout> query = session.createQuery(criteria);
            List<Layout> result = query.list();
            LOGGER.info("selectAll: return = " + result);
            return result;
        } catch (HibernateException e) {
            if (tr != null) tr.rollback();
            LOGGER.warn(e);
            throw e;
        }
    }

    @Override
    public void close() {
        if (!factory.isClosed()) {
            factory.close();
        }
    }

}
