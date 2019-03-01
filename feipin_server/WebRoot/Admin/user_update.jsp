<%@ page contentType="text/html; charset=gb2312" %>

<jsp:useBean id="userVo"  class="com.feipin.vo.User" scope="session"/>
<jsp:useBean id="userDao" class="com.feipin.dao.UserDao" scope="session"/>


<%
	String user_name = request.getParameter("user_name");
	
	userDao.update_user_type(user_name);

	out.println("<script language='javascript'>alert('…Ë÷√≥…π¶!');window.location.href='user_manage.jsp';</script>");

%>

