import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnMySQL {
	private static Connection mConnection;
	private static Properties mProperties;
	private static String driver;
	private static String url;
	private static String user;
	private static String pwd;
	static{
		
		mProperties = new Properties();
		//获取加载器
		try {
			mProperties.load(ConnMySQL.class.getClassLoader().getResourceAsStream("config.properties"));
			driver = mProperties.getProperty("driver");
			url = mProperties.getProperty("url");
			user = mProperties.getProperty("user");
			pwd = mProperties.getProperty("pwd");
			System.out.println(driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		try {
			
			Class.forName(driver);
			
			if (mConnection == null) {
				mConnection = DriverManager.getConnection(url, user, pwd);
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mConnection;
	}
	public static void closeConnection(Connection conn) throws SQLException {
		if (conn!= null && !conn.isClosed()) {
			conn.close();
		}
	}
	
}
