package model;
/**
 * �û�ʵ����
 * @author YunYIS
 */
public class User {
	
	private int no;
	private String userName;
	private String password;
	private String registerDate;
	
	public User(){}
	
	public User(String userName, String password, String registerDate) {
		this.userName = userName;
		this.password = password;
		this.registerDate = registerDate;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
}
