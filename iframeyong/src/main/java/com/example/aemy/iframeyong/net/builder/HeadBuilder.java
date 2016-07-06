package com.example.aemy.iframeyong.net.builder;

import com.example.aemy.iframeyong.net.OkHttpUtils;
import com.example.aemy.iframeyong.net.request.OtherRequest;
import com.example.aemy.iframeyong.net.request.RequestCall;

/**
 * 
 * @Description: 
 * @Author: tanghongxiang（thx76222@gmail.com）
 * @Version: V1.00 （版本号）
 * @Create Date: 2016-6-7下午12:25:48
 */
public class HeadBuilder extends GetBuilder
{
    @Override
    public RequestCall build()
    {
        return new OtherRequest(null, null, OkHttpUtils.METHOD.HEAD, url, tag, params, headers).build();
    }
}
