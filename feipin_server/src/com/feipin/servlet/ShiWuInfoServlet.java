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
 * ����ʧ����Ϣ
 * 
 * ��Ӧ Android�ͻ��˷���������
 */
public class ShiWuInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// ��ÿͻ����������
		String username = request.getParameter("username");
		String content = request.getParameter("content");
		String time = request.getParameter("time");
		String type = request.getParameter("type");
		
		System.out.println("����������===============����ʧ����Ϣ!");
		ShiWuXinXi shiwuxinxiModel = new ShiWuXinXi() ;
		shiwuxinxiModel.setContent(content);
		shiwuxinxiModel.setDate(time);
		shiwuxinxiModel.setUsername(username);
		shiwuxinxiModel.setType(type);
		shiwuxinxiModel.setStatus("0");
		
		ShiWuXinXiDao shiwuDao = new ShiWuXinXiDao();
		int u = shiwuDao.add(shiwuxinxiModel);
		if (u == 1) {
			// ��Ӧ�ͻ������ݣ��ɹ�
			// JSONObject json = JSONObject.fromObject(u);
			// System.out.println(json.toString());
			// out.println(json.toString());
			out.print("success");
		} else {
			// ��Ӧ�ͻ������ݣ���¼ʧ��
			out.print("0");
		}
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		System.out.println("������===============����ʧ����Ϣ�ɹ�!");
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
