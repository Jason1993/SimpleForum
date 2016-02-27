package cn.com.qst.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class MySQLUtil {
	Connection conn=null;
	Statement st=null;
	ResultSet rs=null;
	public void jdbcUtil()throws ClassNotFoundException,SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost/bbs","root","root");
		st=conn.createStatement();
	}

	public ResultSet Query(String sql) throws SQLException{
		rs=st.executeQuery(sql);
		return rs;
		
	}
	public boolean Execute(String sql) throws SQLException {
		return st.executeUpdate(sql)>0;
	}
	public void close(){
		try {
			st.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

