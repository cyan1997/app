<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/main.css" type="text/css"></link>

<style type="text/css">
	body{
		text-align:center;
	}
	.buttonBack{
		background: url(images/skin/83.gif);
		width:67px;
		height:22px;
		border:0px;
		cursor: pointer;
	}
	input{
		border:0px solid gray;
		height:22px;
		border-bottom:1px solid gray;
	}
	a:hover{
	text-decoration: underline;
	}
</style>
<script type="text/javascript" src="js/common.js"></script>
</head>
<body>
              
<div class="table_top" style="height:100%">
	<div>
		 <table width="100%" class="top" cellpadding="0" cellspacing="0">
			<tr>
				<td class="td_top"><b>当前位置:</b>&nbsp;<a href="dept!doShowAll.action" target="main">超市管理</a>>>添加一级分类信息</td>
			</tr>
		 </table>
	</div>
	<div height="100%" style="margin-top:10px;">
		<fieldset style="width:98%">
			<legend>填写分类详情如下：</legend>
			
	<form name="form1" method="post" action="classify_add_first_deal.jsp">
			

		<table border="0" cellpadding="0" cellspacing="15">
            <tr>
      	 分类名称：</td>
                <td>
                   <input type="text" name="classify_name" /></td>
                
            </tr>
              
            
         
            <tr>
               
               
               
                <td align="center">
                 	<input type="submit" value="添加" class="buttonBack"/>
                 	&nbsp;&nbsp;&nbsp;<input type="button" value="返  回" onclick="javascript:back()" class="buttonBack"/>
                </td>
            </tr>
        </table>
        </form>
	</fieldset>
</div>
</div>
</body>

</html>