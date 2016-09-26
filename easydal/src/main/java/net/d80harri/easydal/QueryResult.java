package net.d80harri.easydal;

import java.util.List;

/**
 * Created by d80harri on 26.09.16.
 */
public class QueryResult<T> {
    private final List<T> page;
    private final Pager pager;

    QueryResult(List<T> page, Pager pager) {
        this.page = page;
        this.pager = pager;
    }

    public List<T> getPage() {
        return page;
    }

    public Pager getPager() {
        return pager;
    }
}
