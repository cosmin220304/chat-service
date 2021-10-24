package models;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
public class Message {
    @NonNull
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