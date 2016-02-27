package cn.com.qst.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.com.qst.model.User;
import cn.com.qst.util.MySQLUtil;

public class IssueReply extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		doGet(request,response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		
		String s_name=request.getParameter("s_name");
		String t_id=request.getParameter("t_id");
		String t_title=request.getParameter("t_title");
		String username=request.getParameter("username");
		String time=request.getParameter("t_time");
		
		String r_contents=request.getParameter("content");
		User user=(User)request.getSession().getAttribute("user");
		int u_id=user.getId();
		MySQLUtil mysql = new MySQLUtil();
		try {
			String sql1= "insert into reply(r_u_id,r_t_id,r_contents) values("+
					u_id+","+t_id+",'"+r_contents+"')";
			String sql2="update topic set t_number=t_number+1 where t_id="+t_id;
			mysql.jdbcUtil();
			mysql.Execute(sql1);
			mysql.Execute(sql2);
			response.sendRedirect(request.getContextPath()+"/reply?s_name="+s_name+"&t_id="+t_id
					+"&t_title="+t_title+"&username="+username+"&t_time="+time);
			
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
