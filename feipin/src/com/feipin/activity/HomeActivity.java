package com.feipin.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.feipin.R;
import com.feipin.adapters.MainUIAdapter;


/**
 * 
 * @author 
 *
 */
public class HomeActivity extends Activity implements OnItemClickListener{
	private static final String TAG = "MainActivity";
	private GridView gv_main;
	private MainUIAdapter adapter;
	Intent lostIntent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		setContentView(R.layout.main_index);
	
		gv_main = (GridView) findViewById(R.id.gv_main);
		adapter = new MainUIAdapter(this);
		gv_main.setAdapter(adapter);
		gv_main.setOnItemClickListener(this);
		
	}


	public void onItemClick(AdapterView<?> parent, View view, int position,long id) 
	{
		// TODO Auto-generated method stub
		Log.i(TAG, "click position" + position);
		switch (position) {
		/**
		 */
		case 0:
			
			//active the lostprotectedActivity
			lostIntent = new Intent(HomeActivity.this, ShiWuListActivity.class);
			startActivity(lostIntent);
			break;
		case 1:
			lostIntent = new Intent(HomeActivity.this, ShiWuXinXiActivity.class);
			startActivity(lostIntent);
			break;
		case 2:
			Log.i(TAG, "the security assistant can working  ShiWuXinXi2Activity ");
			
			lostIntent = new Intent(HomeActivity.this, ShiWuXinXi2Activity.class);
			startActivity(lostIntent);
			break;
		case 3:
			lostIntent = new Intent(HomeActivity.this, LiuyanListActivity.class);
			startActivity(lostIntent);
			break;
		case 4:
			lostIntent = new Intent(HomeActivity.this, InforActivity.class);
			startActivity(lostIntent);
			break;
		case 5:
			lostIntent = new Intent(HomeActivity.this, UserInforActivity.class);
			startActivity(lostIntent);
			break;
		case 6:
			
			break;
		}
	}

	
}
