/* Copyright 2024 eLocal*/
package com.example.outbound;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vonage.client.JsonableBaseObject;
import com.vonage.client.voice.Endpoint;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SipEndpoint extends JsonableBaseObject implements Endpoint {
  private static final String TYPE = "sip";
  private String uri;
  private Map<String, ?> headers;

  protected SipEndpoint() {}

  public SipEndpoint(String uri, Map<String, ?> headers) {
    this.uri = uri;
    this.headers = headers;
  }

  @JsonProperty("uri")
  public String getUri() {
    return this.uri;
  }

  @JsonProperty("type")
  public String getType() {
    return TYPE;
  }

  @JsonProperty("headers")
  public Map<String, ?> getHeaders() {
    return this.headers;
  }

  public String toLog() {
    return this.uri;
  }
}
