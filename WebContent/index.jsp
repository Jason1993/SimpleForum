
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head > 
<title>首页-用户管理</title>
<link href="css/index.css" rel="stylesheet" type="text/css" />
</head>


<body>
	<div class="header">
		<h1>BBS论坛</h1>
		<div class="text-r">
			<div class="text-main">
				<a>欢迎</a><a href="#">admin</a><span>|</span><a href="#">退出</a>
			</div>
		</div>
	</div>
	<div class="main-wrap">
		<div class="main-tab">
			<span class="current">用户管理</span><span><a href="bbs.jsp">论坛</a></span><span><a href="help.jsp">帮助</a></span> 
		</div>
		<div class="main-index main-index-b">
			<div class="main-table aaa">
				<div class="main-table-title"><a href="#">用户管理</a></div>
				<div class="main-table-list">
					<ul>
						<li class="first">
							<a>用户列表</a>
							<div class="first-search">
								搜索<input type="text" /><input type="submit" value="search" />
							</div>
						</li>
						<li class="li-table">
							<table border="0" frame="void" cellpadding="0" cellspacing="0">
							  <tr>
								<th>用户ID</th>
						        <th>用户名</th>
						        <th>状态</th>
						        <th>操作</th>
					          </tr>
						     
						    </table> 
						</li>
						
					</ul>
				</div>
			</div>
		    <div class="main-table-forum"></div>
	  	</div>
	</div>
	
	<div class="footer">
		<a class="text-l">Copyright 2014</a>
		<a class="text-r">版本2014V2.0</a>
	</div>
</body>

</html>