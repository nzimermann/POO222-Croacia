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

	private void addPlayer(Player player) {
		if (player == null) {
			throw new IllegalArgumentException("Null player");
		}
		this.players.put(player.getNumber(), player);
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
		return players.size() + technicalStaffs.size()
		+ (manager != null ? 1 : 0);
	}

	public int getOldestPlayer() {
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
		double sumAge = 0;
		for (Player p: players.values()) {
			sumAge += p.getAge();
		}
		return sumAge/players.size();
	}

	public String getPlayer(int number) {
		Player p = players.get(number);
		return p == null ? null : p.getDataJSON();
	}

	public String getPressOfficerContacts() {
		return manager == null ? null : manager.getDataJSON();
	}

	public String getCountryName() {
		return "Croacia";
	}

	public Image getFlagImage() {
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
		// TODO Auto-generated method stub
		return null;
	}

	public NationalTeamStats getStatsResponsible() {
		return stats;
	}

}
