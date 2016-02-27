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
	function search(){
		var searchVal=document.getElementById("searchVal").value;
		window.location.href="<%=request.getContextPath()%>/search?searchVal="+searchVal;
	}
</script>
<body>
<div id="header">
	<div class="shell">
		
	<div id="top">
		<h1>BBS论坛</h1>
		<div id="top-navigation">
		欢迎<a href="#"><strong>${sessionScope.user.username}</strong></a>
		<span>|</span>
		<a href="<%=request.getContextPath()%>/login.jsp">退出</a>
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
			<a href="<%=request.getContextPath()%>/userManager">用户管理</a>
		</div>
	</div>
	<br>
	
	<div id="content">
		<div class="box" >
			<div class="box-head">
				<h2 class="left">用户列表</h2>
				<div class="right">
					<label>搜索</label><input type="text" class="field small-field" id="searchVal"/>
					<input type="submit" class="button" value="search" onclick="search()">				
				</div>
			</div>
		
		</div>
		<!-- table -->
		<div class="table">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
				<th>用户id</th>
				<th>用户名</th>
				<th>状态</th>
				<th>操作</th>
				</tr>
				
				<c:forEach items="${requestScope.list}" var="user">
			
					<tr align="left">
					<td>
					${user.id}
					</td>
					<td>
					${user.username}
					</td>
					<td>
					${user.status}
					</td>
					<td>
					<a href="<%=request.getContextPath()%>/update.jsp?id=${user.id}&username=${user.username}&password=${user.password}" >修改</a><a href="<%=request.getContextPath()%>/delete?id=${user.id}" onclick="return confirm1()">删除</a>
					</td>
					</tr>
			
				</c:forEach>
			</table>
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