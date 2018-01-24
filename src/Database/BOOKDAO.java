package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Book;
import model.Manager;
import model.User;
/**
 * ģ�Ͳ㣨�ṩ�����ݿ����������ɾ���ġ��飩�ӿڣ�
 * @author YunYIS
 */
public class BOOKDAO {
	
		/**
		 * ��ѯ�����û���Ϣ
		 * @return �û��б�
		 * @throws SQLException
		 */
		public List<User> queryUserAll() throws SQLException {
			Connection conn = DBUtil.getBOOKConnection();//��ȡ���ݿ�����

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
			DBUtil.closeBOOKConnection();//�ر����ݿ�����
			return users;
		}
		/**
		 * ����û������ݿ���û���(�û�ע��)
		 * @param user
		 * @throws SQLException
		 */
		public void addUser(User user) throws SQLException{
			Connection conn = DBUtil.getBOOKConnection();
			
			String insertSQL = "insert into [User] values("
					+ user.getUserName() + ", "
					+ user.getPassword() + ", "
					+ user.getRegisterDate() + ")";
			
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(insertSQL);
			DBUtil.closeBOOKConnection();
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
		/**
		 * �����ݿ��У�ͨ�� ������һ���ֶ� ���鼮����ģ����ѯ���ɲ�ѯͷ����β��������ƥ�����ݣ�
		 * @param flag ��־�ֶΣ�1 ��ʾmatchContent���յĲ���Ϊ������2 ��ʾ��������3 ��ʾ���
		 * @param matchContent ƥ������
		 * @return ���������鼮�б�
		 * @throws SQLException
		 */
		public List<Book> queryBook(int flag, String matchContent) throws SQLException{
			String querySQL;
			if (flag == 1){
				querySQL = "select * from books where name like '%" + matchContent + "%'";
			}else if (flag == 2) {
				querySQL = "select * from books where author like '%" + matchContent + "%'";
			}else {
				querySQL = "select * from books where summary like '%" + matchContent + "%'";
			}
			return queryBookRealized(querySQL);
		}
		/**
		 * �����ݿ��У�ͨ�� name, author, summary�����ֶ� ���鼮����ģ����ѯ���ɲ�ѯͷ����β��������ƥ�����ݣ�
		 * @param matchContent ƥ������
		 * @return ���������鼮�б�
		 * @throws SQLException
		 */
		public List<Book> queryBook(String matchContent) throws SQLException {
			String querySQL = "select * from books where name like '%" + matchContent + "%' or "
					+ "author like '%" + matchContent + "%' or"
							+ "summary like '%" + matchContent + "%'";
			return queryBookRealized(querySQL);
		}
		/**
		 * ��ѯ�鼮����ʵ��
		 * @param querySQL
		 * @return
		 * @throws SQLException
		 */
		private List<Book> queryBookRealized(String querySQL) throws SQLException{
			Connection conn = DBUtil.getBOOKConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(querySQL);
			
			List<Book> books = new ArrayList<>();
			Book book = null;
			
			while(rs.next()){
				book = new Book();
				book.setNo(rs.getInt("no"));
				book.setName(rs.getString("name"));
				book.setAuthor(rs.getString("author"));
				book.setPublicationDate(rs.getString("publicationDate"));
				book.setCountry(rs.getString("country"));
				book.setPages(rs.getInt("pages"));
				book.setPrice(rs.getFloat("price"));
				book.setSummary(rs.getString("summary"));
				book.setBorrow(rs.getString("borrow"));
				
				books.add(book);
			}
			DBUtil.closeBOOKConnection();
			return books;
		}
		/**
		 * ����鼮
		 * @param book
		 * @throws SQLException
		 */
		public void addBook(Book book) throws SQLException{
			
			String addSQL = "insert into books(name, author, publicationDate, country, pages, price, summary, borrow) "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?)";
			updateOrInsertBookRealize(book, addSQL);
		}
		/**
		 * ɾ���鼮
		 * @param no ��ɾ���鼮�ı��
		 * @throws SQLException
		 */
		public void deleteBook(int no) throws SQLException{
			Connection conn = DBUtil.getBOOKConnection();
			
			String deleteSQL = "delete from books no=" + no;
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(deleteSQL);
			
			DBUtil.closeBOOKConnection();
		}
		/**
		 * �޸��鼮��Ϣ
		 * @param book
		 * @throws SQLException
		 */
		public void updateBook(Book book) throws SQLException{
			
			String updateSQL = "update books set name = ?, author = ?, publicationDate = ?, country = ?, pages = ?, price = ?"
					+ ", summary = ?";
			updateOrInsertBookRealize(book, updateSQL);
		}
		/**
		 * �޸ġ������鼮�ľ���ʵ��
		 * @param book
		 * @param stringSQL ����SQL���Ĳ�ͬʵ���鼮��Ϣ���޸ĺ�����
		 * @throws SQLException
		 */
		private void updateOrInsertBookRealize(Book book, String stringSQL) throws SQLException{
			
			Connection conn = DBUtil.getBOOKConnection();
			PreparedStatement pstmt = conn.prepareStatement(stringSQL);//Ԥ����
			
			//�������
			pstmt.setString(1, book.getName());
			pstmt.setString(2, book.getAuthor());
			pstmt.setString(3, book.getPublicationDate() == null ? "null" : book.getPublicationDate());
			pstmt.setString(4, book.getCountry() == null ? "null" : book.getCountry());
			pstmt.setInt(5, book.getPages());
			pstmt.setFloat(6, book.getPrice());
			pstmt.setString(7, book.getSummary() == null ? "null" : book.getSummary());
			pstmt.setString(8, book.getBorrow() == null ? "��" : book.getBorrow());
			pstmt.execute();//ִ��SQL���
			
			DBUtil.closeBOOKConnection();
		}
		

}
