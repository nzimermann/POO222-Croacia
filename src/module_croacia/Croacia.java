package module_croacia;

import java.awt.Image;
import java.nio.file.Path;
import fifa.NationalTeamInfos;
import fifa.NationalTeamStats;
// import java.util.HashMap;
// import java.util.ArrayList;


public class Croacia implements NationalTeamInfos {
	// private HashMap<Integer, Player> players = new HashMap<Integer, Player>();
	// private ArrayList<TechnicalStaff> technicallStaffs = new ArrayList<TechnicalStaff>();
	// private Manager manager;

	public int getHowManyMembers() {
		return 14;
	}

	public int getOldestPlayer() {
		return 9;
	}

	public int getYoungestPlayer() {
		return 3;
	}

	public double getAverageAge() {
		return 27.5d;
	}

	public String getPlayer(int number) {
		return "{number:,"+number+", name:\"Alisson Ramses Becker\", nickname:\"Alisson\", height:191, weight:91.2, birthDate:\"1992-10-02\", position:\"goalkeeper\", currentClub:\"Liverpool\"}";
	}

	public String getPressOfficerContacts() {
		return "{name:\"Paulo Castro Soares\", tel1:\"+5521989876543\", tel2:\"+974992008765\", emailAccount:\"pcsoares@cbf.com.br\"}";
	}

	public String getCountryName() {
		return "Croacia";
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
