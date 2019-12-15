package generator.keyConstants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import generator.keyConstants.MajorMinorEnum.Type;

public class ChordExtractor {
	
	ChordsInKeyOf chordKey;
	Type majorMinor;
	private ChordExtractor(ChordsInKeyOf chordKey, Type majorMinor) {
		this.chordKey = chordKey;
		this.majorMinor = majorMinor;
	}
	
	public static ChordExtractor getInstance(ChordsInKeyOf chordKey, Type majorMinor) {
		return new ChordExtractor(chordKey, majorMinor);
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
