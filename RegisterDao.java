package userLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao {
	Connection con;
	private static final String REG_USER="insert into userlogin (password, status) values(?,0);";
	public void registerUpdate(String password) {
		con=ConnectionUtil.createConnection();
		try {
			PreparedStatement pst=con.prepareStatement(REG_USER);
			pst.setString(1, password);
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
