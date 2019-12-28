package generator.keyConstants;

import java.lang.reflect.Field;
import java.util.Random;

public class KeyConstants {

	public static final String C = "C";
	public static final String D_FLAT = "D_FLAT";
	public static final String C_SHARP = "C_SHARP";
	public static final String D = "D";
	public static final String E_FLAT = "E_FLAT";
	public static final String F = "F";
	public static final String G_FLAT = "G_FLAT";
	public static final String F_SHARP = "F_SHARP";
	public static final String G = "G";
	public static final String A_FLAT = "A_FLAT";
	public static final String A = "A";
	public static final String B_FLAT = "B_FLAT";
	public static final String B = "B";
	public static final String C_FLAT = "C_FLAT";

	public static String getRandomKey() {
		Field[] fields = KeyConstants.class.getDeclaredFields();
		return fields[new Random().nextInt(fields.length)].getName();
	}

}
