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
 * ������Ϣ
 * 
 * ��Ӧ Android�ͻ��˷���������
 */
public class QiandaoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// ��ÿͻ����������
//		String content = request.getParameter("content");
		String username = request.getParameter("username");

		System.out.println("����������===============ǩ����Ϣ!");
		Qiandao liuyan = new Qiandao();
 		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd H:m:s");
	    // ǩ��ʱ��
 		String fabuContent = format.format(new Date());
		liuyan.setContent(fabuContent);
		liuyan.setUsername(username);
		liuyan.setStatus("0");

		QiandaoDao liuyanDao = new QiandaoDao();
		int u = liuyanDao.add(liuyan);
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
		System.out.println("������===============ǩ����Ϣ�ɹ�!");
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