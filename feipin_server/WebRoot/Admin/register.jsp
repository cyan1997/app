<%@ page pageEncoding="gb2312"%>
<%@ page contentType="text/html; charset=gb2312" %>
<% request.setCharacterEncoding("gb2312"); %>
<%@ page language="java" %>

<html>
<head>
	<title>管理员-注册</title>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<link href="../css/style.css" rel="stylesheet">
	<script src="JS/check.jsp"></script>
</head>

<body>
	<table align=center width="60%" height=200 border="0" cellspacing="2" cellpadding="0" background="Images/bg.gif">
		<tr align=center>
			&nbsp;
			&nbsp;
			<td height=15 width=100% colspan=4  bgcolor="#2299ff">
				<font color="#ffffff" size="2">新用户注册</font>
			</td>
		</tr>
    	<form name="myform" method="POST" action="register_deal.jsp">
    	<tr>
    		&nbsp;
			&nbsp;
			&nbsp;
			&nbsp;
			&nbsp;
			&nbsp;
		</tr>
    	<tr>
    		<script language="javascript">
				function openwin(UID){
					if (UID==""){
					alert("请输入用户名!");
					myform.UserName.focus();
					return;
					}
					var str="checkUserName.jsp?username="+UID;
					window.showModalDialog(str,"","dialogWidth=300px;dialogHeight=150px;status=no;help=no;scrollbars=no");
				}
						
		
			</script>
			
			<td width="40%" height="30" align="right">用户名：</td>
			<td width="70%" colspan=2><input name="username" type="text" maxlength="20">
			<font size=2 color=red>*</font>
			[<a href="#" onClick="openwin(myform.UserName.value)">检测用户名</a>] 用户名的长度为1-20</td>
		</tr>	
		
		<tr>
			<td align="right">密码：</td>
			<td colspan=2><input name="password" type="password" maxlength="20">
			<font size=2 color=red>*</font> 密码的长度为1-20</td>
		</tr>
		<tr>
			<td align="right">确认密码：</td>
			<td colspan=2><input name="confpassword" type="password" maxlength="20">
			<font size=2 color=red>*</font></td>
		</tr>
		
		<tr>
			<td height="34">&nbsp;</td>
        	<td class="word_grey"> 
        	<input  type="submit" class="btn_grey" value="提交"  >
            <input  type="reset" 	class="btn_grey" value="重新填写">
            <input  type="button" class="btn_grey" value="返回" onClick="window.location.href='login.jsp'"> </td>
         </tr>
		
		</form>
	</table>
</body>
</html>

































