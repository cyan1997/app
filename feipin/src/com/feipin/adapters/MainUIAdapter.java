package com.feipin.adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.feipin.R;

public class MainUIAdapter extends BaseAdapter {

	private Context context;
	private LayoutInflater inflater;

	private SharedPreferences dp;

	public MainUIAdapter(Context context) {
		this.context = context;
		inflater = LayoutInflater.from(context);
		dp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
	}

	private static String[] names = { "买卖废品区", "卖废品启示", "收废品启示", "留言板","联系客服","个人信息" };
	private static int[] icons = { R.drawable.t1, R.drawable.t2,
			R.drawable.t3, R.drawable.t4,R.drawable.t5, R.drawable.t6 };

	// get these icon name.length
	public int getCount() {

		return names.length;
	}

	// the icon location
	public Object getItem(int position) {

		return position;
	}

	// this method is get item id
	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		// this method is return every content of item

		View view = inflater.inflate(R.layout.main_grid_item, null);
		ImageView iv_icon = (ImageView) view.findViewById(R.id.image_item);
		TextView tv_name = (TextView) view.findViewById(R.id.text_item);
		iv_icon.setImageResource(icons[position]);
		tv_name.setText(names[position]);
		if (position == 0) {
			String name = dp.getString("lost_name", null);
			if (name != null) {
				tv_name.setText(name);
			}
		}

		return view;
	}

}
