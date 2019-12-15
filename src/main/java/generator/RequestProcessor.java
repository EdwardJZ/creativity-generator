package generator;

import java.util.List;

import com.google.gson.Gson;

import generator.keyConstants.ChordExtractor;
import generator.keyConstants.ChordExtractor.ChordsInKeyOf;
import generator.keyConstants.MajorMinorEnum;
import generator.keyConstants.NoteExtractor;
import generator.keyConstants.NoteExtractor.NotesInKeyOf;
import generator.payload.Payload;

public class RequestProcessor {

	public static RequestProcessor getInstance() {
		return new RequestProcessor();
	}

	public Response process(Payload payload) {
		List<String> tones = null;
		if (payload.getNotesOrChords().equals("chords")) {
			tones = ChordExtractor
					.getInstance(ChordsInKeyOf.valueOf(payload.getKey()), MajorMinorEnum.getType(payload.isMajor()))
					.extractChords();
			
		} else {
			tones = NoteExtractor.getInstance(NotesInKeyOf.valueOf(payload.getKey()),
					MajorMinorEnum.getType(payload.isMajor())).extractNotes();
		}

		Response response = new Response();
		return response;
	}

		public static void main(String[] args) {
			Payload p = new Payload();
			p.setKey("C");
			p.setMajor(true);
			p.setNotesOrChords("notes");
			RequestProcessor.getInstance().process(p);
		}
}
