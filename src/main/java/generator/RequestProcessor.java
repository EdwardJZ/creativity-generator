package generator;

import generator.payload.Payload;

public class RequestProcessor {

	public static RequestProcessor getInstance() {
		return new RequestProcessor();
	}

	public Response process(Payload payload) {
		
		
		Response response = new Response();
		return response;
	}

}
