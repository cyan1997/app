<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.feipin.vo.*"%>
<%@ page import="com.feipin.dao.*"%>
<jsp:useBean id="userVo"  class="com.feipin.vo.User" scope="session"/>
<jsp:useBean id="userDao" class="com.feipin.dao.UserDao" scope="session"/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/table.css" type="text/css"></link>
<link rel="stylesheet" href="../css/main.css" type="text/css"></link>
<style type="text/css">
	a:hover{ text-decoration:underline; color:#075B92;}
	.body{
		text-align:center;
	}
	.buttonBack{
		background: url(../images/skin/83.gif);
		width:67px;
		height:22px;
		border:0px;
		cursor: pointer;
	}
	.input{
		border:1px solid gray;
		height:22px;
	}
</style>
<%
	String key = "";
	if (request.getParameter("bookkey") != null) {
		key = request.getParameter("bookkey");
	} else {
		if (request.getParameter("key") != null) {
			key = request.getParameter("key");
		}
	}

	List<User> user_list = userDao.find_all_user();
%>

</head>
<html>
<body>
<div class="table_top" style="height:100%">
	<div>
		 <table width="100%" class="top" cellpadding="0" cellspacing="0">
			<tr>
				<td class="td_top"><b>当前位置:</b>&nbsp;废品回收助手后台>>查询所有用户信息</td>
				<td align="right">
				&nbsp;&nbsp;
				<a href="user_add.jsp">
					<img src="../images/skin/22.gif"/>&nbsp;&nbsp;新增</a>&nbsp;&nbsp;
				<a href="">
					<img src="../images/skin/11.gif"/>&nbsp;&nbsp;删除</a>&nbsp;&nbsp;&nbsp;&nbsp;
				</td>
			</tr>
		 </table>
	</div>
	<div height="100%" style="margin-top:10px;">
	 <table  border="1" cellpadding="0" cellspacing="1" bgcolor="b5d6e6" >
              <tr class="table_head">
                
                <td height="27" width="30%" align="center">用户名</td>
                <td height="27" width="20%" align="center">密码</td>
                <td height="27" width="30%" align="center">是否会员</td>
                <td width="10%" align="center">删除</td>
                <td width="10%" align="center">设为会员</td>
                
              </tr>
			<%
				String str = (String) request.getParameter("Page");
				if (str == null) {
					str = "0";
				}
				int page_size = 10;
				int recordCount = user_list.size();
				int maxPage = 0;
				maxPage = (recordCount % page_size == 0) ? (recordCount / page_size)
						: (recordCount / page_size + 1);
				int Page = Integer.parseInt(str);
				if (Page < 1) {
					Page = 1;
				} else {
					if (((Page - 1) * page_size + 1) > recordCount) {
						page = maxPage;
					}
				}
				int index = (Page - 1) * page_size + 1;

				if (user_list.size() != 0) {

					String isMemeber=null;

					for (int i = 1; i <= page_size; i++) {
						userVo = (User) user_list.get(index - 1);
				
						if(userVo.getUsertype()==1){
							isMemeber="普通用户";
						}else if(userVo.getUsertype()==2){
							isMemeber="会员";
						}
						
			%>
             <tr style="padding:5px;">
                <td height="24" align="center"><%=userVo.getName() %></td>
                <td height="24" align="center"><%=userVo.getPassword() %></td>
                <td height="24" align="center"><%=isMemeber%></td>
                <td align="center"><a href="user_del.jsp?user_name=<%=userVo.getName()%>"><img src="../images/table/del.gif" width="16" height="16"></a></td>
              	<td align="center"><a href="user_update.jsp?user_name=<%=userVo.getName()%>"><img src="../images/table/modify.gif" width="16" height="16"></a></td>
             
              </tr>
			<%
				if (index >= user_list.size()) {
							break;
						} else {
							index++;
						}

					}
			%>
            </table>
            <table width="100%"  border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td align="right">当前页数：[<%=Page%>/<%=maxPage%>]&nbsp;
						<%
							if (Page > 1) {
						%>
						<a href="user_manage.jsp?Page=1&key=<%=key%>">第一</a>　<a href="user_manage.jsp?Page=<%=Page - 1%>&key=<%=key%>">上一页</a>
                       	<%
                       		}
                       			if (Page < maxPage) {
                       	%>
                       	<a href="user_manage.jsp?Page=<%=Page + 1%>&key=<%=key%>">下一页</a>　<a href="user_manage.jsp?Page=<%=maxPage%>&key=<%=key%>">最后一页&nbsp;</a>
                       	<%
                       		}
                       		}
                       	%>
						</td>
					</tr>
			</table>
		</td>
        </tr>
      </table>
</div>


</body>
</html>
