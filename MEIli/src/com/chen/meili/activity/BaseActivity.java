package com.chen.meili.activity;

import com.chen.meili.TApplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class BaseActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 添加Activity到集合
		TApplication.listActivity.add(this);

	}

}
