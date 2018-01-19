package Database;

/**
 * 加载、获取数据库连接工具类
 * @author 张云天
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	private static final String BOOK_URL = "jdbc:sqlserver://localhost:1433;" +
			"databaseName=BOOK;integratedSecurity=true;";
	
	private static Connection USEConn = null;
	private static Connection BOOKConn = null;
	static {
		try {
        		//加载驱动程序
        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        		BOOKConn = DriverManager.getConnection(BOOK_URL);            	
        	}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取图书数据库连接（BOOK）
	 * @return BOOK数据库连接
	 */
	public static Connection getBOOKConnection(){
		return BOOKConn;
	}
	/**
	 * 关闭数据库连接
	 */
	public static void closeBOOKConnection(){
		try {
			BOOKConn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
