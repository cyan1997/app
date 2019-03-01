package com.feipin.adapters;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class JsonArrayAdapter extends ArrayAdapter<JSONObject> {
	int resource;
	Context context;
	int textFieldId;
	String textKey;
	int dropDownResource;
	String[] from;
	int[] to;

	public JsonArrayAdapter(Context context, int resource,
			int textViewResourceId, List objects, String textKey) {
		super(context, resource, textViewResourceId, objects);
		this.resource = dropDownResource = resource;
		this.context = context;
		this.textFieldId = textViewResourceId;
		this.textKey = textKey;
	}

	public JsonArrayAdapter(Context context, int resource, List objects,
			String[] from, int[] to) {
		super(context, resource, 0, objects);
		this.resource = dropDownResource = resource;
		this.context = context;
		this.from = from;
		this.to = to;
	}

	@Override
	public void setDropDownViewResource(int resource) {
		this.dropDownResource = resource;
	}

	@Override
	public View getDropDownView(int position, View convertView, ViewGroup parent) {
		return createViewFromRes(position, convertView, parent,
				dropDownResource);
	}

	private View createViewFromRes(int position, View convertView,
			ViewGroup parent, int resource) {
		JSONObject obj = getItem(position);
		View itemView;
		TextView text = null;
		if (convertView == null) {

			LayoutInflater vi = (LayoutInflater) getContext().getSystemService(
					Context.LAYOUT_INFLATER_SERVICE);
			itemView = vi.inflate(resource, parent, false);
		} else {
			itemView = convertView;
		}
		try {
			if (textFieldId == 0) {
				if (itemView instanceof TextView) {
					text = (TextView) itemView;
				} else {
					if (to != null && to.length > 0) {
						for (int i = 0; i < to.length; i++) {
							TextView itemtext = (TextView) itemView
									.findViewById(to[i]);
							itemtext.setText(obj.getString(from[i]));
						}
					}
				}

			} else {
				text = (TextView) itemView.findViewById(textFieldId);

			}
			if (text != null) {
				text
						.setText(obj.getString(textKey == null ? from[0]
								: textKey));
			}
		} catch (ClassCastException e) {
			Log.e("amaker", "布局中的元素不是TextView类型");
		} catch (JSONException e) {
			Log.e("amaker", "从Json中读取数据出错,textKey：" + textKey, e);
		}

		return itemView;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		return createViewFromRes(position, convertView, parent, resource);

	}

}
