package Database;

/**
 * ���ء���ȡ���ݿ����ӹ�����
 * @author ������
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	
	private static final String BOOK_URL = "jdbc:sqlserver://localhost:1433;" +
			"databaseName=BOOK;integratedSecurity=true;";
	
	private static Connection USEConn = null;
	private static Connection BOOKConn = null;
	static {
		try {
        		//������������
        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        		BOOKConn = DriverManager.getConnection(BOOK_URL);            	
        	}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ȡͼ�����ݿ����ӣ�BOOK��
	 * @return BOOK���ݿ�����
	 */
	public static Connection getBOOKConnection(){
		return BOOKConn;
	}

}