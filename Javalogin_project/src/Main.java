import presenter.MainPresenter;

public class Main {

	public static void main(String[] args) {
		// TODO 非会員の見分けるメソッド
		new MainPresenter();

		/*
		if (con != null) {
			try {
				con.close();
				System.out.println("クローズ成功");
			} catch (SQLException e) {
				System.out.println("MySQLのクローズに失敗しました。");
			}
		}
		*/
	}
}
