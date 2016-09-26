package net.d80harri.easydal;


import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by d80harri on 26.09.16.
 */
public class BaseQuery implements IQuery {
    @Override
    public <T> QueryResult<T> query(ICriterion<T> criterion, Pager pager, Session session) {
        String hql = toHql(criterion);
        Query query = session.createQuery(hql);
        List resultList = query.getResultList();

        return new QueryResult<>(resultList, pager);
    }

    <T> String toHql(ICriterion<T> criterion) {
        Class<T> entityType = criterion.getEntityType();
        return String.format("FROM %s WHERE %s", entityType.getName(), criterion.toHql());
    }
}
