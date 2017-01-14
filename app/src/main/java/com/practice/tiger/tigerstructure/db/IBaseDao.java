package com.practice.tiger.tigerstructure.db;

/**
 * Author：NaShichao
 * Time：2017/1/10  上午11:50
 * Email：na.shichao@163.com
 * Description：
 */

public interface IBaseDao<T> {
    Long insert(T entity);

    Long update(T entity, T where);
}
