package model;

import dao.dto.MessageDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
@RequiredArgsConstructor
public class Conversation {
    private final String id;

    @NonNull
    private final String participant1;

    @NonNull
    private final String participant2;

    private final List<MessageDto> messages;
}
