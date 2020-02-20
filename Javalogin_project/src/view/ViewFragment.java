package view;
import java.util.HashMap;

import presenter.MainPresenter;
/**
 * @author heyhe
 * 表示させる画面(画面の状態)と入力情報を管理する。
 * ユーザーの入力を受けてpresenterの関数を呼び出す。
 */
public class ViewFragment implements IAuthView {
	private MainPresenter presenter = null;
	private IState state = null;
	private HashMap<String, IState> viewState = ViewHashMapCreater.createViewMap();

	//presenterのセッター
	public void setPresenter(MainPresenter instance) {
		presenter = instance;
	}
	//表示したい画面をセット
	public void changeView(IState viewState) {
		this.state = viewState;
	}
	//描画
	public void renderView() {
		this.state.execute();
	}
	/*
	 * (非 Javadoc)
	 * @see view.IAuthView#login()
	 */
	@Override
	public boolean login() {
		changeView(viewState.get("LOGIN_PAGE"));
		renderView();
		return presenter.checkAuth(LoginView.id, LoginView.password);
	}
	/*
	 * (非 Javadoc)
	 * @see view.IAuthView#showMyPage()
	 */
	@Override
	public void showMyPage() {
		MyPageView.userClass = presenter.getUserClass(LoginView.id, LoginView.password);
		changeView(viewState.get("MY_PAGE"));
		renderView();
	}
}
