package cn.com.qst.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.qst.util.MySQLUtil;



public class RegisterServlet extends HttpServlet {
//	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		String name=new String(request.getParameter("username").getBytes("iso-8859-1"));
		String password1=new String(request.getParameter("password1").getBytes("iso-8859-1"));
		String password2=new String(request.getParameter("password2").getBytes("iso-8859-1"));
		if(name.length()==0 || password1.length()==0 || password2.length()==0)
		{
			response.sendRedirect("register.jsp");
			return ;
		}
		if(password1.equals(password2)){
			MySQLUtil my=new MySQLUtil();
			String str="insert into users(u_name,u_password,u_status) values('"+
					name+"','"+password1+"',0);";
			try {
				my.jdbcUtil();
				if(my.Execute(str))
					response.sendRedirect("../login.jsp");
				else
					response.sendRedirect("register.jsp");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				my.close();
			}
		}
		else{
			response.sendRedirect("register.jsp");
		}
	}
//	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		doGet(request,response);
	}
}
