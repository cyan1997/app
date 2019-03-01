package com.feipin.activity;
/**
 * �����շ�Ʒ��Ϣ
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
	
	 public void fabuShiWuInfor(View v) {     //�����շ�Ʒ��Ϣ
	    	
		 if(!"".equals(faubuContentEditText.getText().toString())){
			    // ��÷�������
		 		String fabuContent = faubuContentEditText.getText().toString();

		 		Log.i(TAG, "ShiWuXinXi2Activity >>>>>>>>>>>>>>>> : " + fabuContent);
		 		String fabuDateString = "" +date.getYear() +"-" +date.getMonth() + "-" + date.getDayOfMonth() ;
		 		// ��÷������
		 		String result= fabuShiWuContent(username,fabuContent,fabuDateString);
		 		if(result!=null&&result.equals("success")){
		 			 
					 new AlertDialog.Builder(ShiWuXinXi2Activity.this)
						.setIcon(getResources().getDrawable(R.drawable.login_error_icon))
						.setTitle("�շ�Ʒ��Ϣ����")
						.setMessage("�շ�Ʒ��Ϣ�����ɹ���")
						.create().show();
		 		}else{
					 new AlertDialog.Builder(ShiWuXinXi2Activity.this)
						.setIcon(getResources().getDrawable(R.drawable.login_error_icon))
						.setTitle("�շ�Ʒ��Ϣ����")
						.setMessage("�շ�Ʒ��Ϣ����ʰ�ܣ�")
						.create().show();
		 		}
		 }else{
			 new AlertDialog.Builder(ShiWuXinXi2Activity.this)
				.setIcon(getResources().getDrawable(R.drawable.login_error_icon))
				.setTitle("�շ�Ʒ��Ϣ����")
				.setMessage("�շ�Ʒ��Ϣ����Ϊ��!")
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
	
	// �����շ�Ʒ��Ϣ����
 	private String fabuShiWuContent(String username, String content,String time){
 		// ��ѯ����
 		String queryString = "type=2&content="+content+"&time="+time+"&username="+username;
 		// url
 		String url = HttpUtil.BASE_URL+"servlet/ShiWuInfoServlet?"+queryString;
 		Log.i(TAG, "fabuShiwucontent >>>>>> : " + url) ;
 		// ��ѯ���ؽ��
 		return HttpUtil.queryStringForPost(url);
     }


	
}
