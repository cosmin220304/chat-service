package service.chat;

import lombok.NonNull;
import models.Conversation;
import models.Message;
import service.conversation.ConversationService;
import service.conversation.ConversationServiceImpl;
import service.message.MessageService;
import service.message.MessageServiceImpl;

import java.util.List;

public final class ChatServiceImpl implements ChatService{
    private static ChatService instance;
    private final ConversationService conversationService;
    private final MessageService messageService;

    private ChatServiceImpl() {
        this.conversationService = new ConversationServiceImpl();
        this.messageService = new MessageServiceImpl();
    }

    public static ChatService getInstance() {
        if (null == instance) {
            instance = new ChatServiceImpl();
        }
        return instance;
    }

    @Override
    public List<Conversation> getAllConversationsByUserId(@NonNull String userId) {
        return conversationService.listConversation(userId);
    }

    @Override
    public List<Conversation> getAllConversationsById(@NonNull String conversationId) {
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
    public List<Message> readMessages(@NonNull String conversationId, Integer offset, Integer limit) {
        return null;
    }
}
