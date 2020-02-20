package model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author heyhe
 * API的な奴
 * データベースへの操作を抽象化
 * TODO Viewやpresenterに依存しない
 */
//TODO 登録日時のDB登録
public class UserModel {

	//フィールド
	private static UserModel userModelInstance = new UserModel();
	private Statement dbstatement;

	//constractor
	private UserModel() {
		try {
			dbstatement = JavadbConnection.getInstance().getStatement();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			System.out.println("ステートメント取得失敗");
		}
	}

	//singleton
	public static UserModel getInstance() {
		return userModelInstance;
	}

	/**
	 *工事中...
	 */
	public boolean authMember(String id, String pass) {
		try {
			if (checkAuth(id, pass).next() == false) {
				//System.out.println("ログイン失敗");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//System.out.println("ログイン成功");
		return true;
	}

	/**
	 * DBに問い合わせ、CLASSカラムの文字列を返す。
	 * @param id
	 * @param pass
	 * @return Data
	 * @throws SQLException
	 */
	public String getUserClass(String id, String pass) {
		//DBからデータオブジェクトを受け取る。
		ResultSet resultData = getUserClassData(id, pass);
		String Data = "";
		//次のデータがなければ
		try {
			while (resultData.next()) {
				Data = resultData.getString("CLASS");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Data;

	}

	/**
	 * DBにメンバが存在するか確認(認証機能)
	 * TODO boolean型返せばいいんじゃ..
	 * @param id
	 * @param pass
	 * @return
	 */
	private ResultSet checkAuth(String id, String pass) {
		String sql = "SELECT "
				+ "*"
				+ " FROM "
				+ "account "
				+ "WHERE "
				+ "ID = '" + id
				+ "' AND "
				+ "Pass = '" + pass
				+ "';";
		try {
			ResultSet result = dbstatement.executeQuery(sql);//ResultSet型を返す
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Userデータを取得する
	 * SQLでDBに問い合わせ
	 * @param id
	 * @param pass
	 * @return SetResult data
	 */
	private ResultSet getUserClassData(String id, String pass) {
		//statementインターフェースを利用してDB操作をする
		String sql = "SELECT "
				+ "CLASS "
				+ " FROM "
				+ "account "
				+ "WHERE "
				+ "ID = '" + id
				+ "' AND "
				+ "Pass = '" + pass
				+ "';";
		try {
			ResultSet result = dbstatement.executeQuery(sql);//ResultSet型を返す
			//System.out.println("クラスデータ取得成功");
			return result;
		} catch (SQLException e) {
			//System.out.println("クラスデータ取得失敗");
			e.printStackTrace();
			return null;
		}
	};
}
