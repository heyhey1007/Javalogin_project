package view;

import java.util.Scanner;
	/*
	 * コンソールへの表示のみを定義する。(ログイン画面)
	 * TODO データは保持しないように
	 */
public class LoginView implements IState {
	protected static String id = "";
	protected static String password = "";
	private Scanner scanner = new Scanner(System.in);

	@Override
	public void execute() {
		System.out.println("ログイン情報を入力してください");
		System.out.print("ID:");
		LoginView.id = scanner.nextLine();
		System.out.print("Password:");
		LoginView.password = scanner.nextLine();
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}
}
