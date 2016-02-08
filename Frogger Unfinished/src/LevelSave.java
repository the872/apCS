 import java.util.ArrayList;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;


public class LevelSave {
	
	private ArrayList<String> names = new ArrayList<String>();
	private ArrayList<Integer> scores = new ArrayList<Integer>();
	
	public ArrayList<String> getNames()
	{
		return names;
	}
	
	public ArrayList<Integer> getScores()
	{
		return scores;
	}
	
	public void addScore(int score, String name) {
		
		names.add(name);
		scores.add(score);
		
		//leave this line alone
		savePrefs();
	}
	
	public void savePrefs() {
		Preferences prefs = Preferences.userRoot();
		for(int i = 0; i < scores.size(); i++) {
			prefs.putInt("Place" + i, scores.get(i));
			prefs.put("Name" + i, names.get(i));
		}
		
		try {
			prefs.flush();
		} catch (BackingStoreException e) {
			e.printStackTrace();
		}
	}
	
	public void loadPrefs() {
		Preferences prefs = Preferences.userRoot();
		for(int i = 0; i < 10; i++) {
			if(prefs.get("Name" +i, null) != null) {
				scores.add(prefs.getInt("Place"+i, 0));
				names.add(prefs.get("Name"+i, "Unknown"));
			}
		}
	}
	
	public void clearPrefs() {
		
		scores.clear();
		names.clear();
		
		Preferences prefs = Preferences.userRoot();
		try {
			prefs.clear();
		} catch (BackingStoreException e) {
			e.printStackTrace();
		}
	}
	
	
}
