package module_croacia;

public class Manager {
	private String name;
	private String tel1;
	private String tel2;
	private String emailAccount;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException("Empty name");
		}
		this.name = name;
	}
	
	public String getTel1() {
		return tel1;
	}
	
	public void setTel1(String tel1) {
		if (tel1 == null || tel1.isBlank()) {
			throw new IllegalArgumentException("Phone1 empty");
		}
		this.tel1 = tel1;
	}
	
	public String getTel2() {
		return tel2;
	}
	
	public void setTel2(String tel2) {
		if (tel2 == null || tel2.isBlank()) {
			throw new IllegalArgumentException("Phone2 empty");
		}
		this.tel2 = tel2;
	}
	
	public String getEmailAccount() {
		return emailAccount;
	}
	
	public void setEmailAccount(String emailAccount) {
		if (emailAccount == null || emailAccount.isBlank()) {
			throw new IllegalArgumentException("Empty email");
		}
		this.emailAccount = emailAccount;
	}
	
	public String getDataJSON() {
		return "{name: \""+name+"\"}, tel1:\"+"
				+tel1+"\", tel2:\"+"
				+tel2+"\", emailAccount:\""
				+emailAccount+"\"}";
	}
}
