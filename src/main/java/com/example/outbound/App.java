package com.example.outbound;

import java.util.Map;
import java.util.UUID;

import com.vonage.client.VonageClient;
import com.vonage.client.voice.Call;
import com.vonage.client.voice.CallEvent;

public class App {

	// Replace these with your Vonage API credentials
	private static final String APP_ID = "XXXXXXXXXXXXXXXXXXX";
	private static final String PRIVATE_KEY = "XXXX.key";

	private static final String FROM = "14085551212";


	public static void main(String[] args) {
		VonageClient client = VonageClient.builder().applicationId(APP_ID).privateKeyPath(PRIVATE_KEY).build();
		String events = "https://XXX/vonage/events";

		Call call =
			    Call.builder()
		        .to(new SipEndpoint("sip:12345@XXXX", Map.of("User-To-User", UUID.randomUUID().toString())))
		        .from(FROM)
		        .eventUrl("https://XXX/vonage/events")
		        .answerUrl("https://XXX/vonage/answer")
				.build();


			CallEvent callEvent = client.getVoiceClient().createCall(call);
	}
}
