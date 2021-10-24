package service.message;

import lombok.NonNull;
import models.Message;

import java.util.List;

public interface MessageService {
    Message createMessage(@NonNull String conversationId, @NonNull String message);
    Message markMessageAsRead(@NonNull String messageId);
    List<Message> readAllMessages(Integer limit, Integer offset);
}
