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

public class IssueTopic extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		doGet(request,response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		String 	s_id  =request.getParameter("s_id");
		String 	s_name  =request.getParameter("s_name");
		
		String titlename=request.getParameter("titlename");
		String content=request.getParameter("content");
		
		User user=(User)request.getSession().getAttribute("user");
		int u_id=user.getId();
		MySQLUtil mysql = new MySQLUtil();
		try {
			String sql1= "insert into topic(t_title,t_s_id,t_u_id,t_contents) values('"+
					titlename+"',"+s_id+","+u_id+",'"+content+"')";
			String sql2="update section set s_number=s_number+1 where s_id="+s_id;
			mysql.jdbcUtil();
			mysql.Execute(sql1);
			mysql.Execute(sql2);
			response.sendRedirect(request.getContextPath()+"/topic?s_id="+s_id+"&s_name="+s_name);
			
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