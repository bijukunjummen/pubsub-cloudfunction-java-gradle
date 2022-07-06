package functions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.functions.BackgroundFunction;
import com.google.cloud.functions.Context;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.logging.Logger;

public class HelloPubSub implements BackgroundFunction<PubSubCustomMessage> {
    private static final Logger LOGGER = Logger.getLogger(HelloPubSub.class.getName());
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final String NAME_FIELD = "name";

    @Override
    public void accept(PubSubCustomMessage message, Context context) throws Exception {
        String name = extractName(message);
        LOGGER.info(String.format("Received and processed: %s!", name));
        return;
    }

    private String extractName(PubSubCustomMessage message) throws JsonProcessingException {
        if (message != null && message.getData() != null) {
            String rawJson = new String(Base64.getDecoder()
                    .decode(message.getData().getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
            JsonNode jsonNode = objectMapper.readTree(rawJson);

            if (jsonNode != null && jsonNode.has(NAME_FIELD)) {
                return jsonNode.get(NAME_FIELD).asText();
            }
        }
        return "";
    }
}