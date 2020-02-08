package presenter;

import model.UserModel;
import view.ViewFragment;

public class MainPresenter implements IAuthPresenter {

	private UserModel model = UserModel.getInstance();
	ViewFragment view = new ViewFragment();

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

	@Override
	public boolean checkAuth(String id, String password) {
		return model.authMember(id, password);
	}

	@Override
	public String getUserClass(String id, String password) {
		return model.getUserClass(id, password);
	}


}
