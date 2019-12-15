package generator.payload;

public class FineTuning {
	private int maxRepeatedNote;
	private int numOfOctavesInRange;
	private boolean includeRests;
	private int maxNumOfRestsInSuccession;

	public int getMaxRepeatedNote() {
		return maxRepeatedNote;
	}

	public void setMaxRepeatedNote(int maxRepeatedNote) {
		this.maxRepeatedNote = maxRepeatedNote;
	}

	public int getNumOfOctavesInRange() {
		return numOfOctavesInRange;
	}

	public void setNumOfOctavesInRange(int numOfOctavesInRange) {
		this.numOfOctavesInRange = numOfOctavesInRange;
	}

	public boolean isIncludeRests() {
		return includeRests;
	}

	public void setIncludeRests(boolean includeRests) {
		this.includeRests = includeRests;
	}

	public int getMaxNumOfRestsInSuccession() {
		return maxNumOfRestsInSuccession;
	}

	public void setMaxNumOfRestsInSuccession(int maxNumOfRestsInSuccession) {
		this.maxNumOfRestsInSuccession = maxNumOfRestsInSuccession;
	}

}
