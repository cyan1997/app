<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.Vector"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>

<%@ page import="com.feipin.vo.*"%>
<%@ page import="com.feipin.dao.*"%>
<jsp:useBean id="userVo"  class="com.feipin.vo.User" scope="session"/>
<jsp:useBean id="userDao" class="com.feipin.dao.UserDao" scope="session"/>
<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("user_name");
	String password = request.getParameter("user_password");
	
	userVo.setName(name);
	userVo.setPassword(password);
	userVo.setUsertype(1);
	
	userDao.add(userVo);

	response.sendRedirect("user_manage.jsp");

%>
