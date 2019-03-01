package com.feipin.activity;
/**
 * 发布收废品信息
 */
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.feipin.R;
import com.feipin.util.HttpUtil;
public class ShiWuXinXi2Activity extends Activity {
	private static final String TAG = "ShiWuXinXi2Activity";
	EditText faubuContentEditText;
	DatePicker date ;
    private Spinner spinner;
	private ArrayAdapter<String> adapter;
	private String[] loginTypeStr = null;
	private String selLoginType;
	private String username ;
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shiwuxinxi2);
		
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
		.detectDiskReads().detectDiskWrites().detectNetwork()
		.penaltyLog().build());

		StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
		.detectLeakedSqlLiteObjects().penaltyLog().penaltyDeath()
		.build());
		
		SharedPreferences  mSharedPreferences = getSharedPreferences("SharedPreferences", Context.MODE_PRIVATE);
		username = mSharedPreferences.getString("login_name","none");
		faubuContentEditText = (EditText)findViewById(R.id.fabu_content);
		date = (DatePicker) findViewById(R.id.datePicker1);
	   
	}
	
	 public void fabuShiWuInfor(View v) {     //发布收废品信息
	    	
		 if(!"".equals(faubuContentEditText.getText().toString())){
			    // 获得发布内容
		 		String fabuContent = faubuContentEditText.getText().toString();

		 		Log.i(TAG, "ShiWuXinXi2Activity >>>>>>>>>>>>>>>> : " + fabuContent);
		 		String fabuDateString = "" +date.getYear() +"-" +date.getMonth() + "-" + date.getDayOfMonth() ;
		 		// 获得发布结果
		 		String result= fabuShiWuContent(username,fabuContent,fabuDateString);
		 		if(result!=null&&result.equals("success")){
		 			 
					 new AlertDialog.Builder(ShiWuXinXi2Activity.this)
						.setIcon(getResources().getDrawable(R.drawable.login_error_icon))
						.setTitle("收废品信息发布")
						.setMessage("收废品信息发布成功！")
						.create().show();
		 		}else{
					 new AlertDialog.Builder(ShiWuXinXi2Activity.this)
						.setIcon(getResources().getDrawable(R.drawable.login_error_icon))
						.setTitle("收废品信息发布")
						.setMessage("收废品信息发布拾败！")
						.create().show();
		 		}
		 }else{
			 new AlertDialog.Builder(ShiWuXinXi2Activity.this)
				.setIcon(getResources().getDrawable(R.drawable.login_error_icon))
				.setTitle("收废品信息发布")
				.setMessage("收废品信息不能为空!")
				.create().show();
		 }
		 
	    	
	}  
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	

	public void shiwuxinxi_back(View v){
		Intent lostIntent = new Intent(ShiWuXinXi2Activity.this, HomeActivity.class);
		startActivity(lostIntent);
	}
	
	// 发布收废品信息内容
 	private String fabuShiWuContent(String username, String content,String time){
 		// 查询参数
 		String queryString = "type=2&content="+content+"&time="+time+"&username="+username;
 		// url
 		String url = HttpUtil.BASE_URL+"servlet/ShiWuInfoServlet?"+queryString;
 		Log.i(TAG, "fabuShiwucontent >>>>>> : " + url) ;
 		// 查询返回结果
 		return HttpUtil.queryStringForPost(url);
     }


	
}
