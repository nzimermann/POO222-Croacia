package module_croacia;

import java.time.LocalDate;
import java.time.Period;

public class TechnicalStaff {
	private String name;
	private String nickname;
	private String role;
	private LocalDate birthDate;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException("Empty name");
		}
		this.name = name;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		if (nickname == null || nickname.isBlank()) {
			throw new IllegalArgumentException("Empty nickname");
		}
		this.nickname = nickname;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		if (role == null || role.isBlank()) {
			throw new IllegalArgumentException("Empty role");
		}
		this.role = role;
	}
	
	public LocalDate getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(LocalDate birthDate) {
		if (birthDate == null) {
			throw new IllegalArgumentException("Empty birth date");
		}
		this.birthDate = birthDate;
	}
	
	public int getAge() {
		if (birthDate == null) {
			throw new IllegalArgumentException("Empty birth date");
		}
		return Period.between(birthDate, LocalDate.now()).getYears();
	}
	
	public String getDataJSON() {
		return "{\n\tname:\""
				+name+"\",\n\tnickname:\""
				+nickname+"\",\n\trole:\""
				+role+"\",\n\tage:"
				+this.getAge()+"\n}";
	}

}
