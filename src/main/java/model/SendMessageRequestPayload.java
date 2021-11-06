package model;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class SendMessageRequestPayload {
    @NonNull
    private final String message;
}
