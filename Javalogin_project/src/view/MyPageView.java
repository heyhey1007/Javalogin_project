package view;

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
