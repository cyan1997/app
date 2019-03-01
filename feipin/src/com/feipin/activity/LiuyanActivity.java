package com.feipin.activity;
/**
 * ����������Ϣ
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
public class LiuyanActivity extends Activity {
	private static final String TAG = "ShiWuXinXiActivity";
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
		setContentView(R.layout.liuyan);
		
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
		.detectDiskReads().detectDiskWrites().detectNetwork()
		.penaltyLog().build());

		StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
		.detectLeakedSqlLiteObjects().penaltyLog().penaltyDeath()
		.build());
		
		SharedPreferences  mSharedPreferences = getSharedPreferences("SharedPreferences", Context.MODE_PRIVATE);
		username = mSharedPreferences.getString("login_name","none");
		faubuContentEditText = (EditText)findViewById(R.id.fabu_content);
	   
	}
	
	 public void fabuliuyanInfor(View v) {     //����������Ϣ
	    	
		 if(!"".equals(faubuContentEditText.getText().toString())){
			    // ��÷�������
		 		String fabuContent = faubuContentEditText.getText().toString();

		 		Log.i(TAG, "LiuyanActivity >>>>>>>>>>>>>>>> : " + fabuContent);
		 		// ��÷������
		 		String result= fabuLiuyanContent(username,fabuContent);
		 		if(result!=null&&result.equals("success")){
		 			 
					 new AlertDialog.Builder(LiuyanActivity.this)
						.setIcon(getResources().getDrawable(R.drawable.login_error_icon))
						.setTitle("������Ϣ����")
						.setMessage("������Ϣ�����ɹ���")
						.create().show();
		 		}else{
					 new AlertDialog.Builder(LiuyanActivity.this)
						.setIcon(getResources().getDrawable(R.drawable.login_error_icon))
						.setTitle("������Ϣ����")
						.setMessage("������Ϣ����ʧ�ܣ�")
						.create().show();
		 		}
		 }else{
			 new AlertDialog.Builder(LiuyanActivity.this)
				.setIcon(getResources().getDrawable(R.drawable.login_error_icon))
				.setTitle("������Ϣ����")
				.setMessage("������Ϣ����Ϊ��!")
				.create().show();
		 }
		 
	    	
	}  
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	

	public void liuyan_back(View v){
		Intent lostIntent = new Intent(LiuyanActivity.this, HomeActivity.class);
		startActivity(lostIntent);
	}
	
	// ����������Ϣ����
 	private String fabuLiuyanContent(String username, String content){
 		// ��ѯ����
 		String queryString = "content="+content+"&username="+username;
 		// url
 		String url = HttpUtil.BASE_URL+"servlet/LiuyanServlet?"+queryString;
 		Log.i(TAG, "fabuLiuyanContent >>>>>> : " + url) ;
 		// ��ѯ���ؽ��
 		return HttpUtil.queryStringForPost(url);
     }


	
}
