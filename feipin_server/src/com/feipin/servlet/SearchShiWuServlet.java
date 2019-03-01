package com.feipin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.feipin.dao.ShiWuXinXiDao;
import com.feipin.vo.ShiWuXinXi;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 
 *
 * 响应 Android客户端发来的请求
 */
public class SearchShiWuServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String key = request.getParameter("key");
		System.out.println("come here :::::::::::::::::::");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		// 转换为字符串
		ShiWuXinXiDao tmpDao = new ShiWuXinXiDao();
		List<ShiWuXinXi> shiwu_list = tmpDao.search_all_shiwuxinxi(key);
		
		ShiWuXinXi shiwu = new ShiWuXinXi();
		// 转换为字符串
		JSONArray array = new JSONArray();
		
		for(int i = 0; i < shiwu_list.size(); i++){
			shiwu = shiwu_list.get(i);

			JSONObject obj = new JSONObject();
			try{
			
				obj.put("id", String.valueOf(shiwu.getId()));
				obj.put("content", shiwu.getContent());
				obj.put("username", String.valueOf(shiwu.getUsername()));
				obj.put("status", String.valueOf(shiwu.getStatus()));
				obj.put("phone", shiwu.getPhone());
				obj.put("date", String.valueOf(shiwu.getDate()));
				obj.put("type", shiwu.getType());
				
			}catch(Exception e){
				
			}
			array.add(obj);
		}
		//String msg = DBUtil.buildJson(infolist);
		// 返回给客户端
		out.print(array.toString());
		out.flush();
		out.close();

	}
	
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
		System.out.println("！！！===============登陆");
	}
	public void init() throws ServletException {
	}
	
	public SearchShiWuServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

}
