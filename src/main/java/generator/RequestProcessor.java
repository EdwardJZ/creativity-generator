package generator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import RandomUtils.SuccessiveTones;
import generator.keyConstants.ChordExtractor;
import generator.keyConstants.ChordExtractor.ChordsInKeyOf;
import generator.keyConstants.MajorMinorEnum;
import generator.keyConstants.NoteExtractor;
import generator.keyConstants.NoteExtractor.NotesInKeyOf;
import generator.payload.FineTuning;
import generator.payload.Payload;

public class RequestProcessor {

	public static RequestProcessor getInstance() {
		return new RequestProcessor();
	}

	public Response process(Payload payload) {
		List<String> chordChoices = getProgression(payload);

		Map<String, String> musicalPhrase = new HashMap<String, String>();

		Response response = new Response();
		return response;
	}

	private List<String> getProgression(Payload payload) {
		if (payload.getNotesOrChords().equals("chords")) {
			return ChordExtractor.getInstance(ChordsInKeyOf.valueOf(payload.getKey()),
					MajorMinorEnum.getType(payload.isMajor()), payload).extractChords();

		} else {
			return NoteExtractor
					.getInstance(NotesInKeyOf.valueOf(payload.getKey()), MajorMinorEnum.getType(payload.isMajor()))
					.extractNotes();
		}

	}

	public static void main(String[] args) {
		Payload p = new Payload();
		p.setKey("C");
		p.setMajor(true);
		p.setNotesOrChords("notes");

		FineTuning ft = new FineTuning();
		ft.setIncludeRests(true);
		ft.setMaxNumOfRestsInSuccession(2);
		ft.setMaxRepeatedNote(4);
		ft.setNumOfOctavesInRange(1);

		p.setFineTuning(ft);
		RequestProcessor.getInstance().process(p);
	}
}
