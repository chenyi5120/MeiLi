package com.chen.meili;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.util.Log;

public class TApplication extends Application {
	public static Context applicationContext;
	private static TApplication instance;

	public static ArrayList<Activity> listActivity = new ArrayList();
	/**
	 * 登陆用户名
	 */
	public final String PREF_USERNAME = "username";

	@Override
	public void onCreate() {
		super.onCreate();
		Log.i("TAG", "TApplication onCreate");
		instance = this;
		//initEm();
	}

	/**
	 * 初始化 集成环信
	 */
	private void initEm() {
		EMOptions options = new EMOptions();
		// 默认添加好友时，是不需要验证的，改成需要验证
		options.setAcceptInvitationAlways(false);
		// =========================================================
		
		int pid = android.os.Process.myPid();
		String processAppName = getAppName(pid);
		// 如果APP启用了远程的service，此application:onCreate会被调用2次
		// 为了防止环信SDK被初始化2次，加此判断会保证SDK被初始化1次
		// 默认的APP会在以包名为默认的process name下运行，如果查到的process name不是APP的process
		// name就立即返回

		if (processAppName == null || !processAppName.equalsIgnoreCase(applicationContext.getPackageName())) {
			Log.e("TAG", "enter the service process!");

			// 则此application::onCreate 是被service 调用的，直接返回
			return;
		}
		// =========================================================
		// 初始化
		EMClient.getInstance().init(applicationContext, options);
		// 在做打包混淆时，关闭debug模式，避免消耗不必要的资源
		EMClient.getInstance().setDebugMode(true);
	}

	/**
	 * 退出程序
	 */
	public void exit() {
		for (int i = 0; i < listActivity.size(); i++) {
			try {
				Activity activity = listActivity.get(i);
				activity.finish();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.exit(0);
	}

	/**
	 * 获取APPName
	 * 
	 * @param pID
	 * @return
	 */
	private String getAppName(int pID) {
		String processName = null;
		ActivityManager am = (ActivityManager) this.getSystemService(ACTIVITY_SERVICE);
		List l = am.getRunningAppProcesses();
		Iterator i = l.iterator();
		while (i.hasNext()) {
			ActivityManager.RunningAppProcessInfo info = (ActivityManager.RunningAppProcessInfo) (i.next());
			try {
				if (info.pid == pID) {
					processName = info.processName;
					return processName;
				}
			} catch (Exception e) {
				// Log.d("Process", "Error>> :"+ e.toString());
			}
		}
		return processName;
	}

}
