<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>用户管理</title>
<link type="text/css" href="css/stylemain.css" rel="stylesheet"/>
</head>

<script type="text/javascript">
	function confirm1(){
			if(window.confirm("确定删除?"))
				return true;
			return false;
	}
</script>
<% 
	session.setAttribute("id", request.getParameter("id"));
	String username=request.getParameter("username");
	String password=request.getParameter("password");
%>
<body>
<div id="header">
	<div class="shell">
		
	<div id="top">
		<h1>BBS论坛</h1>
		<div id="top-navigation">
		欢迎<a href="#"><strong>${sessionScope.user.username}</strong></a>
		<span>|</span>
		<a href="#">退出</a>
		</div>
	</div>
	<!-- 导航 -->
	<div id="navigation">
		<ul>
			<li>
				<a href="<%=request.getContextPath()%>/userManager"><span>用户管理</span></a>
			</li>
			<li>
			<a href="<%=request.getContextPath()%>/section"><span>论坛</span></a>
			</li>
			<li>
			<a href="help.jsp"><span>帮助</span></a>
			</li>		
		</ul>
	</div>
	</div>
</div>

<div class="shell">
	<div id="container">
		<div class="small-nav">
			<a href="#">用户管理 >用户修改</a>
		</div>
	</div>
	<br>
	
	<div id="content">
		<div class="box" >
			<div class="box-head">
				<h2 class="left">用户修改</h2>
			</div>
		
		
		<!-- table -->
		<div class="table table2">
		<form action="update" method="post" id="myform" name="myform">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">	
			<tr>
			<td align="right" width="50%">用户：</td>
			<td align="left"><input type="text" id="username" name="username" value="<%=username %>"/></td>
			</tr>
			<tr>
			<td align="right">密码：</td>
			<td align="left"><input type="password" id="password1" name="password1" value="<%=password %>"/></td>
			</tr>
			<tr align="center">
			<td align="right">确认密码：</td>
			<td align="left"><input type="password" id="password2" name="password2" value="<%=password %>"/></td>
			</tr>
			<tr align="center">
			<td colspan="2">
			<input type="submit" id="submit1" value="提交" >									
			<input type="reset"  value="重置" >	
			</td>
			</tr>
			</table>
		</form>
		</div>
	</div>
	</div>

</div>
<div id="footer">
	<div class="shell">
		<span class="left">&copy;2014</span><span class="right">版本2014V1.0</span>
	</div>
</div>

</body>
</html>