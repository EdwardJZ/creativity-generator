package generator.keyConstants;

import java.util.Arrays;
import java.util.List;

import generator.keyConstants.ChordExtractor.MajorMinor;
import generator.keyConstants.MajorMinorEnum.Type;

public class NoteExtractor {

	NotesInKeyOf notes;
	Type majorMinor;

	private NoteExtractor(NotesInKeyOf notes, Type majorMinor) {
		this.notes = notes;
		this.majorMinor = majorMinor;
	}

	public static NoteExtractor getInstance(NotesInKeyOf notes, Type majorMinor) {
		return new NoteExtractor(notes, majorMinor);
	}

	public enum NotesInKeyOf {
		C, D_FLAT, C_SHARP, D, E_FLAT, F, G_FLAT, F_SHARP, G, A_FLAT, A, B_FLAT, B, C_FLAT
	}
	
	public enum MajorMinor {
		MAJOR, MINOR
	}

	public List<String> extractNotes() {
		List<String> notes = null;;
		switch(majorMinor) {
		case MAJOR:
			notes = getMajorNotes();
			break;
		case MINOR:
			//notes = getMinorNotes();
		}
		return notes;
	}
	
	private List<String> getMajorNotes(){
		String notesList = null;
		switch(notes) {
		case C:
			notesList = MajorNotes.C;
			break;
			
		}
		
		return Arrays.asList(notesList.split(", "));
	}

}
