package service.chat;

import lombok.NonNull;
import models.Conversation;
import models.Message;
import service.conversation.ConversationService;
import service.conversation.ConversationServiceImpl;
import service.message.MessageService;
import service.message.MessageServiceImpl;

import java.util.List;

public class ChatServiceImpl implements ChatService{

    private final ConversationService conversationService;
    private final MessageService messageService;

    public ChatServiceImpl() {
        this.conversationService = new ConversationServiceImpl();
        this.messageService = new MessageServiceImpl();
    }

    @Override
    public List<Conversation> getConversationByUserId(@NonNull String userId) {
        return null;
    }

    @Override
    public List<Conversation> getConversationById(@NonNull String conversationId) {
        return null;
    }

    @Override
    public Conversation getConversationBetweenUsers(@NonNull String user1, @NonNull String user2) {
        return null;
    }

    @Override
    public Message sendMessage(@NonNull String conversationId, @NonNull String message) {
        return null;
    }

    @Override
    public Message readMessages(@NonNull String conversationId, Integer offset, Integer limit) {
        return null;
    }
}
