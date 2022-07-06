package functions;

import java.util.Map;

public class PubSubCustomMessage {
    private Map<String, String> attributes;
    private String data;
    private String messageID;
    private String publishTime;

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> value) {
        this.attributes = value;
    }

    public String getData() {
        return data;
    }

    public void setData(String value) {
        this.data = value;
    }

    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String value) {
        this.messageID = value;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String value) {
        this.publishTime = value;
    }
}