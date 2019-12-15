package generator.keyConstants;

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

	
}

