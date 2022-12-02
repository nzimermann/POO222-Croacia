package module_croacia;

import fifa.NationalTeamStats;
import java.util.HashMap;

public class CroaciaStats implements NationalTeamStats {
	private HashMap<Integer, Integer> playerRequestCount = new HashMap<>();
	private int requestCount = 0;

	protected void addPlayer(int number) {
		playerRequestCount.putIfAbsent(number, 0);
	}

	protected void incRequestCount() {
		requestCount++;
	}

	protected void incPlayerRequestCount(int number) {
		if (playerRequestCount.containsKey(number)) {
			playerRequestCount.put(number, playerRequestCount.get(number) + 1);
		}
	}

	public int getHowManyQuestions() {
		return requestCount;
	}

	public int getHowManyCallsToPlayer(int number) {
		return playerRequestCount.get(number);
	}

}
