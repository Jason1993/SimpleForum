<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
</head>
<body text="white">
	<form action="register" method="post">
		<table border="0" cellpadding="0" cellspacing="0" align="center" bgcolor="brow" width="800px" >
			<tr>
				<td height="100px" bgcolor="white"></td>
			</tr>
			<tr>
				<td height="100px" ></td>
			</tr>
			<tr>
				<td  height="300px">
					<table align="center">
						<center>用户管理</center>
						<tr>
							<td>用户名: </td>
							<td><input type="text" name="username" ></td>
						</tr>
						<tr>
							<td>密码: </td>
							<td><input type="password" name="password1"></td>
						</tr>
						<tr>
							<td>新密码: </td>
							<td><input type="password" name="password2"></td>
						</tr>
							<tr>
								<td colspan="2" style="text-align: center;">
									<input type="submit" id="submit1" value="提交">									
									<input type="reset" id="reset" value="重置">		
								</td>
							</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td height="100px">	</td>
			</tr>
		</table>
	</form>
</body>
</html>