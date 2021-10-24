package dao.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class MessageDto {
    private String id;
    private String conversationId;
    private String senderId;
    private String receiverId;
    private Date sentDate;
    private Date seenDate;
    private String content;
}
