package lecture0721;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class MainDBCP {
	private static BasicDataSource basicDS;	// connection pool > static이므로 Class를 loading 할 때 method area에 만들어짐
	
	static {
		try {
			basicDS = new BasicDataSource();	
			Properties properties = new Properties();	// java.util : key-value 형태로 사용할 수 있음
			
			InputStream is = new FileInputStream("resources/db.properties");
			properties.load(is);
			
			basicDS.setDriverClassName(properties.getProperty("DRIVER_CLASS"));
			basicDS.setUrl(properties.getProperty("JDBC_URL"));
			basicDS.setUsername(properties.getProperty("DB_USER"));
			basicDS.setPassword("DB_PASSWORD");
			
			// set parameter 필요
			basicDS.setInitialSize(10);
			basicDS.setMaxTotal(10);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static DataSource getDataSource() {
		return basicDS;
	}
	
	public static void main(String[] args) {
		
		Connection con = null;
		DataSource ds = getDataSource();
		
		try {
			con = ds.getConnection();	// Connection Pool에서 가용한 Connection을 가져온다.
			con.setAutoCommit(false);	// Transaction 시작
			
			String sql = "DELETE FROM buytbl";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			int result = pstmt.executeUpdate();	// sql 실행
			
			con.commit();	// 실행 내용 저장
			
			con.close();	// connection pool로 돌아감
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
