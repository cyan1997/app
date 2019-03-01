package com.feipin.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.TextView;

import com.feipin.R;
import com.feipin.util.HttpUtil;

public class InforActivity extends Activity {

	@SuppressLint("NewApi")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.infor_system);

		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
				.detectDiskReads().detectDiskWrites().detectNetwork()
				.penaltyLog().build());

		StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
				.detectLeakedSqlLiteObjects().penaltyLog().penaltyDeath()
				.build());

		TextView tv1 = (TextView) findViewById(R.id.infor_textView1);
		tv1.setText(InitData()) ;
	}

	/**
	 * 获取介绍数据的数据
	 * 
	 * @return
	 */
	private String InitData() {

		String url = HttpUtil.BASE_URL + "servlet/InforServlet";
		String result = HttpUtil.queryStringForGet(url);
		return result;

	}
	
	public void infor_back(View v){
		Intent lostIntent = new Intent(InforActivity.this, HomeActivity.class);
		startActivity(lostIntent);
	}
}
