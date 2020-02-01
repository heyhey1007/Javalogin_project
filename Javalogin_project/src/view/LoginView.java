package view;

import java.util.Scanner;

public class LoginView implements IView, ILogin {
	private static final LoginView INSTANCE = new LoginView();
	private String id;
	private String pass;
	private LoginInfo loginInfo;

	private LoginView() {}

	public static LoginView getInstance() {
		return INSTANCE;
	}

	@Override
	public void execute() {
		System.out.println("ログイン情報を入力してください");
		System.out.print("ID:");
		Scanner scanner = new Scanner(System.in);
		this.id = scanner.nextLine();
		System.out.print("Password:");
		this.pass = scanner.nextLine();
		scanner.close();
		setLoginInfo();
	}

	@Override
	public void setLoginInfo() {
		loginInfo = new LoginInfo();
		loginInfo.setId(id);
		loginInfo.setPassword(pass);
	}

	@Override
	public LoginInfo getLoginInfo() {
		return this.loginInfo;
	}

}
