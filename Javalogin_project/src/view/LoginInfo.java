package view;

/**
 * 入力されたログイン情報を格納するオブジェクト
 * @author heyhe
 *
 */
public class LoginInfo {

	//private HashMap<String, String> memberLoginInfo = new HashMap<String, String>();
	private String id;
	private String password;
	private String memberClass;

	public void setId(String inputId) {
		this.id = inputId;
	}

	public void setPassword(String inputPassword) {
		this.password = inputPassword;
	}

	public void setMemberClass(String inputMemberClass) {
		this.memberClass = inputMemberClass;
	}

	public String getId() {
		return this.id;
	}

	public String getPassword() {
		return this.password;
	}

	public String getMemberClass() {
		return this.memberClass;
	}
}