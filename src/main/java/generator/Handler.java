package generator;

import org.apache.http.HttpStatus;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import generator.payload.Payload;

public class Handler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

	public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent event, Context context) {
		final Gson gson = new GsonBuilder().serializeNulls().create();

		APIGatewayProxyResponseEvent respEvent = new APIGatewayProxyResponseEvent();
		Payload payload = gson.fromJson(event.getBody(), Payload.class);
		
		try {
			Response response = RequestProcessor.getInstance().process(payload);
			respEvent = ResponseProcessor.createResponse(HttpStatus.SC_OK, gson.toJson(payload));
		} catch (Exception e) {
			respEvent = ResponseProcessor.createResponse(HttpStatus.SC_INTERNAL_SERVER_ERROR,
					gson.toJson(new ErrorMessage(e.getMessage())));
		}
		
		return respEvent;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		Gson gson = new Gson();
		String payload = "{\r\n" + 
				"    \"notesOrChords\": \"notes\",\r\n" + 
				"    \"random\":false,\r\n" + 
				"    \"key\":\"A\",\r\n" + 
				"    \"major\":false,\r\n" + 
				"    \"measures\": 4,\r\n" + 
				"    \"fineTuning\": {\r\n" + 
				"        \"maxRepeatedNote\":4,\r\n" + 
				"        \"numOfOctavesInRange\":2,\r\n" + 
				"        \"includeRests\": true,\r\n" + 
				"        \"maxNumOfRestsInSuccession\":2\r\n" + 
				"    }\r\n" + 
				"}";
		
		Payload p = gson.fromJson(payload, Payload.class);
		
		System.out.println(gson.toJson(p));
	}
}
