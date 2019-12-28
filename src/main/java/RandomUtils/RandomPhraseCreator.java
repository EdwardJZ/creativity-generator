package RandomUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.google.gson.GsonBuilder;

import generator.keyConstants.KeyConstants;
import generator.keyConstants.MajorMinorEnum;
import generator.payload.FineTuning;
import generator.payload.Payload;

public class RandomPhraseCreator {
	private static final int maxNotesInARow = 6;
	private static final int maxRestsInARow = 3;
	private static final int maxMeasures = 6;
	private static final int minMeasures = 2;
	private static final int min = 1;
	private static final int maxNotesPerBeat = 4;
	private static final int maxBeatsPerMeasure = 4;

	private Payload parameters;
	private List<String> choices;
	private Random random;

	private RandomPhraseCreator(Payload payload, List<String> choices) {
		this.parameters = payload;
		this.choices = choices;
		this.random = new Random();
	}

	public static RandomPhraseCreator getInstance(Payload payload, List<String> choices) {
		return new RandomPhraseCreator(payload, choices);
	}

	private void create() {
		int numMeasures = parameters.getMeasures();
		int maxRepeatedNotes = parameters.getFineTuning().getMaxRepeatedNote();
		int maxNumOfRests = parameters.getFineTuning().getMaxNumOfRestsInSuccession();

		int length = numMeasures * maxBeatsPerMeasure;

		int[] progression = new int[length];

		for (int i = 0; i < length; i++) {
			int thisRandom = (random.nextInt((maxRepeatedNotes - 0) + 1) + 0);
			if (i >= maxNumOfRests + 1) {
				if (thisRandom == 0) {
					if (shouldChooseAgain(progression, i, maxNumOfRests)) {
						boolean stopChoosing = false;
						while (!stopChoosing) {
							thisRandom = random.nextInt((maxRepeatedNotes - 0) + 1);
							if (thisRandom != 0) {
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

	public void createRandomPhrase() {
		create();
	}

	public static Payload createRandomPayload(String type) {
		Payload p = new Payload();
		Random random = new Random();
		p.setKey(KeyConstants.getRandomKey());
		p.setMajor(MajorMinorEnum.getRandomMajorMinor());
		p.setNotesOrChords(type);
		p.setMeasures(random.nextInt((maxMeasures - minMeasures) + 1) + minMeasures);

		FineTuning ft = new FineTuning();
		ft.setIncludeRests(MajorMinorEnum.getRandomMajorMinor());
		ft.setMaxNumOfRestsInSuccession(random.nextInt(maxRestsInARow) + 1);
		ft.setMaxRepeatedNote(random.nextInt(maxNotesInARow) + 1);
		ft.setNumOfOctavesInRange(1);

		p.setFineTuning(ft);

		System.out.println(new GsonBuilder().serializeNulls().create().toJson(p));
		return p;
	}

	private boolean shouldChooseAgain(int[] progression, int index, int max) {

		StringBuilder sb = new StringBuilder();
		boolean allZeros = true;
		for (int i = index - 1; i > index - max - 1; i--) {
			sb.append(progression[i] + ", ");
			if (progression[i] != 0) {
				allZeros = false;
			}
		}
		return allZeros;
	}

//	public static void main(String[] args) {
//
//		for(int i = 0; i < 20; i++) {
//			System.out.println("=====================================================================================");
//			RandomPhraseCreator.getInstance(RandomPhraseCreator.createRandomPayload("chords"), null).createRandomPhrase();
//
//		}
//	}

}
