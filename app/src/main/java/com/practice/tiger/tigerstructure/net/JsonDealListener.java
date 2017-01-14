package com.practice.tiger.tigerstructure.net;

import com.alibaba.fastjson.JSON;
import com.practice.tiger.tigerstructure.net.interfaces.IDataListener;
import com.practice.tiger.tigerstructure.net.interfaces.IHttpListener;

import org.apache.http.HttpEntity;

import java.io.IOException;
import java.io.InputStream;

/**
 * Author：NaShichao
 * Time：2017/1/13  下午10:16
 * Email：na.shichao@163.com
 * Description：
 */

public class JsonDealListener<M> implements IHttpListener {

    private Class<M> response;
    /**
     * 回调调用层的接口
     */
    private IDataListener<M> dataListener;

    public JsonDealListener(Class<M> response, IDataListener<M> dataListener) {
        this.response = response;
        this.dataListener = dataListener;
    }

    @Override
    public void onSuccess(HttpEntity httpEntity) {
        InputStream inputStream = null;
        try {
            inputStream = httpEntity.getContent();
            String content = getContent();
            M m = JSON.parseObject(content, response);

        } catch (IOException e) {
            e.printStackTrace();
            dataListener.onFail();
        }
    }

    private String getContent() {
        return "dsfsd";
    }

    @Override
    public void onFail() {

    }
}
