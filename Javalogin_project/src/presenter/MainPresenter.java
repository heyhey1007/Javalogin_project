package presenter;

import model.UserModel;
import view.ViewFragment;

/**
 * @author heyhe
 * ユーザーの操作を受けてアプリでやりたいことを書く
 * アプリの機能をかく？
 * fragmentから呼ばれる..
 * Modelに問い合わせる
 */

public class MainPresenter implements IAuthPresenter {

	private UserModel model = UserModel.getInstance();
	private ViewFragment view = new ViewFragment();
	//コンストラクタ
	public MainPresenter() {
		view.setPresenter(this);
		start();
	}

	public void start() {
		while(true){
			if(view.login()) {
				view.showMyPage();
			}
		}

	}

	/*
	 * (非 Javadoc)
	 * @see presenter.IAuthPresenter#checkAuth(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean checkAuth(String id, String password) {
		if( model.authMember(id, password)) {
			return true;
		}
		return false;
	}

	/*
	 * (非 Javadoc)
	 * @see presenter.IAuthPresenter#getUserClass(java.lang.String, java.lang.String)
	 */
	@Override
	public String getUserClass(String id, String password) {
		return model.getUserClass(id, password);
	}


}
