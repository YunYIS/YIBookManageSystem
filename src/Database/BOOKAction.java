package Database;

import java.sql.SQLException;
import java.util.List;

import model.Manager;
import model.User;
import model.Book;

/**
 * 控制层
 * @author YunYIS
 */
public class BOOKAction {
	
	/**
	 * 注册用户
	 * @param user
	 * @throws SQLException
	 */
	public void addUser(User user) throws SQLException{
		new BOOKDAO().addUser(user);
	}
	/**
	 * 查询所有已注册的用户
	 * @return
	 * @throws SQLException
	 */
	public List<User> queryUserAll() throws SQLException{
		return new BOOKDAO().queryUserAll();
	}
	/**
	 * 查询所有可以使用的管理员账户
	 * @return
	 * @throws SQLException
	 */
	public List<Manager> queryManagerAll() throws SQLException{
		return new BOOKDAO().queryManagerAll();
	}
	/**
	 * 管理员向数据库中添加书籍
	 * @param book
	 * @throws SQLException
	 */
	public void addBook(Book book) throws SQLException{
		new BOOKDAO().addBook(book);
	}
	/**
	 * 管理员删除数据库中的书籍信息
	 * @param no
	 * @throws SQLException
	 */
	public void deleteBook(int no) throws SQLException{
		new BOOKDAO().deleteBook(no);
	}
	/**
	 * 管理员修改数据库中的书籍信息
	 * @param book
	 * @throws SQLException
	 */
	public void updateBook(Book book) throws SQLException{
		new BOOKDAO().updateBook(book);
	}
	/**
	 * 通过 单独的一个字段 对书籍进行模糊搜索（可查询头部和尾部不完整匹配内容）
	 * @param flag 标志字段：1 表示matchContent接收的参数为书名；2 表示作者名；3 表示简介
	 * @param matchContent 查询内容
	 * @return
	 * @throws SQLException
	 */
	public List<Book> queryBook(int flag, String matchContent) throws SQLException{
		return new BOOKDAO().queryBook(flag, matchContent);
	}
	/**
	 * 通过 name, author, summary三个字段 对书籍进行模糊搜索（可查询头部和尾部不完整匹配内容）
	 * @param matchContent 查询内容
	 * @return
	 * @throws SQLException
	 */
	public List<Book> queryBook(String matchContent) throws SQLException{
		return new BOOKDAO().queryBook(matchContent);
	}
	
}
