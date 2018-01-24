package Database;

import java.sql.SQLException;
import java.util.List;

import model.Manager;
import model.User;
import model.Book;

/**
 * ���Ʋ�
 * @author YunYIS
 */
public class BOOKAction {
	
	/**
	 * ע���û�
	 * @param user
	 * @throws SQLException
	 */
	public void addUser(User user) throws SQLException{
		new BOOKDAO().addUser(user);
	}
	/**
	 * ��ѯ������ע����û�
	 * @return
	 * @throws SQLException
	 */
	public List<User> queryUserAll() throws SQLException{
		return new BOOKDAO().queryUserAll();
	}
	/**
	 * ��ѯ���п���ʹ�õĹ���Ա�˻�
	 * @return
	 * @throws SQLException
	 */
	public List<Manager> queryManagerAll() throws SQLException{
		return new BOOKDAO().queryManagerAll();
	}
	/**
	 * ����Ա�����ݿ�������鼮
	 * @param book
	 * @throws SQLException
	 */
	public void addBook(Book book) throws SQLException{
		new BOOKDAO().addBook(book);
	}
	/**
	 * ����Աɾ�����ݿ��е��鼮��Ϣ
	 * @param no
	 * @throws SQLException
	 */
	public void deleteBook(int no) throws SQLException{
		new BOOKDAO().deleteBook(no);
	}
	/**
	 * ����Ա�޸����ݿ��е��鼮��Ϣ
	 * @param book
	 * @throws SQLException
	 */
	public void updateBook(Book book) throws SQLException{
		new BOOKDAO().updateBook(book);
	}
	/**
	 * ͨ�� ������һ���ֶ� ���鼮����ģ���������ɲ�ѯͷ����β��������ƥ�����ݣ�
	 * @param flag ��־�ֶΣ�1 ��ʾmatchContent���յĲ���Ϊ������2 ��ʾ��������3 ��ʾ���
	 * @param matchContent ��ѯ����
	 * @return
	 * @throws SQLException
	 */
	public List<Book> queryBook(int flag, String matchContent) throws SQLException{
		return new BOOKDAO().queryBook(flag, matchContent);
	}
	/**
	 * ͨ�� name, author, summary�����ֶ� ���鼮����ģ���������ɲ�ѯͷ����β��������ƥ�����ݣ�
	 * @param matchContent ��ѯ����
	 * @return
	 * @throws SQLException
	 */
	public List<Book> queryBook(String matchContent) throws SQLException{
		return new BOOKDAO().queryBook(matchContent);
	}
	
}
