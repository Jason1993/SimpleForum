package cn.com.qst.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.qst.model.Section;
import cn.com.qst.model.Topic;
import cn.com.qst.util.MySQLUtil;

public class TopicManager extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		doGet(request,response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		MySQLUtil mysql=new MySQLUtil();
		try {
			mysql.jdbcUtil();
			String s_id=request.getParameter("s_id");
			String sql="select * from topic,users where t_u_id = u_id and t_s_id="+s_id;
			List<Topic> list = new ArrayList();
			ResultSet rs= mysql.Query(sql);
			while(rs.next()){
		/*		int id = rs.getInt("u_id");
				int status =rs.getInt("u_status");
				String username=rs.getString("u_name");
				String password = rs.getString("u_password");*/
				
				int t_id=rs.getInt("t_id");
				int t_s_id=rs.getInt("t_s_id");
				int t_u_id=rs.getInt("t_u_id");
				String title=rs.getString("t_title");
				Timestamp time=rs.getTimestamp("t_time");
				int number=rs.getInt("t_number");
				String username=rs.getString("u_name");
				Topic topic=new Topic();
				topic.setT_id(t_id);
				topic.setT_number(number);
				topic.setT_s_id(t_s_id);
				topic.setT_title(title);
				topic.setT_u_id(t_u_id);
				topic.setTime(time);
				topic.setUsername(username);
				list.add(topic);
			}
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("topic.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}