package service.chat;

import com.mongodb.lang.Nullable;
import lombok.NonNull;
import models.Conversation;
import models.Message;

import java.util.List;

public interface ChatService {
    static @Nullable ChatService getInstance() {
        return null;
    }
    List<Conversation> getAllConversationsByUserId(@NonNull String userId);
    List<Conversation> getAllConversationsById(@NonNull String conversationId);
    Conversation getConversationBetweenUsers(@NonNull String user1, @NonNull String user2);
    Message sendMessage(@NonNull String conversationId, @NonNull String message);
    List<Message> readMessages(@NonNull String conversationId, Integer offset, Integer limit);
}
