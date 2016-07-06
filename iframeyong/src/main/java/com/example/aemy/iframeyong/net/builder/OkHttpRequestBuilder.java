package com.example.aemy.iframeyong.net.builder;

import com.example.aemy.iframeyong.net.request.RequestCall;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * @Description: @param <T>
 * @Author: tanghongxiang（thx76222@gmail.com）
 * @Version: V1.00 （版本号）
 * @Create Date: 2016-6-7下午12:25:53
 */
public abstract class OkHttpRequestBuilder<T extends OkHttpRequestBuilder>
{
    protected String url;
    protected Object tag;
    protected Map<String, String> headers;
    protected Map<String, String> params;

    public T url(String url)
    {
        this.url = url;
        return (T) this;
    }


    public T tag(Object tag)
    {
        this.tag = tag;
        return (T) this;
    }

    public T headers(Map<String, String> headers)
    {
        this.headers = headers;
        return (T) this;
    }

    public T addHeader(String key, String val)
    {
        if (this.headers == null)
        {
            headers = new LinkedHashMap<>();
        }
        headers.put(key, val);
        return (T) this;
    }

    public abstract RequestCall build();
}
