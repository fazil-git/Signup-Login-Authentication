package userLogin;

import java.util.Scanner;

public class Handler {
	static Scanner sc=new Scanner(System.in);
	static Login login;
	public static void main(String[] args) {
		System.out.print("Enter the userId: ");
		int userId=sc.nextInt();
		System.out.println("Enter the password: ");
		String password="passXYZ";
		
		login=new Login();
		boolean auth=login.checkUser(userId, password);
		
		if(!auth) {
			System.out.println("Do you want to register? Type 'Yes' or 'No' if you are interested!");
			String userChoice=sc.nextLine().trim();
			userChoice="Yes";
			try {
				YN yn=(YN) Class.forName("userLogin."+userChoice).getDeclaredConstructor().newInstance();
				yn.invoke();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

abstract class YN{
	public abstract void invoke();
}
class Yes extends YN{
	public void invoke() {
		Register register=new Register();
		register.doRegister();
	}
}

class No extends YN{
	@Override
	public void invoke() {
		System.out.println("Ok see ya around!! ");
	}
}