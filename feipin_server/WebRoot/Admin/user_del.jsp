<%@ page contentType="text/html; charset=gb2312" %>

<jsp:useBean id="userVo"  class="com.feipin.vo.User" scope="session"/>
<jsp:useBean id="userDao" class="com.feipin.dao.UserDao" scope="session"/>


<%
	String user_name = request.getParameter("user_name");
	
	userDao.delete(user_name);

	out.println("<script language='javascript'>alert('ɾ���ɹ�!');window.location.href='user_manage.jsp';</script>");

%>

