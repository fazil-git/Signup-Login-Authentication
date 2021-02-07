package userLogin;

public class Login {
	LoginDAO loginDao;
	
	public Login() {
		loginDao=new LoginDAO();
	}
	
	public boolean checkUser(int userId, String password) {
		User user=loginDao.findUser(userId, password);
		if(userId==user.getUserId() && password.equals(user.getPassword())) {
			if(user.getStatus()==0) {
				System.out.println("Welcome user!!");
				user.setStatus(1);
				loginDao.setStatus(user);
			}
			else{
				System.out.println("Already logged in..");
			}
			return true;
		}
		return false;
	}
}
