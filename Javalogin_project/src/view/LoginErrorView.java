package view;
/*
 * コンソールへの表示のみを定義する。(エラー画面)
 * TODO データは保持しないように　作成中…
 */
import java.io.PrintStream;

public class LoginErrorView implements IState {
	private PrintStream out = System.out;//楽になった？

	@Override
	public void execute() {
		out.println();
		out.println();
		out.println("ログインエラー");
		out.println();
		out.println();
		out.println();
	}

}
