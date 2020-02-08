package view;

import java.util.HashMap;

import presenter.MainPresenter;

public class ViewFragment implements IAuthView {
	private MainPresenter presenter = null;
	private IState state = null;
	private HashMap<String, IState> viewState = ViewHashMapCreater.createViewMap();

	public void changeView(IState viewState) {
		this.state = viewState;
	}

	public void renderView() {
		this.state.execute();
	}

	@Override
	public boolean login() {
		changeView(viewState.get("LOGIN_PAGE"));
		renderView();
		return presenter.checkAuth(LoginView.id, LoginView.password);
	}

	@Override
	public void showMyPage() {
		MyPageView.userClass = presenter.getUserClass(LoginView.id, LoginView.password);
		changeView(viewState.get("MY_PAGE"));
		renderView();
	}

	public void setPresenter(MainPresenter instance) {
		presenter = instance;
	}
}
