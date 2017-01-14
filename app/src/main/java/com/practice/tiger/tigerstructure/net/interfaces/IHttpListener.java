package com.practice.tiger.tigerstructure.net.interfaces;

import org.apache.http.HttpEntity;

/**
 * Author：NaShichao
 * Time：2017/1/13  下午9:48
 * Email：na.shichao@163.com
 * Description：
 */

public interface IHttpListener {
    /**
     * 网络访问
     * 处理结果，回调
     * @param httpEntity
     */
    void onSuccess(HttpEntity httpEntity);

    void onFail();
}
