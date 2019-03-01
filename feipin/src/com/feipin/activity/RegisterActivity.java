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
	
	 public void register_system(View v) {     //�������밴ť
	    	
		 if(register_user_password1_edit.getText().toString().equals(register_user_password2_edit.getText().toString())){
			// ����û�����
		 		String username = register_user_name_edit.getText().toString();
		 		// �������
		 		String pwd = register_user_password1_edit.getText().toString();
		 		
		 		
		 		// ��õ�¼���
		 		String result=regsisterServer(username,pwd);
		 		if(result!=null&&result.equals("success")){
		 			 
		 			 Intent intent = new Intent(RegisterActivity.this,LoginActivity.class); 
		 		     startActivity(intent);
		 		}else{
		 			//saveUserMsg(result);
		 			new AlertDialog.Builder(RegisterActivity.this)
					.setIcon(getResources().getDrawable(R.drawable.login_error_icon))
					.setTitle("ע�����")
					.setMessage("�û����ʺŻ������벻��ע�ᣬ\n��ȷ�Ϻ���ע�ᣡ")
					.create().show();
		 		}
		 }else{
			 new AlertDialog.Builder(RegisterActivity.this)
				.setIcon(getResources().getDrawable(R.drawable.login_error_icon))
				.setTitle("ע�����")
				.setMessage("��������Ӧ��ͬ��\n���������ע�ᣡ")
				.create().show();
		 }
		 
	    	
	}  
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	// �����û����������ѯ
 	private String regsisterServer(String account,String password){
 		// ��ѯ����
 		String queryString = "account="+account+"&password="+password;
 		// url
 		String url = HttpUtil.BASE_URL+"servlet/RegisterServlet?"+queryString;
 		
 		// ��ѯ���ؽ��
 		return HttpUtil.queryStringForPost(url);
     }

}
