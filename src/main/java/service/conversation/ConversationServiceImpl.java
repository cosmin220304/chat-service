package service.conversation;

import dao.DaoFactory;
import dao.conversation.ConversationDao;
import lombok.SneakyThrows;
import models.Conversation;

import java.util.List;

public class ConversationServiceImpl implements ConversationService{

    private final ConversationDao conversationDao;

    @SneakyThrows
    public ConversationServiceImpl() {
        this.conversationDao = (ConversationDao) DaoFactory.getInstance().getDao("conversation");
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
    public List<Conversation> listConversation(String user) {
        return conversationDao
                .readAll()
                .stream()
                .filter(conversationDto ->
                        conversationDto.getParticipant1().equals(user)
                        || conversationDto.getParticipant2().equals(user))
                .map(conversationDto ->
                        Conversation.builder()
                                .id(conversationDto.getId())
                                .messages(conversationDto.getMessages())
                                .participant1(conversationDto.getParticipant1())
                                .participant2(conversationDto.getParticipant2())
                                .build()
                )
                .toList();
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
