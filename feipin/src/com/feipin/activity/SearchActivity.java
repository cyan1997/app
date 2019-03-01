package com.feipin.activity;
//package com.hzy.lostandfound.activity;
//
//
//import java.io.InputStream;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import android.annotation.SuppressLint;
//import android.app.Activity;
//import android.app.AlertDialog;
//import android.content.Context;
//import android.content.DialogInterface;
//import android.content.SharedPreferences;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.os.Bundle;
//import android.os.StrictMode;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.widget.AdapterView;
//import android.widget.AdapterView.OnItemClickListener;
//import android.widget.BaseAdapter;
//import android.widget.EditText;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.ListView;
//import android.widget.SimpleAdapter;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.hzy.lostandfound.R;
//import com.hzy.lostandfound.model.Commodity;
//import com.hzy.lostandfound.util.HttpUtil;
//
//public class SearchActivity extends Activity {
//	
//	private View addview = null;
//	private ListView commodityViewList = null;
//	private List<Commodity> commodityList = new ArrayList<Commodity>();
//	private List<Map<String, Object>> maplist = new ArrayList<Map<String, Object>>();
//	
//	private SimpleAdapter simpleAdapter = null; // 进行数据的转换操作
//	private String classify_id;
//	Commodity sel_commodity; 
//	private SharedPreferences mSharedPreferences;
//	EditText key_word_edit;
//	private ImageView search_image_view = null;
//	@SuppressLint("NewApi")
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.sreach);
//		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
//				.detectDiskReads().detectDiskWrites().detectNetwork()
//				.penaltyLog().build());
//
//		StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
//				.detectLeakedSqlLiteObjects().penaltyLog().penaltyDeath()
//				.build());
//		
//	
//		key_word_edit = (EditText)findViewById(R.id.search_edit); 
//		search_image_view = (ImageView)findViewById(R.id.search_btn);
//		search_image_view.setOnClickListener(new MySearchListener());
//		commodityViewList = (ListView) findViewById(R.id.commodity_list);
//		commodityViewList.setOnItemClickListener(new MyListItemListener());
//		
//		
//		
//		commodityViewList.setAdapter(new Myadapter(SearchActivity.this, commodityList));
//	};
//	
//    /**
//     * 获取ListView的数据
//     * @return
//     */
//	class MySearchListener implements OnClickListener { 
//		public void onClick(View v) {
//		commodityList.clear();
//		
//		String url = HttpUtil.BASE_URL +"servlet/SearchCommodityServlet?"
//					+"key="+key_word_edit.getText().toString();
//		String result = HttpUtil.queryStringForGet(url);
//		try {
//			JSONArray tables = new JSONArray(result);
//			for(int i=0;i<tables.length();i++)
//			{
//				
//				JSONObject obj_tmp = tables.getJSONObject(i);
//				Commodity commodity = new Commodity();
//				commodity.setId( obj_tmp.getString("id"));
//				commodity.setName(obj_tmp.getString("name"));
//				commodity.setStock(obj_tmp.getString("stock"));
//				commodity.setPrice(obj_tmp.getString("price"));
//				commodity.setUnit(obj_tmp.getString("unit"));
//				commodity.setPic(obj_tmp.getString("pic"));
//				commodity.setBuy_date(obj_tmp.getString("buy_date"));
//				commodity.setUseful_life(obj_tmp.getString("useful_life"));
//				commodityList.add(commodity);
//				
//				
//			}
//			
//			
//
//		    
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			Log.e("mobile", "转换数据出错");
//		}
//		}
//	}
//	
//	 public final class MyListItemListener implements OnItemClickListener{
//	   		AlertDialog dialog;
//	   		public void onItemClick(AdapterView<?> view, View arg1,
//				final int position, long arg3) {
//	   			
//	   			sel_commodity = commodityList.get(position);
//	   			AlertDialog.Builder builder = new AlertDialog.Builder(SearchActivity.this); 
//	   			builder.setMessage("确定要加入购物车吗?") 
//					.setCancelable(false)
//					.setPositiveButton("是",
//							new DialogInterface.OnClickListener() {
//								public void onClick(DialogInterface dialog,
//										int id) {
//									// MyActivity.this.finish();
//									LayoutInflater mLI = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//									final LinearLayout mLL = (LinearLayout)mLI.inflate(R.layout.buy_number_append, null);
//									final EditText buy_num_edit = (EditText)mLL.findViewById(R.id.buy_num_edit); 
//									
//									new AlertDialog.Builder(SearchActivity.this)
//									.setTitle("输入购买的数量("+sel_commodity.getUnit()+"):")
//									.setView(mLL)
//									.setPositiveButton("确定", new DialogInterface.OnClickListener() {	
//										//为什么是DialogInterface.OnClickListener()，其它的不可以吗
//										
//										public void onClick(DialogInterface dialog, int which) {
//											  
//								            String num = buy_num_edit.getText().toString();  
//								            mSharedPreferences = getSharedPreferences("SharedPreferences", Context.MODE_PRIVATE);
//											String username = mSharedPreferences.getString("login_name", null);
//											
//											
//											
//											String url = HttpUtil.BASE_URL +"servlet/AddOrderServlet?"+"commodity_id="+sel_commodity.getId()
//													+"&num="+num+"&price="+ sel_commodity.getPrice()
//													+"&user_name="+ username;
//											
//											
//											
//											String result = HttpUtil.queryStringForGet(url);
//											
//											Toast.makeText(SearchActivity.this, "已添加至购物车！", 0).show();
//											dialog.dismiss();      //结束对话框。不能直接使用finish()，  finish()直接把整个Activity结束掉。   
//											
//										}
//									})
//									.setNegativeButton("取消", new DialogInterface.OnClickListener() {	
//										public void onClick(DialogInterface dialog, int which) {
//											dialog.dismiss();					
//										}
//									}).show();	
//									
//									
//									
//									
//								}	
//							})
//	   			       .setNegativeButton("否", new DialogInterface.OnClickListener() { 
//	   			           public void onClick(DialogInterface dialog, int id) { 
//	   			                dialog.cancel(); 
//	   			           } 
//	   			       }); 
//	   			AlertDialog alert = builder.create(); 
//	   			alert.show();
//	   			
//	   		}
//	    }
//
//	 private class Myadapter extends BaseAdapter {
//			private Context c;
//			private List<Commodity> list;
//
//			public Myadapter(Context c, List<Commodity> list) {
//				this.c = c;
//				this.list = list;
//			}
//
//			public int getCount() {
//				// TODO Auto-generated method stub
//				return list.size();
//			}
//
//			public Object getItem(int position) {
//				// TODO Auto-generated method stub
//				return list.get(position);
//			}
//
//			public long getItemId(int position) {
//				// TODO Auto-generated method stub
//				return position;
//			}
//
//			public View getView(int position, View convertView, ViewGroup parent) {
//				// TODO Auto-generated method stub
//				View v = LayoutInflater.from(c).inflate(R.layout.commodity_list_item,
//						null);
//
//				ImageView iv = (ImageView) v.findViewById(R.id.commodity_image);
//						
//				TextView tv1 = (TextView) v.findViewById(R.id.commodity_list_name);
//				TextView tv2 = (TextView) v.findViewById(R.id.commodity_list_price);
//				TextView tv3 = (TextView) v.findViewById(R.id.commodity_list_stock);
//				TextView tv4 = (TextView) v.findViewById(R.id.commodity_list_buy_date);
//				TextView tv5 = (TextView) v.findViewById(R.id.commodity_list_usefullife);
//				tv1.setText(list.get(position).getName());
//				tv2.setText(list.get(position).getPrice());
//				tv3.setText(list.get(position).getStock());
//				tv4.setText(list.get(position).getBuy_date());
//				tv5.setText(list.get(position).getUseful_life());
//				
//				if (list.get(position).getPic() != null) {
//					try {
//						URL url = new URL(HttpUtil.BASE_URL
//							+ list.get(position).getPic());
//					// URL url = new URL("http://10.0.2.2:8080/Lvyou/pic/"+pic);
//						HttpURLConnection htc = (HttpURLConnection) url
//							.openConnection();
//						InputStream in = htc.getInputStream();
//						if (in != null) {
//							Bitmap bit = BitmapFactory.decodeStream(in);
//
//							iv.setImageBitmap(bit);
//						}
//					} catch (Exception e) {
//					// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//				
//
//				return v;
//			}
//
//		}
//}
