<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/main.css" type="text/css"></link>

<style type="text/css">
body {
	text-align: center;
}

.buttonBack {
	background: url(images/skin/83.gif);
	width: 67px;
	height: 22px;
	border: 0px;
	cursor: pointer;
}

input {
	border: 0px solid gray;
	height: 22px;
	border-bottom: 1px solid gray;
}

a:hover {
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
					<td class="td_top"><b>当前位置:</b>&nbsp;<a href="#" target="main">废品回收APP</a>>>客服联系方式</td>
				</tr>
			</table>
		</div>
		<div height="100%" style="margin-top:10px;">
			<fieldset style="width:98%">
				<legend>客服联系方式：</legend>

				<form name="form1" method="post" action="infor_add_first_deal.jsp">


					<table border="0" cellpadding="0" cellspacing="15">
						<tr>
							<td>
								<center><font color="red" size="+3">客服联系方式</font></center>
							</td>
						</tr>
						<tr>
							<td>
								<textarea rows="10" cols="80" name="content"></textarea>
							</td>
						</tr>
						<tr>

							<td align="center"><input type="submit" value="设置"
								class="buttonBack" /> &nbsp;&nbsp;&nbsp;<input type="button"
								value="返  回" onclick="javascript:back()" class="buttonBack" /></td>
						</tr>
					</table>
				</form>
			</fieldset>
		</div>
	</div>
</body>

</html>