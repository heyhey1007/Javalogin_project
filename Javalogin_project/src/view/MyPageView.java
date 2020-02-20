package view;
/*
 * コンソールへの表示のみを定義する。(マイページ画面)
 * TODO データは保持しないように
 */
public class MyPageView implements IState{

	protected static String userClass = "";

	@Override
	public void execute() {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("あなたのクラスは" + userClass + "です。");
		System.out.println();
	}
}
