package models;

import dao.dto.MessageDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
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
