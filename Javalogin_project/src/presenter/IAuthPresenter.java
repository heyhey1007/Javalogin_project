package presenter;

/**
 * View側からPresenter側にしてほしい処理を書く
 * インターフェース
 * @author heyhe

 */
public interface IAuthPresenter {
	//presenterがViewから呼ばれる処理を定義
	public String getUserClass(String id, String password);
	public boolean checkAuth(String id, String password);
	//例：
	/* 新しいアカウントを登録
	 * public void addNewMember(String id, String password, String memberClass);
	 */
}
