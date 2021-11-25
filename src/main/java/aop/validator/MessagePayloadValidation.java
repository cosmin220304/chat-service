package aop.validator;

import aop.annotations.ValidateMessagePayload;
import com.google.gson.Gson;
import model.SendMessageRequestPayload;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.io.IOException;

public class MessagePayloadValidation implements ConstraintValidator<ValidateMessagePayload, HttpServletRequest> {
    @Override
    public void initialize(final ValidateMessagePayload constraintAnnotation) {

    }

    @Override
    public boolean isValid(HttpServletRequest request, ConstraintValidatorContext constraintValidatorContext) {
        try {
            if (request.getParameter("conversationId") == null
                    || request.getParameter(("conversationId")).isBlank()) {
                return false;
            }
            SendMessageRequestPayload messageRequestPayload = new Gson()
                    .fromJson(request.getReader(), SendMessageRequestPayload.class);

            return messageRequestPayload != null
                    && !messageRequestPayload.getMessage().isBlank()
                    && !messageRequestPayload.getSenderId().isBlank();

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
