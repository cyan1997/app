<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>首页左边</title>
<link href="../css/main.css" rel="stylesheet" type="text/css" />
<style>
.style1 { font:12px "宋体"; color:#004C7E;}
a { color:#004C7E; text-decoration:none;}
a:hover{text-decoration:underline;}
body table{font:12px "宋体"; color:#075B92;overflow:hidden;}

</style>

</head>

<body>
<table width="166" height="100%" cellpadding="0" cellspacing="0">
	<tr>
		<td align="center" valign="top" bgcolor="D4ECFC">
			<table width="162" height="100%" cellpadding="0" cellspacing="0">
			  <tr>
			    <td background="../images/index/list_top.gif" height="28"></td>
			  </tr>
			  <tr>
			    <td height="40">
			    <table>
			    	<tr><td>欢迎 <span style="font-weight:bold;">${sessionScope.user.userName}</span> 登录本系统</td></tr>
			    	<tr><td>&nbsp;</td></tr>
			    </table>
				  <p/>
				</td>
			  </tr>
			  <tr>
			   <td height="25" background="../images/index/list_task.jpg" align="center">
				 <span class="style1"><a href="#">废物回收系统</a></span>
			   </td>
			  </tr>
			  <tr>
			   <td align="center" valign="top">
					<table>
				    	<tr><td>&nbsp;</td></tr>
				    	<tr><td><a href="infor_add_first.jsp" target="main">联系我们</a></td></tr>
				    	<tr><td>&nbsp;</td></tr>
			    		<tr><td>&nbsp;</td></tr>
				    	<tr><td><a href="user_manage.jsp" target="main">用户管理</a></td></tr>
			    		<tr><td>&nbsp;</td></tr>
				    
				    	
			    	</table>
			   </td>
			  </tr>
			  
			 
			</table>
		</td>
	</tr>
</table>	
</body>
</html>