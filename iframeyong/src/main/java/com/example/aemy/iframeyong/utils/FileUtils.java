package com.example.aemy.iframeyong.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import android.widget.Toast;

import java.io.File;

/**
 * 
 * @Description: 
 * @Author: tanghongxiang（thx76222@gmail.com）
 * @Version: V1.00 （版本号）
 * @Create Date: 2016-6-7下午12:30:58
 */
public class FileUtils {

	/**
	 * 调用系统方法打开指定路径的文件
	 * 
	 * @param context
	 * @param filePath
	 */
	public static void openFile(Context context, String filePath) {
		if (!TextUtils.isEmpty(filePath)) {
			try {
				context.startActivity(getAllIntent(filePath));
			} catch (Exception e) {
				Toast.makeText(context, "无法打开此文件！", Toast.LENGTH_SHORT).show();
			}
		} else {
			 Toast.makeText(context, "无法打开此文件！", Toast.LENGTH_SHORT).show();
		}
	}

	public static Intent getAllIntent(String param) {
		Intent intent = new Intent();
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.setAction(Intent.ACTION_VIEW);
		Uri uri = Uri.fromFile(new File(param));
		intent.setDataAndType(uri, getMimeType(param));
		return intent;
	}

	/**
	 * 得到指定文件的MIME-type
	 * @param fileName
	 * @return
	 */
	public static String getMimeType(String fileName) {
		MimeTypeMap map = MimeTypeMap.getSingleton();
		int index = fileName.lastIndexOf(".");
		if (index < 0) {
			return null;
		}
		return map.getMimeTypeFromExtension(fileName.substring(index + 1));
	}
	
	/**
	 * 格式化文件大小
	 * 
	 * @param bytelen
	 * @return
	 */
	@SuppressLint("DefaultLocale")
	public static String formatFileSize(long bytelen) {
		String ret = null;
		float flt;
		if (bytelen < (1 << 20)) {
			flt = (float) bytelen / 1024;
			ret = String.format("%.1f KB", flt);
		} else {
			flt = (float) bytelen / (1 << 20);
			ret = String.format("%.1f MB", flt);
		}
		return ret;
	}
}
