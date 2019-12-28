package RandomUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import generator.payload.FineTuning;
import generator.payload.Payload;

public class RandomPhraseCreator {
	private final int maxNotesInARow = 6;
	private final int maxMeasures = 4;
	private final int min = 1;
	private final int maxNotesPerBeat = 4;
	private final int maxBeatsPerMeasure = 4;
	
	private Payload parameters;
	private List<String> choices;
	private Random random;

	private RandomPhraseCreator(Payload payload, List<String> choices) {
		this.parameters = payload;
		this.choices = choices;
		this.random = new Random();
	}

	public static RandomPhraseCreator getInstance(Payload payload, List<String> choices) {
		System.out.println("==================================");
		return new RandomPhraseCreator(payload, choices);
	}
	
	private void create() {
		int numMeasures = parameters.getMeasures();
		int maxRepeatedNotes = parameters.getFineTuning().getMaxRepeatedNote();
		int maxNumOfRests = parameters.getFineTuning().getMaxNumOfRestsInSuccession();
		
		int length = numMeasures * maxBeatsPerMeasure;
		
		int[] progression = new int[length];
		
		for(int i = 0; i < length; i++) {
			int thisRandom = (random.nextInt((maxRepeatedNotes - 0) + 1) + 0);
			if(i >= maxNumOfRests + 1) {
				if(thisRandom == 0) {
					if(shouldChooseAgain(progression, i, maxNumOfRests)) {
						boolean stopChoosing = false;
						while(! stopChoosing) {
							thisRandom = random.nextInt((maxRepeatedNotes - 0) + 1);
							System.out.println("Changing to ==> " + thisRandom);
							if(thisRandom != 0) {
								stopChoosing = true;
							}
						}
						
					}
				}
			}
			progression[i] = thisRandom;
		}
		System.out.println(Arrays.toString(progression));
	}
	
	private boolean shouldChooseAgain(int[] progression, int index, int max) {

		StringBuilder sb = new StringBuilder();
		boolean allZeros = true;
		for(int i = index - 1; i > index - max - 1; i--) {
			sb.append(progression[i] + ", ");
			if(progression[i] != 0) {
				allZeros = false;
			}
		}
		if(allZeros == true) {
			System.out.println("Index       ===> " + index);
			System.out.println("Max         ===> " + max);
			System.out.println("Progression ===> " + Arrays.toString(progression));
			System.out.println("Checked ===> " + sb.toString());
			System.out.println("All Zeros? ===> " + allZeros);
		}
		return allZeros;
	}
	
	public void createProgression() {
		int numOfMeasures = random.nextInt((maxMeasures - min) + 1) + min;
		int numOfNotesInRow = random.nextInt((maxNotesInARow - min) + 1) + min;
		List<String[]> phrase = new ArrayList<String[]>();
		for(int i = 0; i < numOfMeasures * maxBeatsPerMeasure; i++) {
		
		}

	}
	
	private int chooseRandomNoteOrChord(List<String> choices) {
		int choice = random.nextInt(((choices.size()) - 1) + 1);

		return choice;
	}
	public static void main(String[] args) {
		Payload p = new Payload();
		p.setKey("C");
		p.setMajor(true);
		p.setNotesOrChords("chords");
		p.setMeasures(4);

		FineTuning ft = new FineTuning();
		ft.setIncludeRests(true);
		ft.setMaxNumOfRestsInSuccession(2);
		ft.setMaxRepeatedNote(4);
		ft.setNumOfOctavesInRange(1);

		p.setFineTuning(ft);
		List<String> l = new ArrayList<String>();
		
		l.add("C");
		l.add("D");
		l.add("E");
		l.add("F");
		l.add("G");
		l.add("A");
		l.add("B");
		l.add("C");
		
			for(int i = 0; i < 100; i++) {
				RandomPhraseCreator.getInstance(p, l).create();
			}
			

		
	}

}
