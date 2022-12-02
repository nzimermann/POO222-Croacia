package module_croacia;

import java.time.LocalDate;
import java.time.Period;

public class Player {
	private int number;
	private String name;
	private String nickname;
	private int height;
	private double weight;
	private LocalDate birthDate;
	private String position;
	private String currentClub;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		if (number < 1 || number > 99) {
			throw new IllegalArgumentException("Invalid number");
		}
		this.number = number;
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		if (nickname == null || nickname.isBlank()) {
			throw new IllegalArgumentException("Empty nickname");
		}
		this.nickname = nickname;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		if (height < 1 || height > 300) {
			throw new IllegalArgumentException("Invalid height");
		}
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		if (weight < 1d || weight > 300d) {
			throw new IllegalArgumentException("Invalid weight");
		}
		this.weight = weight;
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		if (position == null || position.isBlank()) {
			throw new IllegalArgumentException("Empty position");
		}
		this.position = position;
	}

	public String getCurrentClub() {
		return currentClub;
	}

	public void setCurrentClub(String currentClub) {
		if (currentClub == null || currentClub.isBlank()) {
			throw new IllegalArgumentException("Empty club");
		}
		this.currentClub = currentClub;
	}
	
	public int getAge() {
		if (birthDate == null) {
			throw new IllegalArgumentException("Empty birth date");
		}
		return Period.between(birthDate, LocalDate.now()).getYears();
	}

	public String getDataJSON() {
		return "{\n\tnumber:"
				+number+",\n\tname:\""
				+name+"\",\n\tnickname:\""
				+nickname+"\",\n\theight:"
				+height+",\n\tweight:"
				+weight+",\n\tbirthDate:\""
				+birthDate+"\",\n\tposition:\""
				+position+"\",\n\tcurrentClub:\""
				+currentClub+"\"\n}";
	}

}
