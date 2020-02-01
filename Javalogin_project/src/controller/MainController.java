package controller;

import java.sql.SQLException;

import model.UserModel;
import view.LoginInfo;
import view.LoginView;

public class MainController {

	//private HashMap<String, IView> viewMap = new HashMap<String, IView>();
	private LoginView loginView = LoginView.getInstance();

	public MainController() {
		ViewRenderer viewRender = new ViewRenderer();
		viewRender.changeView(loginView);
		viewRender.renderView();
		login(loginView.getLoginInfo());
	};

	public void login(LoginInfo dataObject) {
		String UserClass = "";
		try {
			UserClass = UserModel.getInstance().getUserClass(dataObject.getId(), dataObject.getPassword());
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("あなたのクラスは" + UserClass + "です。");
		System.out.println();



	}

}
