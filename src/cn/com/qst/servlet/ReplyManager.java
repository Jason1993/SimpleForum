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

import cn.com.qst.model.Reply;
import cn.com.qst.model.Topic;
import cn.com.qst.model.User;
import cn.com.qst.util.MySQLUtil;

public class ReplyManager extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		doGet(request,response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		
		String t_id=request.getParameter("t_id");
		String t_title=request.getParameter("t_title");
		String username=request.getParameter("username");//版主
		String t_time=request.getParameter("t_time");
		
	
		int u_id ;
		//当前路径
		User user=(User)request.getSession().getAttribute("user");
		u_id=user.getId();
		
		MySQLUtil mysql=new MySQLUtil();
		try {
			mysql.jdbcUtil();
			
			String sql1="select t_contents from topic where t_id="+t_id;
			ResultSet rs=mysql.Query(sql1);
			if(rs.next())
				request.setAttribute("content",rs.getString("t_contents"));
		
			String sql2="select r_contents,r_time,u_name from reply,users where r_t_id="+
					t_id+" and r_u_id=u_id";
			rs=mysql.Query(sql2);
			
			List<Reply> list = new ArrayList();
			while(rs.next()){
		/*		int id = rs.getInt("u_id");
				int status =rs.getInt("u_status");
				String username=rs.getString("u_name");
				String password = rs.getString("u_password");*/
				
				String r_contents=rs.getString("r_contents");
				Timestamp time=rs.getTimestamp("r_time");
				String u_name=rs.getString("u_name");
				
				Reply rp=new Reply();
				rp.setR_contents(r_contents);
				rp.setTime(time);
				rp.setU_name(u_name);
			
				list.add(rp);
			}
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("reply.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
