package generator.keyConstants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import generator.keyConstants.MajorMinorEnum.Type;
import generator.payload.Payload;

public class ChordExtractor {
	
	private ChordsInKeyOf chordKey;
	private Type majorMinor;
	private Payload parmeters;
	
	private ChordExtractor(ChordsInKeyOf chordKey, Type majorMinor, Payload p) {
		this.chordKey = chordKey;
		this.majorMinor = majorMinor;
		this.parmeters = p;
	}
	
	public static ChordExtractor getInstance(ChordsInKeyOf chordKey, Type majorMinor, Payload p) {
		return new ChordExtractor(chordKey, majorMinor, p);
	}

	public enum ChordsInKeyOf {
		C, D_FLAT, C_SHARP, D, E_FLAT, F, G_FLAT, F_SHARP, G, A_FLAT, A, B_FLAT, B, C_FLAT
	}
	
	public enum MajorMinor {
		MAJOR, MINOR
	}
	
	public List<String> extractChords() {
		List<String> chords = null;;
		switch(majorMinor) {
		case MAJOR:
			chords = getMajorChords();
			break;
		case MINOR:
			chords = getMinorChords();
		}
		return chords;
	}
	
	private List<String> getMajorChords(){
		String chords = null;
		switch(chordKey) {
		case C:
			chords = MajorChords.C;
		}
		
		return Arrays.asList(chords.split(", "));
	}
	
	private List<String> getMinorChords(){
		return null;
	}
}
