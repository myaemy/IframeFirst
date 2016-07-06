package com.example.aemy.iframeyong.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * @Description: 单例Toast
 * @Author: tanghongxiang（thx76222@gmail.com）
 * @Version: V1.00 （版本号）
 * @Create Date: 2016-5-23下午12:57:03
 */
public class ToastUtils {
	private static String oldMsg;
	protected static Toast toast = null;
	private static long oneTime = 0;
	private static long twoTime = 0;

	public static void showToast(Context context, String s) {
		if (toast == null) {
			toast = Toast.makeText(context, s, Toast.LENGTH_SHORT);
			toast.show();
			oneTime = System.currentTimeMillis();
		} else {
			twoTime = System.currentTimeMillis();
			if (s.equals(oldMsg)) {
				if (twoTime - oneTime > Toast.LENGTH_SHORT) {
					toast.show();
				}
			} else {
				oldMsg = s;
				toast.setText(s);
				toast.show();
			}
		}
		oneTime = twoTime;
	}

	public static void showToast(Context context, int resId) {
		showToast(context, context.getString(resId));
	}

}
