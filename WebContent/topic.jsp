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
			<a href="<%=request.getContextPath()%>/section">所有版块<%= request.getParameter("s_name")%></a>
		</div>
	</div>
	<br>
	
	<div id="content">
		<div class="box" >
			<div class="box-head">
				<h2 class="left">帖子列表</h2>
				<div class="right">
					<label>搜索版块</label><input type="text" class="field small-field" id="searchVal"/>
					<input type="submit" class="button" value="search" onclick="search()">				
				</div>
			</div>
		</div>
	</div>
	<div class="table table2">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<th>帖子名</th>
				<th>发帖名</th>
				<th>发帖时间</th>
				<th>回帖数</th>
			</tr>
			<c:forEach items="${requestScope.list}" var="topic">
					<tr align="left">
					<td>
					<a href="<%=request.getContextPath()%>/reply?s_name=<%=request.getParameter("s_name") %>
					&t_id=${topic.t_id}&t_title=${topic.t_title }&username=${topic.username}&t_time=${topic.time}">
					${topic.t_title}
					</a>
					</td>
					<td>
					${topic.username}
					</td>
					<td>
					${topic.time}
					</td>
					<td>
					${topic.t_number}
					</td>
					</tr>
			</c:forEach>
		</table>
	</div>
	
	<br>
	<div id="content">
		<div class="box" >
			<div class="box-head">
				<h2 class="left">发表新帖</h2>
			</div>
		</div>
	</div>
	<div class="table table3">
	<form action="issueTopic?s_id=<%=request.getParameter("s_id")%>&s_name=<%=request.getParameter("s_name") %>" method="post">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
		<td align="left">
		帖子名：</td>
		</tr>
		<tr>
		<td>
		<textarea rows="1" style="width:925px" name="titlename"></textarea>
		</td>
		</tr>
		<td colspan="2">
		<textarea rows="12" style="width:925px" name="content"></textarea>
		</td>

		<tr>
		<td colspan="2">
		<input type="submit" value="提交">
		<input type="reset" value="重置">
		</td>
		</tr>
		</table>
	</form>
	</div>	
</div>
<div id="footer">
	<div class="shell">
		<span class="left">&copy;2014</span><span class="right">版本2014V1.0</span>
	</div>
</div>

</body>
</html>