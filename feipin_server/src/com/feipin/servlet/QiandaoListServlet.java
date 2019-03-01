package com.feipin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.feipin.dao.QiandaoDao;
import com.feipin.vo.Qiandao;

/**
 * 响应 Android客户端发来的请求
 */
public class QiandaoListServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("come here :::::::::::::::::::");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		// 转换为字符串
		QiandaoDao tmpDao = new QiandaoDao();
		List<Qiandao> liuyan_list = tmpDao.find_all_liuyan();

		Qiandao liuyan = new Qiandao();
		JSONArray array = new JSONArray();

		for (int i = 0; i < liuyan_list.size(); i++) {
			liuyan = liuyan_list.get(i);

			JSONObject obj = new JSONObject();
			try {

				obj.put("id", String.valueOf(liuyan.getId()));
				obj.put("content", liuyan.getContent());
				obj.put("username", String.valueOf(liuyan.getUsername()));

			} catch (Exception e) {

			}
			array.add(obj);
		}
		// String msg = DBUtil.buildJson(infolist);
		// 返回给客户端
		out.print(array.toString());
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		System.out.println("！！！===============登陆");
	}

	public void init() throws ServletException {
	}

	public QiandaoListServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

}
