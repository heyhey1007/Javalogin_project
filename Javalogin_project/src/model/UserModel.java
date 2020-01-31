package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//TODO 登録日時のDB登録
public class UserModel {

	//フィールド
	private static UserModel userModelInstance = new UserModel();
	private final JavadbConnection CONNECTION_INSTANCE = JavadbConnection.getInstance();//インスタンス生成
	private Statement dbstatement;
	//定数
	private final String ID_COLUMN = "ID";
	private final String PASS_COLUMN = "Pass";
	private final String CLASS_COLUMN = "CLASS";

	//constractor
	private UserModel() {
		try {
			dbstatement = CONNECTION_INSTANCE.getStatement();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			System.out.println("ステートメント作成失敗");
		}
	};
	//singleton
	public static UserModel getInstance() {
		return userModelInstance;
	}

	//method
	/**
	 * CLASSの文字列を返す。
	 * @param id
	 * @param pass
	 * @return Data
	 * @throws SQLException
	 */
	public String getUserClass(String id, String pass) throws SQLException {
		ResultSet resultData = getUserClassData(id, pass);
		String Data = "";

		if (resultData == null) {
			System.out.println("データ取得エラー");
			return null;
		} else {
			//次のデータがなければ
			while (resultData.next()) {
				Data = resultData.getString("CLASS");
			}
			return Data;
		}
	}

	/**
	 * クラスデータを取得する
	 * SQLでDBに問い合わせ
	 * @param id
	 * @param pass
	 * @return SetResult data
	 */
	private ResultSet getUserClassData(String id, String pass) {
		//statementインターフェースを利用してDB操作をする
		String sql = "SELECT "
				+ "CLASS "
				+ "FROM "
				+ "account "
				+ "WHERE "
				+ "ID = '" + id
				+ "' AND"
				+ " Pass = '" + pass
				+ "';";
		try {
			ResultSet result = dbstatement.executeQuery(sql);//ResultSet型を返す
			System.out.println("クラスデータ取得成功");
			return result;
		} catch (SQLException e) {
			System.out.println("クラスデータ取得失敗");
			e.printStackTrace();
			return null;
		}
	};
}
