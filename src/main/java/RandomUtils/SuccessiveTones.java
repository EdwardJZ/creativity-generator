package RandomUtils;

import java.util.Random;

import generator.payload.FineTuning;

public class SuccessiveTones {

	private Random random;
	private int maxInARow;
	private int min;

	private SuccessiveTones(FineTuning parameters) {
		this.maxInARow = parameters.getMaxRepeatedNote();
		this.random = new Random();
		this.min = parameters.isIncludeRests() ? 0 : 1;
	}

	public static SuccessiveTones getInstance(FineTuning parameters) {
		return new SuccessiveTones(parameters);
	}
	
	public int getRandom() {
		return random.nextInt((maxInARow - min) + 1) + min;
	}
	
}
