package userLogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	static Connection con;
	private ConnectionUtil(){
	}
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	static ThreadLocal<Connection> tlocal=new ThreadLocal<Connection>();
	public static Connection createConnection() {
		con=tlocal.get();
		if(con==null) {
			try {
				con=DriverManager.getConnection("jdbc:mysql://localhost/code3", "root", "1234");
				tlocal.set(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return con;
	}
	public static void closeConnection() {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			tlocal.remove();
		}
	}
}
