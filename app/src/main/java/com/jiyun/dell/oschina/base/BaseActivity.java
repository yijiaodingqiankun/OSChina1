package com.jiyun.dell.oschina.base;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.jiyun.dell.oschina.global.MyApp;


/**
 * baseActivity后面的所有都要继承此activity
 */

public abstract class BaseActivity extends FragmentActivity {
	/**
	 * onCreate方法中写初始化view
	 * @param arg0
	 */
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(getLayout());
		MyApp.mBaseActivity = this;
		initId();

	}


	protected abstract void initData();

	protected abstract void initId();

	protected abstract int getLayout();

	/**
	 * Resume方法中初始化数据
	 */
	@Override
	protected void onResume() {
		super.onResume();
		MyApp.mBaseActivity = this;
		initData();
	}
}
