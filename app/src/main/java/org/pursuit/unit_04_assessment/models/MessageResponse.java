package org.pursuit.unit_04_assessment.models;

import java.util.List;

public class MessageResponse {
    private List <Message>message;

    public List<Message> getMessage() {
        return message;
    }

    public MessageResponse(List<Message> message) {
        this.message = message;
    }
}
