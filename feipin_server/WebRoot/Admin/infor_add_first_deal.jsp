<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.feipin.vo.*"%>
<%@ page import="com.feipin.dao.*"%>
<jsp:useBean id="inforVo"  class="com.feipin.vo.Infor" scope="session"/>
<jsp:useBean id="inforDao" class="com.feipin.dao.InforDao" scope="session"/>
<%
	request.setCharacterEncoding("UTF-8");
	String content = request.getParameter("content");
	inforVo.setContent(content);

	inforDao.add(inforVo);
	response.sendRedirect("infor_add_first.jsp");

%>
