import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class ConnMySQLTest {

	@Test
	void testGetConnection() {
		
		Connection conn = ConnMySQL.getConnection();
		System.out.println(conn);
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
				System.out.println("数据库已关闭");
			}else {
				System.out.println("数据库连接失败");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
