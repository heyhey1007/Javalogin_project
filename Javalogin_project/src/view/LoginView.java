package view;

import java.util.Scanner;

public class LoginView implements IState {
	protected static String id = "";
	protected static String password = "";
	private Scanner scanner = new Scanner(System.in);
	@Override
	public void execute() {
		System.out.println(Integer.toHexString(scanner.hashCode()));
		System.out.println("ログイン情報を入力してください");
		System.out.print("ID:");
		LoginView.id = scanner.nextLine();
		System.out.print("Password:");
		LoginView.password = scanner.nextLine();
		//scanner.close();
	}
}
