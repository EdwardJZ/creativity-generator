package generator.payload;

public class Payload {

	private String notesOrChords;
	private boolean random;
	private String key;
	private boolean major;
	private int measures;
	private FineTuning fineTuning;

	public boolean isRandom() {
		return random;
	}

	public void setRandom(boolean random) {
		this.random = random;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public boolean isMajor() {
		return major;
	}

	public void setMajor(boolean major) {
		this.major = major;
	}

	public int getMeasures() {
		return measures;
	}

	public void setMeasures(int measures) {
		this.measures = measures;
	}

	public String getNotesOrChords() {
		return notesOrChords;
	}

	public void setNotesOrChords(String notesOrChords) {
		this.notesOrChords = notesOrChords;
	}

	public FineTuning getFineTuning() {
		return fineTuning;
	}

	public void setFineTuning(FineTuning fineTuning) {
		this.fineTuning = fineTuning;
	}
	
	
}
