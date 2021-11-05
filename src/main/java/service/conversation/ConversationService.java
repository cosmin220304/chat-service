package service.conversation;

import models.Conversation;

import java.util.List;

public interface ConversationService {
   Conversation createConversation(String participant1, String participant2);
   Conversation readConversation(String conversationId);
   Conversation readConversation(String participant1, String participant2);
   Conversation updateConversation(String conversationId);
   Conversation updateConversation(String participant1, String participant2);
   List<Conversation> listConversation(String user);
}
