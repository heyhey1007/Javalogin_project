package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JavadbConnection {

	//フィールド
	private static JavadbConnection instance = new JavadbConnection();
	private Connection con;

	//コンストラクタ
	/**
	 * DB接続
	 */
	private JavadbConnection() {
		try {
			System.out.println("MySQLに接続中...");
			// MySQLに接続
			//con = DriverManager.getConnection("jdbc:mysql://13.114.188.3:3306/testdb", "root", "hogehoge");
			this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb", "root", "root");
			//"jdbc:SQLの種類：URL/接続DB","ID","Pass"
			System.out.println("MySQLに接続できました。");
		} catch (SQLException e1) {//接続失敗時の例外処理
			System.out.println("MySQLに接続できませんでした。");
		}
	}

	//メソッド
	/**
	 * インスタンスのゲッター（Singletonパターン）
	 * @return 唯一のインスタンス
	 */
	public static JavadbConnection getInstance() {
		return instance;
	}

	/**
	 * connectionの取得(いらないかも？)
	 * @return DBコネクション
	 */
	public Connection getMySQLConnection() {
		return con;
	}

	/**
	 * Statementの取得
	 * @return statement
	 * @throws SQLException
	 */
	protected Statement getStatement() throws SQLException {

		return  con.createStatement();
	}

}
