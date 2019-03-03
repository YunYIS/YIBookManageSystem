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
 * 模型层（提供对数据库操作（增、删、改、查）接口）
 * @author YunYIS
 */
public class BOOKDAO {
	
		/**
		 * 查询所有用户信息
		 * @return 用户列表
		 * @throws SQLException
		 */
		public List<User> queryUserAll() throws SQLException {
			Connection conn = DBUtil.getBOOKConnection();//获取数据库连接

			String querySQL = "select * from [User]";//User是关键字，用做表名加[]
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
			return users;
		}
		/**
		 * 添加用户到数据库的用户表(用户注册)
		 * @param user
		 * @throws SQLException
		 */
		public void addUser(User user) throws SQLException{
			Connection conn = DBUtil.getBOOKConnection();
			
			String insertSQL = "insert into [User] values(?, ?, ?)";
			
			PreparedStatement pstmt = conn.prepareStatement(insertSQL);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getRegisterDate());
			pstmt.executeUpdate();
			
			//DBUtil.closeBOOKConnection();
		}
		/**
		 * 查询所有管理员信息
		 * @return 管理员信息列表
		 * @throws SQLException
		 */
		public List<Manager> queryManagerAll() throws SQLException {
			Connection conn = DBUtil.getBOOKConnection();

			String querySQL = "select * from Administrator";//User是关键字，用做表名加[]
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
			return managers;
		}
		/**
		 * 查询数据库中所有书籍信息
		 * @return
		 * @throws SQLException
		 */
		public List<Book> queryBookAll() throws SQLException{
			String querySQL = "select * from books";
			return queryBookRealized(querySQL);
		}
		/**
		 * 在数据库中，通过 单独的一个字段 对书籍进行模糊查询（可查询头部和尾部不完整匹配内容）
		 * @param flag 标志字段：1 表示matchContent接收的参数为书名；2 表示作者名；3 表示简介
		 * @param matchContent 匹配内容
		 * @return 符合条件书籍列表
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
		 * 在数据库中，通过 name, author, summary三个字段 对书籍进行模糊查询（可查询头部和尾部不完整匹配内容）
		 * @param matchContent 匹配内容
		 * @return 符合条件书籍列表
		 * @throws SQLException
		 */
		public List<Book> queryBook(String matchContent) throws SQLException {
			String querySQL = "select * from books where name like '%" + matchContent + "%' or "
					+ "author like '%" + matchContent + "%' or"
							+ "summary like '%" + matchContent + "%'";
			return queryBookRealized(querySQL);
		}
		/**
		 * 查询书籍具体实现
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
			return books;
		}
		/**
		 * 添加书籍
		 * @param book
		 * @throws SQLException
		 */
		public void addBook(Book book) throws SQLException{
			
			String addSQL = "insert into books(name, author, publicationDate, country, pages, price, summary, borrow) "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?)";
			updateOrInsertBookRealize(book, addSQL);
		}
		/**
		 * 删除书籍
		 * @param no 所删除书籍的编号
		 * @throws SQLException
		 */
		public void deleteBook(int no) throws SQLException{
			Connection conn = DBUtil.getBOOKConnection();
			
			String deleteSQL = "delete from books no=" + no;
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(deleteSQL);
			
		}
		/**
		 * 修改书籍信息
		 * @param book
		 * @throws SQLException
		 */
		public void updateBook(Book book) throws SQLException{
			
			String updateSQL = "update books set name = ?, author = ?, publicationDate = ?, country = ?, pages = ?, price = ?"
					+ ", summary = ?";
			updateOrInsertBookRealize(book, updateSQL);
		}
		/**
		 * 修改、增加书籍的具体实现
		 * @param book
		 * @param stringSQL 根据SQL语句的不同实现书籍信息的修改和增加
		 * @throws SQLException
		 */
		private void updateOrInsertBookRealize(Book book, String stringSQL) throws SQLException{
			
			Connection conn = DBUtil.getBOOKConnection();
			PreparedStatement pstmt = conn.prepareStatement(stringSQL);//预编译
			
			//加入参数
			pstmt.setString(1, book.getName());
			pstmt.setString(2, book.getAuthor());
			pstmt.setString(3, book.getPublicationDate() == null ? "null" : book.getPublicationDate());
			pstmt.setString(4, book.getCountry() == null ? "null" : book.getCountry());
			pstmt.setInt(5, book.getPages());
			pstmt.setFloat(6, book.getPrice());
			pstmt.setString(7, book.getSummary() == null ? "null" : book.getSummary());
			pstmt.setString(8, book.getBorrow() == null ? "无" : book.getBorrow());
			pstmt.execute();//执行SQL语句
			
		}
		

}
