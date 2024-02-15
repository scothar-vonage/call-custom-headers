# outbound-call-amd

This code places an outbound call to a SIP Endpoint and passes custom headers.

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
private static final String PRIVATE_KEY = "XXXXX.key";
```

## Set up the phone numbers
Set the `FROM` variable:
```java
private static final String FROM = "XXXXX";
```


## To Run the app

Open a terminal window and navigate to the project's home directory and run:
```
mvn compile exec:java
```
