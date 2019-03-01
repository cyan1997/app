package com.feipin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.feipin.dao.LiuyanDao;
import com.feipin.dao.QiandaoDao;
import com.feipin.vo.Qiandao;

/**
 * 留言信息
 * 
 * 响应 Android客户端发来的请求
 */
public class QiandaoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// 获得客户端请求参数
//		String content = request.getParameter("content");
		String username = request.getParameter("username");

		System.out.println("！！！！！===============签到信息!");
		Qiandao liuyan = new Qiandao();
 		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd H:m:s");
	    // 签到时间
 		String fabuContent = format.format(new Date());
		liuyan.setContent(fabuContent);
		liuyan.setUsername(username);
		liuyan.setStatus("0");

		QiandaoDao liuyanDao = new QiandaoDao();
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
		System.out.println("！！！===============签到信息成功!");
	}

	public void init() throws ServletException {
	}

	public QiandaoServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

}
