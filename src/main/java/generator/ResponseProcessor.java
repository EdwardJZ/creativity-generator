package generator;

import org.apache.http.HttpStatus;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

public class ResponseProcessor {
	
	private static APIGatewayProxyResponseEvent getEventResponse(int statusCode, String payload) {
		APIGatewayProxyResponseEvent resp = new APIGatewayProxyResponseEvent();
		resp.setIsBase64Encoded(false);
		resp.setBody(payload);
		resp.setStatusCode(statusCode);
		return new APIGatewayProxyResponseEvent();
	}
	
	public static APIGatewayProxyResponseEvent createResponse(int statusCode, String payload) {		
		return getEventResponse(HttpStatus.SC_OK, payload);
	}


}
