package edu.estu.webserver.core.business;

import edu.estu.webserver.core.utilities.results.DataResult;
import edu.estu.webserver.core.utilities.results.Result;

public interface BaseService<T> {
    Result add(T entity);
    Result delete(int id);
    Result update(T entity);
    DataResult getAll();
    DataResult getById(int id);
}
