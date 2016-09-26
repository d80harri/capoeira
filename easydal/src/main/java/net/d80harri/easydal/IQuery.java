package net.d80harri.easydal;

import org.hibernate.Session;

/**
 * Created by d80harri on 26.09.16.
 */
public interface IQuery {
    <T> QueryResult<T> query(ICriterion<T> criterion, Pager pager, Session session);
}
