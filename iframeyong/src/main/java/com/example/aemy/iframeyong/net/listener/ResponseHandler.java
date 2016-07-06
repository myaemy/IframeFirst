package com.example.aemy.iframeyong.net.listener;

public interface ResponseHandler {


	/**
	 * 请求成功
	 * @param code
	 * @param response
	 */
	public void onSuccess(boolean code,Object response);

	/**
	 * 请求失败
	 * @param e
	 */
	public void onError(Exception e);

	/**
	 * 开始请求
	 */
	public void onStartLoading();

	/**
	 * 请求成功没有数据
	 */
	public void onNullData();

	/**
	 * 没有网
	 */
	public void onNullNetWork();
}
