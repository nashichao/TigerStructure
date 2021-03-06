package com.practice.tiger.tigerstructure.db.annotion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author：NaShichao
 * Time：2017/1/10  上午11:54
 * Email：na.shichao@163.com
 * Description：
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DbTable {
    String value();
}
