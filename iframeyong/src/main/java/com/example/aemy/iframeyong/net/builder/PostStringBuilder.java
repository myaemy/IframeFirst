package com.example.aemy.iframeyong.net.builder;

import com.example.aemy.iframeyong.net.request.PostStringRequest;
import com.example.aemy.iframeyong.net.request.RequestCall;

import okhttp3.MediaType;

/**
 * 
 * @Description: 
 * @Author: tanghongxiang（thx76222@gmail.com）
 * @Version: V1.00 （版本号）
 * @Create Date: 2016-6-7下午12:26:20
 */
public class PostStringBuilder extends OkHttpRequestBuilder<PostStringBuilder>
{
    private String content;
    private MediaType mediaType;


    public PostStringBuilder content(String content)
    {
        this.content = content;
        return this;
    }

    public PostStringBuilder mediaType(MediaType mediaType)
    {
        this.mediaType = mediaType;
        return this;
    }

    @Override
    public RequestCall build()
    {
        return new PostStringRequest(url, tag, params, headers, content, mediaType).build();
    }


}
