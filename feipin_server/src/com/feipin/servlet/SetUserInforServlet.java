package com.feipin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.feipin.dao.UserDao;

/**
 * 
 *
 * 响应 Android客户端发来的请求
 */
public class SetUserInforServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String user_name = request.getParameter("username");
		String phone = request.getParameter("phone");
		String weixin = request.getParameter("weixin");
		String qq = request.getParameter("qq");
		
		System.out.println(" SetUserInforServlet  come here :::::::::::::::::::");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		// 转换为字符串
		UserDao tmpDao = new UserDao();
		int result = tmpDao.update_user_infor(user_name,phone,weixin,qq) ;
		if(result >= 1){
			out.print("success");
		}else{
			out.print("0");
		}
		out.flush();
		out.close();

		
		
		
		
		
		
//		List<UserOrder> tmp_list = tmpDao.find_order_by_user_name(user_name);
//		UserOrder userOrder = new UserOrder();
//		JSONArray array = new JSONArray();
//		CommodityDao commodityDao = new CommodityDao();
//		Commodity commodity = new Commodity();
//		for(int i = 0; i < tmp_list.size(); i++){
//			userOrder = tmp_list.get(i);
//
//			JSONObject obj = new JSONObject();
//			try{
//			
//				obj.put("id", String.valueOf(userOrder.getId()));
//				commodity = commodityDao.find_by_commodity_id(userOrder.getCommodity_id());
//				obj.put("commodity_id", String.valueOf(userOrder.getCommodity_id()));
//				obj.put("name", commodity.getName());
//				obj.put("buy_num", String.valueOf(userOrder.getBuy_num()));
//				obj.put("price", String.valueOf(userOrder.getPrice()));
//				obj.put("buy_date", userOrder.getBuy_date());
//			
//				System.out.println(commodity.getName());
//			}catch(Exception e){
//				
//			}
//			array.add(obj);
//		}
//		//String msg = DBUtil.buildJson(infolist);
//		// 返回给客户端
//		out.print(array.toString());
//		out.flush();
//		out.close();
	}
	
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
		System.out.println("！！！===============登陆");
	}
	public void init() throws ServletException {
	}
	
	public SetUserInforServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

}
