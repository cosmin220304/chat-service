package models;

import dao.dto.MessageDto;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class Conversation {
    @NonNull
    private final String id;
    @NonNull
    private final String participant1;
    @NonNull
    private final String participant2;
    @NonNull
    private final List<MessageDto> messages;
}
