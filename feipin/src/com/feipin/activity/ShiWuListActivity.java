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
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.feipin.R;
import com.feipin.model.ShiWuInforVo;
import com.feipin.util.HttpUtil;

public class ShiWuListActivity extends Activity {

	private View addview = null;
	private ListView shiwuViewList = null;
	private List<ShiWuInforVo> shiwuList = new ArrayList<ShiWuInforVo>();
	private List<Map<String, Object>> maplist = new ArrayList<Map<String, Object>>();

	private ImageView search_image_view = null;

	private SimpleAdapter simpleAdapter = null; // 进行数据的转换操作
	// private String classify_id;
	ShiWuInforVo sel_commodity;
	private SharedPreferences mSharedPreferences;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shiwu_manage_list);
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
				.detectDiskReads().detectDiskWrites().detectNetwork()
				.penaltyLog().build());

		StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
				.detectLeakedSqlLiteObjects().penaltyLog().penaltyDeath()
				.build());

		shiwuViewList = (ListView) findViewById(R.id.shiwu_list);

		search_image_view = (ImageView) findViewById(R.id.search_btn);
		search_image_view.setOnClickListener(new MySearchListener());

		InitData();

		shiwuViewList.setAdapter(new Myadapter(ShiWuListActivity.this,
				shiwuList));

	};

	/**
	 * 获取ListView的数据
	 * 
	 * @return
	 */
	private void InitData() {
		shiwuList.clear();

		String url = HttpUtil.BASE_URL + "servlet/ShiWuListServlet";
		String result = HttpUtil.queryStringForGet(url);
		try {
			JSONArray tables = new JSONArray(result);
			for (int i = 0; i < tables.length(); i++) {

				JSONObject obj_tmp = tables.getJSONObject(i);
				ShiWuInforVo shiWuInforVo = new ShiWuInforVo();
				shiWuInforVo.setContent(obj_tmp.getString("content"));
				shiWuInforVo.setUsername(obj_tmp.getString("username"));
				shiWuInforVo.setStatus(obj_tmp.getString("status"));
				shiWuInforVo.setPhone(obj_tmp.getString("phone"));
				shiWuInforVo.setDate(obj_tmp.getString("date"));
				shiWuInforVo.setType(obj_tmp.getString("type"));

				shiwuList.add(shiWuInforVo);
			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			Log.e("mobile", "转换数据出错");
		}

	}

	/**
	 * 获取ListView的数据
	 * 
	 * @return
	 */
	class MySearchListener implements OnClickListener {
		public void onClick(View v) {
			shiwuList.clear();
			EditText editText = (EditText) findViewById(R.id.search_edit);
			String key_word_edit = editText.getText().toString() ;
			String url = HttpUtil.BASE_URL + "servlet/SearchShiWuServlet?"
					+ "key=" + key_word_edit;
			String result = HttpUtil.queryStringForGet(url);
			try {
				JSONArray tables = new JSONArray(result);
				for (int i = 0; i < tables.length(); i++) {

					JSONObject obj_tmp = tables.getJSONObject(i);
					ShiWuInforVo shiWuInforVo = new ShiWuInforVo();
					shiWuInforVo.setContent(obj_tmp.getString("content"));
					shiWuInforVo.setUsername(obj_tmp.getString("username"));
					shiWuInforVo.setStatus(obj_tmp.getString("status"));
					shiWuInforVo.setPhone(obj_tmp.getString("phone"));
					shiWuInforVo.setDate(obj_tmp.getString("date"));
					shiWuInforVo.setType(obj_tmp.getString("type"));

					shiwuList.add(shiWuInforVo);
				}

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				Log.e("mobile", "转换数据出错");
			}
			
			shiwuViewList.setAdapter(new Myadapter(ShiWuListActivity.this,
					shiwuList));
		}
	}

	class Myadapter extends BaseAdapter {
		private Context c;
		private List<ShiWuInforVo> list;

		public Myadapter(Context c, List<ShiWuInforVo> list) {
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
			View v = LayoutInflater.from(c).inflate(R.layout.shiwu_list_item,
					null);

			TextView tv1 = (TextView) v.findViewById(R.id.shiwu_list_name);
			TextView tv2 = (TextView) v.findViewById(R.id.shiwu_list_user);
			TextView tv3 = (TextView) v.findViewById(R.id.shiwu_list_phone);
			TextView tv4 = (TextView) v.findViewById(R.id.shiwu_list_status);
			TextView tv5 = (TextView) v.findViewById(R.id.shiwu_list_type);
			TextView tv6 = (TextView) v.findViewById(R.id.shiwu_list_date);
			
			
			tv1.setText(list.get(position).getContent());
			tv2.setText(list.get(position).getUsername());
			tv3.setText(list.get(position).getPhone());
			tv6.setText(list.get(position).getDate()) ;
			if ("0".equals(list.get(position).getStatus())) {
				tv4.setText("未解决");
			} else if ("1".equals(list.get(position).getStatus())) {
				tv4.setText("已解决");
			}
			if ("1".equals(list.get(position).getType())) {
				tv5.setText("卖废品信息");
			} else if ("2".equals(list.get(position).getType())) {
				tv5.setText("收废品信息");
			}
			
			return v;
		}

	}
}
