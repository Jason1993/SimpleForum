package cn.com.qst.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.qst.model.User;
import cn.com.qst.util.MySQLUtil;

public class UserServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		doGet(request,response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		String 	u_name  = new String(request.getParameter("username").getBytes("iso-8859-1"));
		String 	u_password  = new String(request.getParameter("password").getBytes("iso-8859-1"));
		MySQLUtil mysql = new MySQLUtil();
		String sql = "select * from users where u_name ='"+u_name+"' and u_password='"+u_password+"' and u_status = 0";
		User user = new User();
		user.setUsername(u_name);
		user.setPassword(u_password);
		
		try {
			mysql.jdbcUtil();
			ResultSet rs=mysql.Query(sql);
			if(rs.next()){
				user.setId(rs.getInt("u_id"));
				request.getSession().setAttribute("user", user);
				response.sendRedirect("userManager");
			}	
			
			else
				response.sendRedirect("login.jsp");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			mysql.close();
		}
		
		
		
	}
}
