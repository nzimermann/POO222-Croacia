package module_croacia;

import java.awt.Image;
import java.nio.file.Path;
import fifa.NationalTeamInfos;
import fifa.NationalTeamStats;
import java.util.HashMap;
import java.util.ArrayList;

public class Croacia implements NationalTeamInfos {
	private HashMap<Integer, Player> players = new HashMap<Integer, Player>();
	private ArrayList<TechnicalStaff> technicallStaffs = new ArrayList<TechnicalStaff>();
	private Manager manager;

	public int getHowManyMembers() {
		int mgr = 0;
		if (manager != null) {mgr = 1;}
		return players.size() + technicallStaffs.size() + mgr;
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
		return players.get(number).getDataJSON();
	}

	public String getPressOfficerContacts() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCountryName() {
		return manager.getDataJSON();
	}

	public Image getFlagImage() {
		// TODO Auto-generated method stub
		return null;
	}

	public Path getTechnicalCommittee() {
		// TODO Auto-generated method stub
		return null;
	}

	public NationalTeamStats getStatsResponsible() {
		// TODO Auto-generated method stub
		return null;
	}

}
