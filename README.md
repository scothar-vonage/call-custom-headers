# outbound-call-amd

This code places an outbound call to a phone number and then uses either TTS or streaming to play audio to the destination phone number.

## Create an Application
 * Create an Vonage [application](https://dashboard.nexmo.com/applications/new)
 * Give your application a name and click the "Generate public and private key" button. A private key will be downloaded to your computer.

<kbd>
<img src="https://github.com/scothar-vonage/outbound-call-amd/assets/121972661/e80f09f4-bc57-47b1-8cc7-a1eb8688b3e3" />

</kbd>


 * Copy the private key to your project's root directory.

Enable the Voice Capability and set the **Answer URL** to `www.example.com/calls/answer` and the **Event URL** to `www.example.com/calls/event`. (The URLs won't be used, so they don't have to point to a real destination).

<kbd>
  <img src="https://github.com/scothar-vonage/outbound-call-amd/assets/121972661/32af1f4c-2482-4675-af72-5e8885431843"/>
</kbd>

## Configure your credentials:
```java
private static final String APP_ID = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
private static final String PRIVATE_KEY = "outbound-calling.key";
```

## Set up the phone numbers
Set the `TO_NUMBER` and `VONAGE_NUMBER` variables:
```java
final Endpoint TO_NUMBER = new PhoneEndpoint("16505551212");
final String VONAGE_NUMBER = "14085551212";
```
## To enable TTS

Make sure this line is uncommented:
```java
TalkAction action = TalkAction.builder(
  "This is a text-to-speech call from Vonage. You will hear a lot more stuff, if you keep listening.")
	.build();
```

and comment out this line:
```java
StreamAction action = StreamAction.builder(MEDIA_URL).build();
```

## To Stream an MP3 file

1. Comment out the TalkAction line and uncomment the StreamAction line.
1. Set the MEDIA_URL variable to the location of your MP3 file.

## To Run the app

From a terminal window and navigate to the project's home directory and run:
```
mvn compile exec:java
```
