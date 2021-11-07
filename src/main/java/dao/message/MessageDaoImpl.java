package dao.message;

import dao.dto.MessageDto;

import java.util.List;
import java.util.Optional;

public class MessageDaoImpl implements MessageDao{
    @Override
    public Optional<MessageDto> readById(String id) {
        return Optional.empty();
    }

    @Override
    public List<MessageDto> readAll() {
        return null;
    }

    @Override
    public MessageDto create(MessageDto newEntry) {
        return null;
    }

    @Override
    public MessageDto update(MessageDto entry) {
        return null;
    }
}
