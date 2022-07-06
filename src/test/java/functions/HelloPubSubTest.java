package functions;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;

public class HelloPubSubTest {
    private HelloPubSub sampleUnderTest;

    @BeforeEach
    public void setUp() {
        sampleUnderTest = new HelloPubSub();
    }

    @Test
    public void testHelloPubsub() throws Exception {
        PubSubCustomMessage message = new PubSubCustomMessage();
        String encodedMessage = Base64.getEncoder().encodeToString("""
                {"name": "test"}""".getBytes(StandardCharsets.UTF_8));
        System.out.println(new ObjectMapper().writeValueAsString(Map.of("data", Map.of("data", encodedMessage))));
        sampleUnderTest.accept(message, null);
    }
}