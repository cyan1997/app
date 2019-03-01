package com.feipin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.feipin.dao.LiuyanDao;
import com.feipin.dao.ShiWuXinXiDao;
import com.feipin.vo.Liuyan;

/**
 * 留言信息
 * 
 * 响应 Android客户端发来的请求
 */
public class LiuyanServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// 获得客户端请求参数
		String content = request.getParameter("content");
		String username = request.getParameter("username");

		System.out.println("！！！！！===============发布留言信息!");
		Liuyan liuyan = new Liuyan();
		liuyan.setContent(content);
		liuyan.setUsername(username);
		liuyan.setStatus("0");

		LiuyanDao liuyanDao = new LiuyanDao();
		int u = liuyanDao.add(liuyan);
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
		System.out.println("！！！===============发布留言信息成功!");
	}

	public void init() throws ServletException {
	}

	public LiuyanServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

}
