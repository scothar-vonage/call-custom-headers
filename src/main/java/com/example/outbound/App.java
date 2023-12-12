package com.example.outbound;

import com.vonage.client.VonageClient;
import com.vonage.client.voice.AdvancedMachineDetection;
import com.vonage.client.voice.AdvancedMachineDetection.Mode;
import com.vonage.client.voice.Call;
import com.vonage.client.voice.CallEvent;
import com.vonage.client.voice.Endpoint;
import com.vonage.client.voice.MachineDetection;
import com.vonage.client.voice.PhoneEndpoint;
import com.vonage.client.voice.VoiceClient;
import com.vonage.client.voice.ncco.StreamAction;
import com.vonage.client.voice.ncco.TalkAction;

public class App {

	// Replace these with your Vonage API credentials
	private static final String APP_ID = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
	private static final String PRIVATE_KEY = "outbound-calling.key";

	public static void main(String[] args) {

		final Endpoint TO_NUMBER = new PhoneEndpoint("16505551212");
		final String VONAGE_NUMBER = "14085551212";

		final String MEDIA_URL = "https://test-audio-streams.s3.amazonaws.com/countTo20.mp3";

		VonageClient client = VonageClient.builder().applicationId(APP_ID).privateKeyPath(PRIVATE_KEY).build();

		VoiceClient voiceClient = client.getVoiceClient();

		/*
		 * Uncomment this line to use TTS, instead of streaming an mp3 file. Make sure
		 * you comment the StreamAction line, if you use TTS
		 */
		TalkAction action = TalkAction.builder(
				"This is a text-to-speech call from Vonage. You will hear a lot more stuff, if you keep listening.")
				.build();

		/*
		 * Uncomment this line to stream an mp3 file. Make sure you comment the 
		 * TalkAction line, above, if you stream uncomment the StreamAction line
		 */
		// StreamAction action = StreamAction.builder(MEDIA_URL).build();

		AdvancedMachineDetection amd = AdvancedMachineDetection.builder().behavior(MachineDetection.CONTINUE)
				.mode(Mode.DETECT_BEEP).beepTimeout(45).build();

		Call call = Call.builder().to(TO_NUMBER).from(VONAGE_NUMBER).ncco(action).advancedMachineDetection(amd).build();

		System.out.println("Making call with AMD");
		CallEvent e = voiceClient.createCall(call);
		System.out.println(e.toJson());

	}
}
