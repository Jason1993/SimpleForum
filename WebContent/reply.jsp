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
			<a href="<%=request.getContextPath()%>/section">所有版块<%= request.getParameter("s_name") %><%=request.getParameter("t_title")%></a>
		</div>
	</div>
	<br>
	
	<div id="content">
		<div class="box" >
			<div class="box-head">
				<h2 class="left">回帖显示</h2>
				<div class="right">
					<label>搜索版块</label><input type="text" class="field small-field" id="searchVal"/>
					<input type="submit" class="button" value="search" onclick="search()">				
				</div>
			</div>
			<div class="table table2">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td align="left">
					楼主：<%=request.getParameter("username") %>
					</td>
					<td></td>
					<td align="right">
					<%=request.getParameter("t_time") %>
					</td>
				</tr>
				<tr>
					<td colspan="3"><%=request.getAttribute("content") %>
				<tr>
				<c:forEach items="${requestScope.list}" var="reply">
					<tr>
					<td>
					${reply.r_contents}
					</td>
					<td>
					${reply.u_name}
					</td>
					<td>
					${reply.time}
					</td>
					</tr>
				</c:forEach>
				</table>
			</div>
		</div>
	</div>
	
	<div id="content">
		<div class="box" >
			<div class="box-head">
				<h2 class="left">回复</h2>
			</div>
		</div>
	</div>
	<div class="table table3">
	<form action="issueReply?s_name=<%=request.getParameter("s_name") %>&t_id=<%=request.getParameter("t_id")%>&t_title=<%=request.getParameter("t_title") %>&username=
					<%=request.getParameter("username")%>&t_time=<%=request.getParameter("t_time")%>" method="post">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
		<td colspan="3">
		<textarea rows="12" style="width:925px" name="content"></textarea>
		</td>
		</tr>
		<tr>
		<td colspan="3">
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