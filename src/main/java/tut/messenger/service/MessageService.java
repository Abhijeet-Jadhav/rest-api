package tut.messenger.service;

import tut.messenger.database.DatabaseClass;
import tut.messenger.model.JsonMsg;
import tut.messenger.model.Message;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Map;

public class MessageService {

	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService() {
		messages.put(1L, new Message(1, "Hello World", "abhijeet"));
		messages.put(2L, new Message(2, "Hello Jersey", "abhijeet"));
	}
	
	
	public Response getAllMessages()  {
        //List<Message> msgs = new ArrayList<Message>(messages.values());
        JsonMsg msgs = new JsonMsg();
        msgs.setMessages(new ArrayList<>(messages.values()));
        return Response.status(200).entity(msgs).build();
    }
	
	public Message getMessage(long id) {
		return messages.get(id);
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
	

	
	
	
}
