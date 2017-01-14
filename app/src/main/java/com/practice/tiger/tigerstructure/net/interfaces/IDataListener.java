package com.practice.tiger.tigerstructure.net.interfaces;

/**
 * Author：NaShichao
 * Time：2017/1/13  下午10:06
 * Email：na.shichao@163.com
 * Description：
 */

public interface IDataListener<M> {
    /**
     * 回调结果，给调用层
     *
     * @param m
     */
    void onSuccess(M m);

    void onFail();
}
