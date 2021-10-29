package service.chat;

import lombok.NonNull;
import models.Conversation;
import models.Message;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface ChatService {
    @Contract(pure = true)
    static @Nullable ChatService getInstance() {
        return null;
    }
    List<Conversation> getConversationByUserId(@NonNull String userId);
    List<Conversation> getConversationById(@NonNull String conversationId);
    Conversation getConversationBetweenUsers(@NonNull String user1, @NonNull String user2);
    Message sendMessage(@NonNull String conversationId, @NonNull String message);
    Message readMessages(@NonNull String conversationId, Integer offset, Integer limit);
}
