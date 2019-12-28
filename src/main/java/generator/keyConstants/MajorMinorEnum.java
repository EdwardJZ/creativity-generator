package generator.keyConstants;

import java.util.Random;

public class MajorMinorEnum {

	public enum Type {
		MAJOR, MINOR

	}
	
	public static Type getType(boolean isMajor) {
		if(isMajor) {
			return Type.MAJOR;
		}else {
			return Type.MINOR;
		}
		
	}
	
	public static boolean getRandomMajorMinor() {
		return new Random().nextInt(2) == 1;
	}

}

