<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
<title>用户登陆</title>
<script type="text/javascript">
	function register(){
		window.location.href="<%=request.getContextPath()%>/user/register.jsp";
	}

</script>
</head>
<body>
<form action="userServlet" method="post" id="myform" name="myform">
	<table border="0" cellpadding="0" cellspacing="0" align="center">
		<tr>
			<td><input type="hidden" name="method" value="login"></td>
		</tr>
		
		<tr>
			<td background="images/login_04.gif" width="862px;" height="266px"></td>
		</tr>
		<tr>
			<td>
				<table  border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td background="images/login_06.gif" width="424px;" height="95px"></td>
						<td background="images/login_07.gif" width="183px;" height="95px">
							<table>
								<tr height="30px;">
									<td>用户</td>
									<td><input type="text" id="username" name="username" style="width: 130px"></td>
								</tr>
								<tr height="30px;">
									<td>密码</td>
									<td><input type="password" id="password" name="password" style="width: 130px"></td>
								</tr>
								<tr>
									<td colspan="2" style="text-align: center;">
										<input type="submit" id="submit1" value="登陆">									
										<input type="button" id="reg" value="注册" onclick="register()">		
									</td>
								</tr>
							</table>
						</td>
						<td background="images/login_08.gif" width="255px" height="95px;"></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
		<td background="images/login_09.gif" height="247px;" width="862px;"></td>
		</tr>
	</table>


</form>
</body>
</html>