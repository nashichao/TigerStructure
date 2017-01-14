package com.practice.tiger.tigerstructure.net.interfaces;

/**
 * Author：NaShichao
 * Time：2017/1/13  下午10:06
 * Email：na.shichao@163.com
 * Description：
 */

public interface IHttpService {
    /**
     * 设置Url
     * @param url
     */
    void setUrl(String url);

    /**
     * 执行获取网络
     */
    void execute();

    /**
     * 设置处理接口
     * @param httpListener
     */
    void setHttpListener(IHttpListener httpListener);

    /**
     * 设置请求参数
     */
    void setRequestData(byte[] requestData);
}
