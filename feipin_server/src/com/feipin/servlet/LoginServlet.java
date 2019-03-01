package com.feipin.servlet;

import java.io.IOException;



import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.feipin.dao.UserDao;



import net.sf.json.JSONObject;




/**
 * 
 *
 * 响应 Android客户端发来的请求
 */
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		UserDao dao = new UserDao();
		// 获得客户端请求参数
		String username = request.getParameter("account");
		String password = request.getParameter("password");
		
		System.out.println("！！！！！===============登陆");
	
		boolean  u = dao.login(username, password);
		if(u == true){
			// 响应客户端内容，登录成功
			JSONObject json = JSONObject.fromObject(u);
			System.out.println(json.toString());
			out.println(json.toString());
			
			int type = dao.getUserType(username);
			out.print(String.valueOf(type));
		}else{
			// 响应客户端内容，登录失败
			out.print("0");
		}
		out.flush();
		out.close();
	}
	
	/*
	private String build(User u){
		String userMsg = "";
		userMsg+="id="+u.getId();
		userMsg+=";";
		userMsg+="name="+u.getName();
		return userMsg;
	}*/
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
		System.out.println("！！！===============登陆");
	}
	public void init() throws ServletException {
	}
	
	public LoginServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

}
