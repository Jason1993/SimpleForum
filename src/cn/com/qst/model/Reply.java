package cn.com.qst.model;

import java.sql.Timestamp;

public class Reply {
	String r_contents;
	Timestamp time;
	String u_name;
	public String getR_contents() {
		return r_contents;
	}
	public void setR_contents(String r_contents) {
		this.r_contents = r_contents;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	
	
}
