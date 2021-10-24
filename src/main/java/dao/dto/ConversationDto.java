package dao.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ConversationDto {
    private String id;
    private String participant1;
    private String participant2;
    private List<MessageDto> messages;
}
