package cn.com.qst.model;

import java.sql.Timestamp;

public class Topic {
	int t_id;
	String t_title;
	int t_s_id;
	int t_u_id;
	int t_number;
	Timestamp time;
	String username;
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}

	public int getT_id() {
		return t_id;
	}
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	public String getT_title() {
		return t_title;
	}
	public void setT_title(String t_title) {
		this.t_title = t_title;
	}
	public int getT_s_id() {
		return t_s_id;
	}
	public void setT_s_id(int t_s_id) {
		this.t_s_id = t_s_id;
	}
	public int getT_u_id() {
		return t_u_id;
	}
	public void setT_u_id(int t_u_id) {
		this.t_u_id = t_u_id;
	}
	
	public int getT_number() {
		return t_number;
	}
	public void setT_number(int t_number) {
		this.t_number = t_number;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
