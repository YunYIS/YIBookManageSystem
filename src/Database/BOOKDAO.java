package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Book;
import model.Manager;
import model.User;

/**
 * 
 * @author ������
 * 
 */
public class BOOKDAO {
	
		/**
		 * ��ѯ�����û���Ϣ
		 * @return �û��б�
		 * @throws SQLException
		 */
		public List<User> queryUserAll() throws SQLException {
			Connection conn = DBUtil.getBOOKConnection();

			String querySQL = "select * from [User]";//User�ǹؼ��֣�����������[]
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(querySQL);
			
			List<User> users = new ArrayList<>();
			User user = null;
			
			while(rs.next()){
				user = new User();
				user.setNo(rs.getInt("no"));
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				user.setRegisterDate(rs.getString("registerDate"));
				
				users.add(user);
				
			}
			DBUtil.closeBOOKConnection();
			return users;
		}
		/**
		 * ����û������ݿ���û���
		 * @param user
		 * @throws SQLException
		 */
		public void addUser(User user) throws SQLException{
			Connection conn = DBUtil.getBOOKConnection();
			
			String querySQL = "insert into [User] values("
					+ user.getUserName() + ", "
					+ user.getPassword() + ", "
					+ user.getRegisterDate() + ")";
			
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(querySQL);
		}
		/**
		 * ��ѯ���й���Ա��Ϣ
		 * @return ����Ա��Ϣ�б�
		 * @throws SQLException
		 */
		public List<Manager> queryManagerAll() throws SQLException {
			Connection conn = DBUtil.getBOOKConnection();

			String querySQL = "select * from Administrator";//User�ǹؼ��֣�����������[]
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(querySQL);
			
			List<Manager> managers = new ArrayList<>();
			Manager manager = null;
			
			while(rs.next()){
				manager = new Manager();
				manager.setNo(rs.getInt("no"));
				manager.setAdminName(rs.getString("adminName"));
				manager.setPassword(rs.getString("password"));
				manager.setDate(rs.getString("date"));
				
				managers.add(manager);
				
			}
			DBUtil.closeBOOKConnection();
			return managers;
		}
		
//		public List<Book> queryBook(String bookName, String author) throws SQLException {
//			Connection conn = DBUtil.getBOOKConnection();
//
//			String querySQL = "select * from Book";//User�ǹؼ��֣�����������[]
//			Statement stmt = conn.createStatement();
//			
//			ResultSet rs = stmt.executeQuery(querySQL);
//			
//			List<Manager> managers = new ArrayList<>();
//			Manager manager = null;
//			
//			while(rs.next()){
//				manager = new Manager();
//				manager.setNo(rs.getInt("no"));
//				manager.setAdminName(rs.getString("adminName"));
//				manager.setPassword(rs.getString("password"));
//				manager.setDate(rs.getString("date"));
//				
//				managers.add(manager);
//				
//			}
//			DBUtil.closeBOOKConnection();
//			return managers;
//		}
		

}
