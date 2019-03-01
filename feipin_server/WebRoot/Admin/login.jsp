<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
	<head>
		<title>系统管理员登陆</title>
		<link href="../css/skin.css" rel="stylesheet" type="text/css">
	</head>
<body>

<table width="100%" height="200" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td height="42" valign="top">
		<table width="100%" height="42" border="0" cellpadding="0" cellspacing="0" class="login_top_bg">
     	 <tr>
       	 	<td width="1%" height="21">&nbsp;</td>
        	<td height="42">&nbsp;</td>
        	<td width="17%">&nbsp;</td>
      	</tr>
    	</table>
	</td>
  </tr>
  <tr>
    <td valign="top"><table width="100%" height="532" border="0" cellpadding="0" cellspacing="0" class="login_bg">
      <tr>
        <td width="49%" align="right"><table width="91%" height="532" border="0" cellpadding="0" cellspacing="0" class="login_bg2">
            <tr>
              <td height="138" valign="top"><table width="89%" height="427" border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td height="149">&nbsp;</td>
                </tr>
                
                <tr>
                  <td height="198" align="right" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
                    
                    <tr>
                      <td>&nbsp;</td>
                      <td width="30%" height="40"><img src="images/login/icon-demo.gif" width="16" height="16"><a href="http://www.865171.cn" target="_blank" class="left_txt3"> 使用说明</a> </td>
                      <td width="35%"><img src="images/login/icon-login-seaver.gif" width="16" height="16"><a href="http://www.865171.cn" class="left_txt3"> 在线客服</a></td>
                    </tr>
                  </table></td>
                </tr>
              </table></td>
            </tr>
            
        </table></td>
        <td width="1%" >&nbsp;</td>
        <td width="50%" valign="bottom"><table width="100%" height="59" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td width="4%">&nbsp;</td>
            <td width="96%" height="38"><span class="login_txt_bt">登陆系统</span></td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td height="21"><table cellspacing="0" cellpadding="0" width="100%" border="0" height="328">
                <tr>
                  <td height="164" colspan="2" align="middle">
                  
                     <table cellspacing="0" cellpadding="0" width="100%" border="0" height="143">
                      <form name="form1" method="post" action="login_deal.jsp">
                        <tr>
                          <td width="12%">用&nbsp;户&nbsp;名：</td>
                          <td width="88%"><input type="text" name="userName" class="text_input"></td>
                        </tr>
                        <tr>
                          <td>密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
                          <td><input type="password" name="userPassword"  class="text_input">
                              <img src="images/login/luck.gif" width="19" height="18"> </td>
                        </tr>
                        <tr>
                        	 <td>类&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
                        	<td>
                   			<select name="user_type" >
                    			<option value="1" selected="selected">--请选择类别--</option>                  		
                      		    <option value="system">系统管理员</option>
                      		    <option value="normal">普通用户</option>
	                        </select>
                			</td>
                        </tr>
                        <tr>
                          <td>&nbsp;</td>
                          <td align="left">
                          	<input type="submit" name="login_submit" class="btn_bg" value=" 登  陆 ">
							<input type="button" name="register_submit"  class="btn_bg" value=" 注  册 " 
								onClick="window.location.href='register.jsp'">
						  		
						  	
						  	
						  </td>
						  
                        </tr>
                        
                        </form>
                      </table>
                    <br>
                 
                  </td>
                </tr>
                <tr>
                  <td width="433" height="164" align="right" valign="bottom"><img src="../images/login/login-wel.gif" width="242" height="138"></td>
                  <td width="57" align="right" valign="bottom">&nbsp;</td>
                </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="20"><table width="100%" border="0" cellspacing="0" cellpadding="0" class="login-buttom-bg">
      <tr>
        <td align="center"><span class="login-buttom-txt">Copyright &copy; 2009-2010版权所有</span></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>