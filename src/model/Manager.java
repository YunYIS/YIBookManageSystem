package model;
/**
 * 管理员实体类
 * @author 张云天
 *
 */
public class Manager {
	
	private int no; 
	private String adminName;
	private String password;
	private String date;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String name) {
		this.adminName = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	

}
