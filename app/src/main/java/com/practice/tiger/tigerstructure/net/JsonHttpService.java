package com.practice.tiger.tigerstructure.net;


import com.practice.tiger.tigerstructure.net.interfaces.IHttpListener;
import com.practice.tiger.tigerstructure.net.interfaces.IHttpService;

import org.apache.http.HttpClientConnection;
import org.apache.http.impl.DefaultHttpClientConnection;

/**
 * Author：NaShichao
 * Time：2017/1/13  下午10:26
 * Email：na.shichao@163.com
 * Description：
 */

public class JsonHttpService implements IHttpService {

    private IHttpListener httpListener;
    private HttpClientConnection httpClient = new DefaultHttpClientConnection();
    private String url;
    private byte[] requestData;

    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public void execute() {
    }

    @Override
    public void setHttpListener(IHttpListener httpListener) {
        this.httpListener = httpListener;
    }

    @Override
    public void setRequestData(byte[] requestData) {
        this.requestData = requestData;
    }
}
