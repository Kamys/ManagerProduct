package com.github.kamys.managerProduct.data.managers;

import com.github.kamys.managerProduct.data.HibernateManager;
import com.github.kamys.managerProduct.data.managers.criteria.CriteriaFactory;
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
            LOGGER.warn(e);
            if (tr != null) tr.rollback();
            throw e;
        }
    }

    @Override
    public void update(Parameters oldParameters, Parameters newParameters) {
        LOGGER.info("update: oldParameters = " + oldParameters + " newParameters = " + newParameters);
        Transaction tr = null;
        try (Session session = factory.openSession()) {
            tr = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaHelper<Layout> criteriaHelper =
                    CriteriaFactory.createCriteria(oldParameters);
            CriteriaUpdate<Layout> update = criteriaHelper
                    .createCriteriaUpdate(builder, newParameters);

            session.createQuery(update).executeUpdate();
            tr.commit();

        } catch (HibernateException e) {
            LOGGER.warn(e);
            if (tr != null) tr.rollback();
            throw e;
        }
        LOGGER.debug("update: stop");
    }

    @Override
    public Collection<Layout> delete(Parameters findParameters) {
        LOGGER.info("delete: findParameters = " + findParameters);
        Transaction tr = null;
        try (Session session = factory.openSession()) {
            tr = session.beginTransaction();

            CriteriaHelper<Layout> criteriaHelper =
                    CriteriaFactory.createCriteria(findParameters);
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaDelete<Layout> delete = criteriaHelper
                    .createCriteriaDelete(builder);

            session.createQuery(delete).executeUpdate();
            tr.commit();

        } catch (HibernateException e) {
            LOGGER.warn(e);
            if (tr != null) tr.rollback();
            throw e;
        }
        LOGGER.debug("delete: stop.");
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
            LOGGER.warn(e);
            if (tr != null) tr.rollback();
            throw e;
        }
    }

    @Override
    public Collection<Layout> getAll() {
        Transaction tr = null;
        try (Session session = factory.openSession()) {
            LOGGER.info("getAll()");
            tr = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaQuery<Layout> criteria = builder.createQuery(Layout.class);
            criteria.from(Layout.class);
            Query<Layout> query = session.createQuery(criteria);
            List<Layout> result = query.list();
            LOGGER.info("getAll: return = " + result);
            return result;
        } catch (HibernateException e) {
            LOGGER.warn(e);
            if (tr != null) tr.rollback();
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
