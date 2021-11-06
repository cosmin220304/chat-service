package service.conversation;

import dao.DaoFactory;
import dao.conversation.ConversationDao;
import dao.dto.ConversationDto;
import lombok.SneakyThrows;
import model.Conversation;

import java.util.List;
import java.util.stream.Collectors;

public class ConversationServiceImpl implements ConversationService {

    private final ConversationDao conversationDao;

    @SneakyThrows
    public ConversationServiceImpl() {
        this.conversationDao = (ConversationDao) DaoFactory.getInstance().getDao("conversation");
    }

    @Override
    public Conversation createConversation(String participant1, String participant2) {
        return conversationDtoToModel(
                conversationDao.create(new ConversationDto(null, participant1, participant2, null))
        );
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
                .map(this::conversationDtoToModel)
                .collect(Collectors.toList());
    }

    @Override
    public Conversation readConversation(String conversationId) {
        return null;
    }

    @Override
    public Conversation readConversation(String participant1, String participant2) {
        return null;
    }

    private Conversation conversationDtoToModel(ConversationDto conversationDto) {
        return Conversation.builder()
                .id(conversationDto.getId())
                .messages(conversationDto.getMessages())
                .participant1(conversationDto.getParticipant1())
                .participant2(conversationDto.getParticipant2())
                .build();
    }
}
