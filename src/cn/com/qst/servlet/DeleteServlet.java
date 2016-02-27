package cn.com.qst.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.qst.util.MySQLUtil;

public class DeleteServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		
		String id=request.getParameter("id").toString();
		
		MySQLUtil my=new MySQLUtil();
		String sql="update users set u_status=1 where u_id = '"+ id + "'";
			try {
				my.jdbcUtil();
				my.Execute(sql);
				response.sendRedirect("userManager");
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
		
		protected void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
			doGet(request,response);
		}
}
