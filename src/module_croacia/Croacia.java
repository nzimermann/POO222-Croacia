package module_croacia;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import fifa.NationalTeamInfos;
import fifa.NationalTeamStats;
import java.util.HashMap;
import javax.imageio.ImageIO;
import java.util.ArrayList;

public class Croacia implements NationalTeamInfos {
	private HashMap<Integer, Player> players = new HashMap<Integer, Player>();
	private ArrayList<TechnicalStaff> technicalStaffs = new ArrayList<TechnicalStaff>();
	private Manager manager;
	private CroaciaStats stats = new CroaciaStats();

	public Croacia() {
		this.addPlayer(new Player(1, "Ivo Grbic", "Ivo", 196, 83d, LocalDate.of(1996, 1, 18), "goalkeeper", "Atletico Madrid"));
		this.addPlayer(new Player(2, "Ivica Ivusic", "Ivica", 196, 77d, LocalDate.of(1995, 2, 1), "goalkeeper", "Osijek"));
		this.addPlayer(new Player(6, "Dejan Lovren", "Dejan", 188, 83d, LocalDate.of(1989, 7, 5), "defender", "Zenit St Petersburg"));
		this.addPlayer(new Player(21, "Domagoj Vida", "Vida", 183, 76d, LocalDate.of(1989, 4, 29), "defender", "AEK Athens"));
		this.addPlayer(new Player(31, "Borna Barisic", "Borna", 185, 78d, LocalDate.of(1992, 11, 10), "defender", "Rangers"));
		this.addPlayer(new Player(10, "Luka Modric", "Modric", 173, 66d, LocalDate.of(1985, 9, 9), "midfield", "Real Madrid"));
		this.addPlayer(new Player(8, "Mateo Kovacic", "Mateo", 178, 78d, LocalDate.of(1994, 5, 6), "midfield", "Chelsea"));
		this.addPlayer(new Player(21, "Luka Sucic", "Luka", 185, 71d, LocalDate.of(2002, 9, 8), "midfield", "FC Salzburg"));
		this.addPlayer(new Player(27, "Andrej Kramaric", "Andrej", 178, 73d, LocalDate.of(1991, 6, 19), "attacker", "Hoffenheim"));
		this.addPlayer(new Player(9, "Bruno Petkovic", "Bruno", 193, 87d, LocalDate.of(1994, 9, 16), "attacker", "D Zagreb"));
		this.addPlayer(new Player(17, "Ante Budimir", "Ante", 191, 73d, LocalDate.of(1991, 7, 22), "attacker", "Osasuna"));
		this.addTechnicalStaff(new TechnicalStaff("Luka Modrić", "Luka", "Capitain", LocalDate.of(1985, 9, 9)));
		this.addTechnicalStaff(new TechnicalStaff("Davor Šuker", "Davor", "Coach", LocalDate.of(1968, 1, 1)));
		this.addTechnicalStaff(new TechnicalStaff("Zlatko Dalić", "Zlatko", "Trainer", LocalDate.of(1966, 10, 26)));
		this.setManager(new Manager("Louis van Gaal", "3851989876543", "3859921187654", "LouisGaal@hotmail.com"));
	}

	private void addPlayer(Player player) {
		if (player == null) {
			throw new IllegalArgumentException("Null player");
		}
		this.players.put(player.getNumber(), player);
		this.stats.addPlayer(player.getNumber()); // Add player to request counter
	}

	private void addTechnicalStaff(TechnicalStaff technicalStaff) {
		if (technicalStaff == null) {
			throw new IllegalArgumentException("Null technical staff");
		}
		this.technicalStaffs.add(technicalStaff);
	}

	private void setManager(Manager manager) {
		if (manager == null) {
			throw new IllegalArgumentException("Null manager");
		}
		this.manager = manager;
	}

	public int getHowManyMembers() {
		stats.incRequestCount();
		return players.size() + technicalStaffs.size()
		+ (manager != null ? 1 : 0);
	}

	public int getOldestPlayer() {
		stats.incRequestCount();
		int max = Integer.MIN_VALUE;
		int playerNumber = 0;
		for (Player p: players.values()) {
			if (p.getAge() > max) {
				max = p.getAge();
				playerNumber = p.getNumber();
			}
		}
		return playerNumber;
	}

	public int getYoungestPlayer() {
		stats.incRequestCount();
		int min = Integer.MAX_VALUE;
		int playerNumber = 0;
		for (Player p: players.values()) {
			if (p.getAge() < min) {
				min = p.getAge();
				playerNumber = p.getNumber();
			}
		}
		return playerNumber;
	}

	public double getAverageAge() {
		stats.incRequestCount();
		double sumAge = 0;
		for (Player p: players.values()) {
			sumAge += p.getAge();
		}
		return sumAge/players.size();
	}

	public String getPlayer(int number) {
		stats.incRequestCount();
		stats.incPlayerRequestCount(number);
		Player p = players.get(number);
		return p == null ? null : p.getDataJSON();
	}

	public String getPressOfficerContacts() {
		stats.incRequestCount();
		return manager == null ? null : manager.getDataJSON();
	}

	public String getCountryName() {
		stats.incRequestCount();
		return "Croacia";
	}

	public Image getFlagImage() {
		stats.incRequestCount();
		try {
		    BufferedImage image = ImageIO.read(getClass().getResource("/module_croacia/croacia.png"));
		    return image;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Path getTechnicalCommittee() {
		stats.incRequestCount();
		// TODO Auto-generated method stub
		return null;
	}

	public NationalTeamStats getStatsResponsible() {
		stats.incRequestCount();
		return stats;
	}

}
