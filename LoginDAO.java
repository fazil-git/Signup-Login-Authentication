package userLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
	Connection con;
	User user;
	public LoginDAO() {
		user=new User();
	}
	private static final String MY_QUERRY="select userId, password, status from userlogin where userId=? && password=?;";
	private static final String SET_STATUS="update userlogin set status=? where userId=?;";
	public User findUser(int userId, String password) {
		con=ConnectionUtil.createConnection();
		try {
			PreparedStatement pst=con.prepareStatement(MY_QUERRY);
			pst.setInt(1, userId);
			pst.setString(2, password);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()) {
				user.setUserId(rs.getInt(1));
				user.setPassword(rs.getString(2));
				user.setStatus(rs.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	public void setStatus(User user) {
		PreparedStatement pst;
		try {
			pst = con.prepareStatement(SET_STATUS);
			pst.setInt(1, user.getStatus());
			pst.setInt(2, user.getUserId());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
