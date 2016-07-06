package com.example.aemy.iframeyong.net.callback;

import java.io.IOException;

import okhttp3.Response;

/**
 * 
 * @Description: 
 * @Author: tanghongxiang（thx76222@gmail.com）
 * @Version: V1.00 （版本号）
 * @Create Date: 2016-6-7下午12:26:49
 */
public abstract class TCallback extends Callback<String>
{
    @Override
    public String parseNetworkResponse(Response response) throws IOException
    {
//    	T t=JSON.parseObject(response.body().string(), clazz);
        return "";
    }
}
