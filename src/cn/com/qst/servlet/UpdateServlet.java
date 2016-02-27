package cn.com.qst.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.qst.util.MySQLUtil;

public class UpdateServlet extends HttpServlet {
protected void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		
		String id=request.getSession().getAttribute("id").toString();
		String name=new String(request.getParameter("username").getBytes("iso-8859-1"));
		String password1=new String(request.getParameter("password1").getBytes("iso-8859-1"));
		String password2=new String(request.getParameter("password2").getBytes("iso-8859-1"));
		if(name.length()==0 || password1.length()==0 || password2.length()==0)
		{
			String url="update.jsp?id="+id;
			response.sendRedirect(url);
			return ;
		}
		if(password1.equals(password2)){
			MySQLUtil my=new MySQLUtil();
			String str="update users set u_password = '"+password1+"' ,u_name ='"+name+"' where u_id = '"+id+"'";
			try {
				my.jdbcUtil();
				if(my.Execute(str))
					response.sendRedirect("userManager");
				else
				{
				//	response.sendRedirect("register.jsp");
					String url="update.jsp?id="+id;
					response.sendRedirect(url);
				}
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
			String url="update.jsp?id="+id;
			response.sendRedirect(url);
		}
	}
//	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		doGet(request,response);
	}
}
