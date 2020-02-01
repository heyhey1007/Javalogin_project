import java.sql.Connection;
import java.sql.SQLException;

import controller.MainController;
import model.JavadbConnection;

public class Main {

	public static void main(String[] args) {
		// TODO 非会員の見分けるメソッド
		try {
		new MainController();
		}finally {
			Connection con = JavadbConnection.getInstance().getMySQLConnection();
			if (con != null) {
				try {
					con.close();
					System.out.println("クローズ成功");
				} catch (SQLException e) {
					System.out.println("MySQLのクローズに失敗しました。");
				}
			}
		}
		/*
		try {
			System.out.println(UserModel.getInstance().getUserClass("nakata", "shouhei"));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {//クローズ処理
			Connection con = JavadbConnection.getInstance().getMySQLConnection();
			if (con != null) {
				try {
					con.close();
					System.out.println("クローズ成功");
				} catch (SQLException e) {
					System.out.println("MySQLのクローズに失敗しました。");
				}
			}
		}*/

	}
}
