package service.conversation;

import dao.DaoFactory;
import dao.conversation.ConversationDao;
import dao.dto.ConversationDto;
import lombok.SneakyThrows;
import model.Conversation;

import javax.management.InstanceAlreadyExistsException;
import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ConversationServiceImpl implements ConversationService {

    private final ConversationDao conversationDao;

    @SneakyThrows
    public ConversationServiceImpl() {
        this.conversationDao = (ConversationDao) DaoFactory.getInstance().getDao("conversation");
    }

    @Override
    @SneakyThrows
    public Conversation createConversation(String participant1, String participant2) {
        if (readConversation(participant1, participant2).isEmpty()) {
            return conversationDtoToModel(
                    conversationDao.create(new ConversationDto(null, participant1, participant2, null))
            );
        } else {
            throw new InstanceAlreadyExistsException();
        }
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
                .readAll(null)
                .stream()
                .filter(conversationDto ->
                        conversationDto.getParticipant1().equals(user)
                                || conversationDto.getParticipant2().equals(user))
                .map(this::conversationDtoToModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Conversation> readConversation(String conversationId) {
        return conversationDao
                .readById(conversationId)
                .map(this::conversationDtoToModel);
    }

    @Override
    public Optional<Conversation> readConversation(String participant1, String participant2) {
        return conversationDao
                .readAll(null)
                .stream()
                .filter(conversationDto ->
                        (conversationDto.getParticipant1().equals(participant1) && conversationDto.getParticipant2().equals(participant2))
                                || (conversationDto.getParticipant1().equals(participant2) && conversationDto.getParticipant2().equals(participant1))
                ).findFirst()
                .map(this::conversationDtoToModel);
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
