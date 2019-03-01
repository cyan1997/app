package com.feipin.activity;

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
import android.widget.EditText;
import android.widget.Spinner;

import com.feipin.R;
import com.feipin.util.HttpUtil;
public class UserInforActivity extends Activity {
	private static final String TAG = "UserInforActivity";
	EditText phoneEditText;
    EditText weixinEditText;
    EditText qqEditText;
    
    private Spinner spinner;
	private ArrayAdapter<String> adapter;
	private String[] loginTypeStr = null;
	private String selLoginType;
	private String username ;
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.userinfor);
		
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
		.detectDiskReads().detectDiskWrites().detectNetwork()
		.penaltyLog().build());

		StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
		.detectLeakedSqlLiteObjects().penaltyLog().penaltyDeath()
		.build());
		
		SharedPreferences  mSharedPreferences = getSharedPreferences("SharedPreferences", Context.MODE_PRIVATE);
		username = mSharedPreferences.getString("login_name","none");
		Log.i(TAG, "UserInforActivity >>>>>>>>>>>>>>>> : " + username);
		phoneEditText = (EditText)findViewById(R.id.user_phone);
		weixinEditText = (EditText)findViewById(R.id.user_weixin);
		qqEditText = (EditText)findViewById(R.id.user_qq);
	    
	   
	}
	
	 public void setuser_infor(View v) {     //�����û���Ϣ
	    	
		 if(!"".equals(phoneEditText.getText().toString()) && !"".equals(weixinEditText.getText().toString()) && !"".equals(qqEditText.getText().toString())){
			// ����û�����
		 		String phone = phoneEditText.getText().toString();
		 		// �������
		 		String weixin = weixinEditText.getText().toString();
		 		//qq
		 		String qq = qqEditText.getText().toString();
		 		Log.i(TAG, "UserInforActivity2222 >>>>>>>>>>>>>>>> : " + username);
		 		if("none".equals(username)){
					 new AlertDialog.Builder(UserInforActivity.this)
						.setIcon(getResources().getDrawable(R.drawable.login_error_icon))
						.setTitle("�����û���Ϣ")
						.setMessage("�绰���룬qq��΢�� ����Ϊ��!")
						.create().show();
		 		}
		 		// ��õ�¼���
		 		String result=setUserInforServer(username,phone,weixin,qq);
		 		if(result!=null&&result.equals("success")){
		 			 
					 new AlertDialog.Builder(UserInforActivity.this)
						.setIcon(getResources().getDrawable(R.drawable.login_error_icon))
						.setTitle("��Ϣ����")
						.setMessage("��Ϣ���óɹ���")
						.create().show();
		 		}else{
					 new AlertDialog.Builder(UserInforActivity.this)
						.setIcon(getResources().getDrawable(R.drawable.login_error_icon))
						.setTitle("�����û���Ϣ")
						.setMessage("����ʧ��")
						.create().show();
		 		}
		 }else{
			 new AlertDialog.Builder(UserInforActivity.this)
				.setIcon(getResources().getDrawable(R.drawable.login_error_icon))
				.setTitle("�����û���Ϣ")
				.setMessage("�绰���룬qq��΢�� ����Ϊ��!")
				.create().show();
		 }
		 
	    	
	}  
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	

	public void userInfor_back(View v){
		Intent lostIntent = new Intent(UserInforActivity.this, HomeActivity.class);
		startActivity(lostIntent);
	}
	
	// �����û����������ѯ
 	private String setUserInforServer(String username, String phone,String weixin, String qq){
 		// ��ѯ����
 		String queryString = "phone="+phone+"&weixin="+weixin+"&qq="+qq+"&username="+username;
 		// url
 		String url = HttpUtil.BASE_URL+"servlet/SetUserInforServlet?"+queryString;
 		
 		// ��ѯ���ؽ��
 		return HttpUtil.queryStringForPost(url);
     }


	
}
