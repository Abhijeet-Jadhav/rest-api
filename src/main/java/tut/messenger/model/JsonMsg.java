package tut.messenger.model;

import java.util.List;

/**
 * Created by root on 1/13/17.
 */
public class JsonMsg {
    final String msg = "messages";
    List<Message> messages ;

    public JsonMsg() {

    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
