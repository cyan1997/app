package com.feipin.activity;



import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.feipin.R;
import com.feipin.util.HttpUtil;

public class RegisterActivity extends Activity {
	EditText register_user_name_edit;
    EditText register_user_password1_edit;
    EditText register_user_password2_edit;
    private Spinner spinner;
	private ArrayAdapter<String> adapter;
	private String[] loginTypeStr = null;
	private String selLoginType;
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
		.detectDiskReads().detectDiskWrites().detectNetwork()
		.penaltyLog().build());

		StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
		.detectLeakedSqlLiteObjects().penaltyLog().penaltyDeath()
		.build());
		
		register_user_name_edit = (EditText)findViewById(R.id.register_username);
	    register_user_password1_edit = (EditText)findViewById(R.id.register_password1);
	    register_user_password2_edit = (EditText)findViewById(R.id.register_password2);
	    
	   
	}
	
	 public void register_system(View v) {     //忘记密码按钮
	    	
		 if(register_user_password1_edit.getText().toString().equals(register_user_password2_edit.getText().toString())){
			// 获得用户名称
		 		String username = register_user_name_edit.getText().toString();
		 		// 获得密码
		 		String pwd = register_user_password1_edit.getText().toString();
		 		
		 		
		 		// 获得登录结果
		 		String result=regsisterServer(username,pwd);
		 		if(result!=null&&result.equals("success")){
		 			 
		 			 Intent intent = new Intent(RegisterActivity.this,LoginActivity.class); 
		 		     startActivity(intent);
		 		}else{
		 			//saveUserMsg(result);
		 			new AlertDialog.Builder(RegisterActivity.this)
					.setIcon(getResources().getDrawable(R.drawable.login_error_icon))
					.setTitle("注册错误")
					.setMessage("用户名帐号或者密码不能注册，\n请确认后再注册！")
					.create().show();
		 		}
		 }else{
			 new AlertDialog.Builder(RegisterActivity.this)
				.setIcon(getResources().getDrawable(R.drawable.login_error_icon))
				.setTitle("注册错误")
				.setMessage("两次密码应相同，\n请输入后再注册！")
				.create().show();
		 }
		 
	    	
	}  
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	// 根据用户名称密码查询
 	private String regsisterServer(String account,String password){
 		// 查询参数
 		String queryString = "account="+account+"&password="+password;
 		// url
 		String url = HttpUtil.BASE_URL+"servlet/RegisterServlet?"+queryString;
 		
 		// 查询返回结果
 		return HttpUtil.queryStringForPost(url);
     }

}
