package service.message;

import dao.DaoFactory;
import lombok.NonNull;
import model.Message;

import java.util.List;

public class MessageServiceImpl implements MessageService{

    private final DaoFactory daoFactory;

    public MessageServiceImpl() {
        this.daoFactory = DaoFactory.getInstance();
    }

    @Override
    public Message createMessage(@NonNull String conversationId, @NonNull String message) {
        return null;
    }

    @Override
    public Message markMessageAsRead(@NonNull String messageId) {
        return null;
    }

    @Override
    public List<Message> readAllMessages(Integer limit, Integer offset) {
        return null;
    }
}
