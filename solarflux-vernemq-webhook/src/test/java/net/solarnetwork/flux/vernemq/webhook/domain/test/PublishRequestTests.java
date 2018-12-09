
package net.solarnetwork.flux.vernemq.webhook.domain.test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.solarnetwork.flux.vernemq.webhook.domain.PublishRequest;
import net.solarnetwork.flux.vernemq.webhook.domain.Qos;
import net.solarnetwork.flux.vernemq.webhook.test.JsonUtils;
import net.solarnetwork.flux.vernemq.webhook.test.TestSupport;

/**
 * Test cases for the {@link PublishRequest} class.
 * 
 * @author matt
 */
public class PublishRequestTests extends TestSupport {

  private ObjectMapper objectMapper;

  @Before
  public void setup() {
    objectMapper = JsonUtils.defaultObjectMapper();
  }

  @Test
  public void parseFull() throws IOException {
    PublishRequest req = objectMapper.readValue(classResourceAsBytes("auth_on_publish-01.json"),
        PublishRequest.class);
    assertThat("client_id", req.getClientId(), equalTo("clientid"));
    assertThat("mountpoint", req.getMountpoint(), equalTo(""));
    assertThat("payload", Arrays.equals(req.getPayload(), "hello".getBytes("UTF-8")),
        equalTo(true));
    assertThat("qos", req.getQos(), equalTo(Qos.AtLeastOnce));
    assertThat("retain", req.getRetain(), equalTo(false));
    assertThat("topic", req.getTopic(), equalTo("a/b"));
    assertThat("username", req.getUsername(), equalTo("username"));
  }

}
