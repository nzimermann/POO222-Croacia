package module_croacia;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.file.Path;
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
		inicialize();
	}

	@SuppressWarnings("unchecked")
	private void inicialize() {
		try (InputStream is = getClass().getResourceAsStream("/module_croacia/CroaciaData.obj");
			 ObjectInputStream ois = new ObjectInputStream(is)) {
			
			players = (HashMap<Integer, Player>) ois.readObject();
			technicalStaffs = (ArrayList<TechnicalStaff>) ois.readObject();
			manager = (Manager) ois.readObject();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
		Player p = players.get(number);
		if (p != null) {
			stats.incPlayerRequestCount(number);
			return p.getDataJSON();
		}
		return null;
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
		    BufferedImage image = ImageIO.read(getClass().getResourceAsStream("/module_croacia/croacia.png"));
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
		String technicalCommittee = "";
		for (TechnicalStaff t: technicalStaffs) {
			technicalCommittee += t.getDataJSON()+",\n";
		}

		// Removes the last comma
		technicalCommittee = technicalCommittee.substring(0, technicalCommittee.length()-2);

		try {
			File f = new File("TechnicalCommittee.json");
			FileWriter fw = new FileWriter(f.getPath());
			fw.write(technicalCommittee);
			fw.close();
			return f.toPath();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public NationalTeamStats getStatsResponsible() {
		return stats;
	}

}
