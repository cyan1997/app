package com.feipin.activity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.feipin.R;
import com.feipin.model.Liuyan;
import com.feipin.util.HttpUtil;

public class QiandaoListActivity extends Activity {

	private View addview = null;
	private ListView liuyanViewList = null;
	private List<Liuyan> liuyanList = new ArrayList<Liuyan>();
	private List<Map<String, Object>> maplist = new ArrayList<Map<String, Object>>();

	private SimpleAdapter simpleAdapter = null; // 进行数据的转换操作
	// private String classify_id;
	Liuyan sel_commodity;
	private SharedPreferences mSharedPreferences;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.qiandao_manage_list);
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
				.detectDiskReads().detectDiskWrites().detectNetwork()
				.penaltyLog().build());

		StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
				.detectLeakedSqlLiteObjects().penaltyLog().penaltyDeath()
				.build());

		liuyanViewList = (ListView) findViewById(R.id.liuyan_list);

		InitData();

		liuyanViewList.setAdapter(new Myadapter(QiandaoListActivity.this,
				liuyanList));

	};

	/**
	 * 获取ListView的数据
	 * 
	 * @return
	 */
	private void InitData() {
		liuyanList.clear();

		String url = HttpUtil.BASE_URL + "servlet/QiandaoListServlet";
		String result = HttpUtil.queryStringForGet(url);
		try {
			JSONArray tables = new JSONArray(result);
			for (int i = 0; i < tables.length(); i++) {

				JSONObject obj_tmp = tables.getJSONObject(i);
				Liuyan liuyan = new Liuyan();
				liuyan.setId(obj_tmp.getInt("id"));
				liuyan.setContent(obj_tmp.getString("content"));
				liuyan.setUsername(obj_tmp.getString("username"));

				liuyanList.add(liuyan);
			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			Log.e("mobile", "转换数据出错");
		}

	}

	
	
	public void add_liuyan(View v){
		Intent intent  = new Intent(QiandaoListActivity.this, QiandaoActivity.class);
		startActivity(intent) ;
	}
	
	class Myadapter extends BaseAdapter {
		private Context c;
		private List<Liuyan> list;

		public Myadapter(Context c, List<Liuyan> list) {
			this.c = c;
			this.list = list;
		}

		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}

		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return list.get(position);
		}

		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			View v = LayoutInflater.from(c).inflate(R.layout.qiandao_list_item,
					null);

			TextView tv1 = (TextView) v.findViewById(R.id.liuyan_list_content);
			TextView tv2 = (TextView) v.findViewById(R.id.liuyan_list_user);

			tv1.setText(list.get(position).getContent());
			tv2.setText(list.get(position).getUsername());

			return v;
		}

	}
}
