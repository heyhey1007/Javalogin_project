import java.sql.Connection;
import java.sql.SQLException;

import model.JavadbConnection;
import model.UserModel;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		try {
			System.out.println(UserModel.getInstance().getUserClass("nakata", "shouhei"));
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {//クローズ処理
			Connection con=JavadbConnection.getInstance().getMySQLConnection();
			if (con != null) {
				try {
					con.close();
					System.out.println("クローズ成功");
				} catch (SQLException e) {
					System.out.println("MySQLのクローズに失敗しました。");
				}
			}
		}

	}
}
