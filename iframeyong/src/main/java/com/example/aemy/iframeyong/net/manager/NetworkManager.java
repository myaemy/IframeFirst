package com.example.aemy.iframeyong.net.manager;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.example.aemy.iframeyong.net.OkHttpUtils;
import com.example.aemy.iframeyong.net.builder.PostFormBuilder;
import com.example.aemy.iframeyong.net.callback.Callback;
import com.example.aemy.iframeyong.net.callback.FileCallBack;
import com.example.aemy.iframeyong.net.listener.ResponseHandler;
import com.example.aemy.iframeyong.net.request.RequestCall;
import com.example.aemy.iframeyong.utils.NetCheckedUtils;
import com.example.aemy.iframeyong.utils.ToastUtils;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.Response;

/**
 * @Description:
 * @Author: tanghongxiang（thx76222@gmail.com）
 * @Version: V1.00 （版本号）
 * @Create Date: 2016-5-23下午12:47:43
 */
public class NetworkManager {
    private static NetworkManager networkManager;

    private NetworkManager() {

    }

    public synchronized static NetworkManager getNetworkManager() {
        if (networkManager != null) {
            return networkManager;
        } else {
            networkManager = new NetworkManager();
            return networkManager;
        }
    }


    /**
     * 普通get请求
     *
     * @param url
     * @param params
     */
    public static <T> void getRequest(Context context, String url, Map<String, String> params, final Class<?> clazz, final ResponseHandler responsehandler) {
        if (!NetCheckedUtils.hasConnectedNetwork(context)) {
            ToastUtils.showToast(context, "请检查您的网络连接");
            responsehandler.onNullNetWork();
            return;
        }
        responsehandler.onStartLoading();
        OkHttpUtils
                .get()
                .url(url)
                .params(params)
                .build()
                .execute(new Callback<Response>() {
                    @Override
                    public Response parseNetworkResponse(Response response)
                            throws Exception {
                        return response;
                    }

                    @Override
                    public void onError(Call call, Exception e) {
                        responsehandler.onError(e);
                    }

                    @Override
                    public void onResponse(Response response) {
                        if (clazz != null) {
                            try {
                                Object obj = JSON.parseObject(response.body().string(), clazz);
                                if (obj != null) {
                                    responsehandler.onSuccess(response.isSuccessful(), obj);
                                } else {
                                    responsehandler.onNullData();
                                }
                            } catch (IOException e) {
                                responsehandler.onError(e);
                            }
                        } else {
                            try {
                                responsehandler.onSuccess(response.isSuccessful(), response.body().string());
                            } catch (IOException e) {
                                responsehandler.onError(e);
                            }
                        }
                    }
                });
    }

    /**
     * 普通post请求
     *
     * @param url
     * @param params
     */
    public static <T> void postRequest(Context context, String url, Map<String, String> params, final Class<?> clazz, final ResponseHandler responsehandler) {
        if (!NetCheckedUtils.hasConnectedNetwork(context)) {
            ToastUtils.showToast(context, "请检查您的网络连接");
            responsehandler.onNullNetWork();
            return;
        }
        responsehandler.onStartLoading();
        OkHttpUtils
                .post()
                .url(url)
                .params(params)
                .build()
                .execute(new Callback<Response>() {
                    @Override
                    public Response parseNetworkResponse(Response response)
                            throws Exception {
                        return response;
                    }

                    @Override
                    public void onError(Call call, Exception e) {
                        responsehandler.onError(e);
                    }

                    @Override
                    public void onResponse(Response response) {
                        if (clazz != null) {
                            try {
                                Object obj = JSON.parseObject(response.body().string(), clazz);
                                if (obj != null) {
                                    responsehandler.onSuccess(response.isSuccessful(), obj);
                                } else {
                                    responsehandler.onNullData();
                                }
                            } catch (IOException e) {
                                responsehandler.onError(e);
                            }
                        } else {
                            try {
                                responsehandler.onSuccess(response.isSuccessful(), response.body().string());
                            } catch (IOException e) {
                                responsehandler.onError(e);
                            }
                        }
                    }
                });
    }

    /**
     * 以json串为参数的post请求
     *
     * @param url
     * @param json
     */
    public static <T> void postJsonString(Context context, String url, String json, final Class<?> clazz, final ResponseHandler responsehandler) {
        if (!NetCheckedUtils.hasConnectedNetwork(context)) {
            ToastUtils.showToast(context, "请检查您的网络连接");
            responsehandler.onNullNetWork();
            return;
        }
        responsehandler.onStartLoading();
        OkHttpUtils
                .postString()
                .url(url)
                .mediaType(MediaType.parse("application/json; charset=utf-8"))
                .content(json)
                .build()
                .execute(new Callback<Response>() {
                    @Override
                    public Response parseNetworkResponse(Response response)
                            throws Exception {
                        return response;
                    }

                    @Override
                    public void onError(Call call, Exception e) {
                        responsehandler.onError(e);
                    }

                    @Override
                    public void onResponse(Response response) {
                        if (clazz != null) {
                            try {
                                Object obj = JSON.parseObject(response.body().string(), clazz);
                                if (obj != null) {
                                    responsehandler.onSuccess(response.isSuccessful(), obj);
                                } else {
                                    responsehandler.onNullData();
                                }
                            } catch (IOException e) {
                                responsehandler.onError(e);
                            }
                        } else {
                            try {
                                responsehandler.onSuccess(response.isSuccessful(), response.body().string());
                            } catch (IOException e) {
                                responsehandler.onError(e);
                            }
                        }
                    }
                });
    }

    /**
     * 单个文件上传
     *
     * @param url
     * @param file
     * @param callback
     */
    public static <T> void postFile(Context context, String url, File file, Callback<T> callback) {
        if (!NetCheckedUtils.hasConnectedNetwork(context)) {
            ToastUtils.showToast(context, "请检查您的网络连接");
            return;
        }
        OkHttpUtils
                .postFile()
                .url(url)
                .file(file)
                .build()
                .execute(callback);
    }

    /**
     * 表单文件上传
     *
     * @param url
     * @param headers
     * @param params
     * @param files
     * @param callback
     */
    public static <T> void postFormFile(Context context, String url, Map<String, String> headers, Map<String, String> params, Map<String, File> files, Callback<T> callback) {
        if (!NetCheckedUtils.hasConnectedNetwork(context)) {
            ToastUtils.showToast(context, "请检查您的网络连接");
            return;
        }
        PostFormBuilder builder = OkHttpUtils.post().url(url);
        if (files != null && files.size() > 0) {
            for (Map.Entry<String, File> entry : files.entrySet()) {
                File file = entry.getValue();
                if (file != null) {
                    builder.addFile(entry.getKey(), file.getName(), file);
                }
            }
        }
        if (params != null && params.size() > 0) {
            builder.params(params);
        }
        if (headers != null && headers.size() > 0) {
            builder.headers(headers);
        }
        builder.build()
                .connTimeOut(60 * 1000)
                .readTimeOut(2 * 60 * 1000)
                .execute(callback);
    }

    /**
     * 文件下载
     *
     * @param url
     * @param callback
     */
    public static void downLoadFile(Context context, String url, FileCallBack callback) {
        if (!NetCheckedUtils.hasConnectedNetwork(context)) {
            ToastUtils.showToast(context, "请检查您的网络连接");
            return;
        }
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .connTimeOut(60 * 1000)
                .readTimeOut(2 * 60 * 1000)
                .execute(callback);
    }

    /**
     * 取消网络请求
     *
     * @param url
     */
    public static void CancelRequest(String url) {
        RequestCall call = OkHttpUtils.get().url(url).build();
        call.cancel();
    }


}
