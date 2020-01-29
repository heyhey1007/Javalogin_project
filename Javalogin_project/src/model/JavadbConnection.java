package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JavadbConnection {

	private Connection con;

	public JavadbConnection() {
		try {
			// JDBCドライバのロード - JDBC4.0（JDK1.6）以降は不要
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// MySQLに接続
			this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb", "root", "root");
			//"jdbc:SQLの種類：URL/接続DB","ID","Pass"
			System.out.println("MySQLに接続できました。");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			System.out.println("JDBCドライバのロードに失敗しました。");
		} catch (SQLException e1) {
			System.out.println("MySQLに接続できませんでした。");
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println("MySQLのクローズに失敗しました。");
				}
			}
		}
	}

	public Connection getConnection() {

		return con;

	}

}
