package view;
import java.util.HashMap;

/**
 * Viewを管理しやすくしたかった。。。(Mapを使いたかった)
 * HashMapを使って,値としてViewのインスタンスを返す。
 * */
public class ViewHashMapCreater {

	private ViewHashMapCreater(){
	}

	public static HashMap<String,IState> createViewMap() {
		HashMap<String,IState> viewMap = new HashMap<String,IState>();
		viewMap.put("LOGIN_PAGE", new LoginView());
		viewMap.put("MY_PAGE", new MyPageView());
		return viewMap;
	}

}
