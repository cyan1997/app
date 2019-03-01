package com.feipin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.feipin.dao.ShiWuXinXiDao;
import com.feipin.dao.UserDao;
import com.feipin.vo.ShiWuXinXi;

/**
 * 发布失物信息
 * 
 * 响应 Android客户端发来的请求
 */
public class ShiWuInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// 获得客户端请求参数
		String username = request.getParameter("username");
		String content = request.getParameter("content");
		String time = request.getParameter("time");
		String type = request.getParameter("type");
		
		System.out.println("！！！！！===============发布失物信息!");
		ShiWuXinXi shiwuxinxiModel = new ShiWuXinXi() ;
		shiwuxinxiModel.setContent(content);
		shiwuxinxiModel.setDate(time);
		shiwuxinxiModel.setUsername(username);
		shiwuxinxiModel.setType(type);
		shiwuxinxiModel.setStatus("0");
		
		ShiWuXinXiDao shiwuDao = new ShiWuXinXiDao();
		int u = shiwuDao.add(shiwuxinxiModel);
		if (u == 1) {
			// 响应客户端内容，成功
			// JSONObject json = JSONObject.fromObject(u);
			// System.out.println(json.toString());
			// out.println(json.toString());
			out.print("success");
		} else {
			// 响应客户端内容，登录失败
			out.print("0");
		}
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		System.out.println("！！！===============发布失物信息成功!");
	}

	public void init() throws ServletException {
	}

	public ShiWuInfoServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

}
