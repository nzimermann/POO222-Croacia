package module_croacia;

import fifa.NationalTeamStats;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

@SuppressWarnings("serial")
public class CroaciaStats implements NationalTeamStats, Serializable {
	private HashMap<Integer, Integer> playerRequestCount = new HashMap<>();
	private int requestCount = 0;

	@SuppressWarnings("unchecked")
	public CroaciaStats() {
		try (FileInputStream fis = new FileInputStream("CroaciaStats.obj");
			 ObjectInputStream ois = new ObjectInputStream(fis)) {
			requestCount = (int) ois.readObject();
			playerRequestCount = (HashMap<Integer, Integer>) ois.readObject();
		} catch (FileNotFoundException e) {
			saveStats();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (ClassCastException e) {}
	}
	
	private void saveStats() {
		try (FileOutputStream fos = new FileOutputStream("CroaciaStats.obj");
			 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(requestCount);
			oos.writeObject(playerRequestCount);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	protected void incRequestCount() {
		requestCount++;
		saveStats();
	}

	protected void incPlayerRequestCount(int number) {
		if (playerRequestCount.containsKey(number)) {
			playerRequestCount.put(number, playerRequestCount.get(number) + 1);
		} else {
			playerRequestCount.put(number, 1);
		}
		saveStats();
	}

	public int getHowManyQuestions() {
		return requestCount;
	}

	public int getHowManyCallsToPlayer(int number) {
		return playerRequestCount.containsKey(number) ? playerRequestCount.get(number) : 0; 
	}

}
