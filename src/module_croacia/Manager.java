package module_croacia;

public class Manager {
	private String name;
	private String tel1;
	private String tel2;
	private String emailAccount;

	public Manager(String name, String tel1, String tel2, String emailAccount) {
		this.setName(name);
		this.setTel1(tel1);
		this.setTel2(tel2);
		this.setEmailAccount(emailAccount);
	}

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
		return "{\n\tname: \""+name+"\",\n\ttel1:\"+"
				+tel1+"\",\n\ttel2:\"+"
				+tel2+"\",\n\temailAccount:\""
				+emailAccount+"\"\n}";
	}

}
