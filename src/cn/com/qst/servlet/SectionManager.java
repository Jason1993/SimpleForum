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

import cn.com.qst.model.Section;
import cn.com.qst.model.User;
import cn.com.qst.util.MySQLUtil;

public class SectionManager extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		doGet(request,response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		MySQLUtil mysql=new MySQLUtil();
		try {
			mysql.jdbcUtil();
			String sql="select s_id,s_name,s_number,s_info,u_name from section,users where s_u_id = u_id;";
			List<Section> list = new ArrayList();
			ResultSet rs= mysql.Query(sql);
			
			while(rs.next()){
		/*		int id = rs.getInt("u_id");
				int status =rs.getInt("u_status");
				String username=rs.getString("u_name");
				String password = rs.getString("u_password");*/
				
				int s_id=rs.getInt("s_id");
				String name=rs.getString("s_name");
				int number=rs.getInt("s_number");
				String info=rs.getString("s_info");
				String username=rs.getString("u_name");
				Section sec=new Section();
				sec.setS_id(s_id);
				sec.setName(name);
				sec.setNumber(number);
				sec.setInfo(info);
				sec.setUsername(username);
				list.add(sec);
			}
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("forum.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}