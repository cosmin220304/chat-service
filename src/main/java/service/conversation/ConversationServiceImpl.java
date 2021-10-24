package service.conversation;

import dao.DaoFactory;
import models.Conversation;

public class ConversationServiceImpl implements ConversationService{

    private final DaoFactory daoFactory;

    public ConversationServiceImpl() {
        this.daoFactory = DaoFactory.getInstance();
    }

    @Override
    public Conversation createConversation(String participant1, String participant2) {
        return null;
    }

    @Override
    public Conversation updateConversation(String conversationId) {
        return null;
    }

    @Override
    public Conversation updateConversation(String participant1, String participant2) {
        return null;
    }

    @Override
    public Conversation readConversation(String conversationId) {
        return null;
    }

    @Override
    public Conversation readConversation(String participant1, String participant2) {
        return null;
    }
}
