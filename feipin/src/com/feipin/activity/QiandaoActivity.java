package com.feipin.activity;
/**
 * ǩ����Ϣ
 */
import java.text.SimpleDateFormat;
import java.util.Date;

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
public class QiandaoActivity extends Activity {
	private static final String TAG = "QiandaoActivity";
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
		setContentView(R.layout.qiandao);
		
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
	
	 public void fabuliuyanInfor(View v) {     //ǩ����Ϣ
	    	
		 		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd H:m:s");
			    // ǩ��ʱ��
		 		String fabuContent = format.format(new Date());

		 		Log.i(TAG, "ǩ��Activity >>>>>>>>>>>>>>>> : " + fabuContent);
		 		// ��÷������
		 		String result= fabuLiuyanContent(username);
		 		if(result!=null&&result.equals("success")){
		 			 
					 new AlertDialog.Builder(QiandaoActivity.this)
						.setIcon(getResources().getDrawable(R.drawable.login_error_icon))
						.setTitle("ǩ��")
						.setMessage("ǩ���ɹ���")
						.create().show();
		 		}else{
					 new AlertDialog.Builder(QiandaoActivity.this)
						.setIcon(getResources().getDrawable(R.drawable.login_error_icon))
						.setTitle("ǩ��")
						.setMessage("ǩ��ʧ�ܣ�")
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
		Intent lostIntent = new Intent(QiandaoActivity.this, HomeActivity.class);
		startActivity(lostIntent);
	}
	
	// ����������Ϣ����
 	private String fabuLiuyanContent(String username){
 		// ��ѯ����
 		String queryString = "username="+username;
 		// url
 		String url = HttpUtil.BASE_URL+"servlet/QiandaoServlet?"+queryString;
 		Log.i(TAG, "fabuLiuyanContent >>>>>> : " + url) ;
 		// ��ѯ���ؽ��
 		return HttpUtil.queryStringForPost(url);
     }


	
}
