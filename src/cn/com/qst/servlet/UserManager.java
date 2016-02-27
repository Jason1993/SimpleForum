package cn.com.qst.servlet;


import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.qst.util.MySQLUtil;

import cn.com.qst.model.User;

public class UserManager extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		doGet(request,response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		MySQLUtil mysql=new MySQLUtil();
		try {
			mysql.jdbcUtil();
			String sql="select * from users";
			List<User> list = new ArrayList();
			ResultSet rs= mysql.Query(sql);
			
			while(rs.next()){
				int id = rs.getInt("u_id");
				int status =rs.getInt("u_status");
				String username=rs.getString("u_name");
				String password = rs.getString("u_password");
				User user = new User();
				user.setId(id);
				user.setPassword(password);
				user.setStatus(status);
				user.setUsername(username);
				list.add(user);
			}
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("main.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

