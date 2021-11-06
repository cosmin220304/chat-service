package model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Message {
    private final String id;
    @NonNull
    private final String conversationId;
    @NonNull
    private final String senderId;
    @NonNull
    private final String receiverId;
    @NonNull
    private final Date sentDate;
    @NonNull
    private final Date seenDate;
    @NonNull
    private final String content;
}