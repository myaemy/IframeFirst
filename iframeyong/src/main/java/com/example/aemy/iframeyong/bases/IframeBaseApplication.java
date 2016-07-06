package com.example.aemy.iframeyong.bases;


import android.app.Application;
import android.os.Handler;

public class IframeBaseApplication extends Application {

	// 获取到主线程的上下文
	private static IframeBaseApplication mContext = null;
	// 获取到主线程的handler
	private static Handler mMainThreadHandler = null;

	// 获取到主线程
	private static Thread mMainThread = null;
	
	// 获取到主线程的id
	private static int mMainThreadId;

	@Override
	public void onCreate() {
		super.onCreate();
		this.mContext = this;
		this.mMainThread = Thread.currentThread();
		this.mMainThreadId = android.os.Process.myTid();
		this.mMainThreadHandler = new Handler();
	}

	// 对外暴露主线程
	public static Thread getMainThread() {
		return mMainThread;
	}

	// 对外暴露上下文
	public static IframeBaseApplication getApplication() {
		return mContext;
	}

	// 对外暴露主线程id
	public static int getMainThreadId() {
		return mMainThreadId;
	}

	// 对外暴露主线程的handler
	public static Handler getMainThreadHandler() {
		return mMainThreadHandler;
	}
	
	
}
