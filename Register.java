package userLogin;

import java.util.Scanner;

public class Register {
	RegisterDao registerDao;
	public Register() {
		registerDao=new RegisterDao();
	}
	public void doRegister() {
		System.out.print("Enter your password: ");
		Scanner sc=new Scanner(System.in);
		String password=sc.nextLine();
		registerDao.registerUpdate(password);
		sc.close();
	}
}
