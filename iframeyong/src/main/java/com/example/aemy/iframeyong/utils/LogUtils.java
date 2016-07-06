package com.example.aemy.iframeyong.utils;

import android.util.Log;


/**
 * 自定义Log工具类
 * 
 * @author ajun
 * 
 */
public class LogUtils {
	private static boolean flag=true;
	public static void showLog(String tag,String msg){
		if(flag){
			Log.i(tag, msg);
		}
	}
}	