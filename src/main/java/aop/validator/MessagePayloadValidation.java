package aop.validator;

import aop.annotations.ValidateMessagePayload;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MessagePayloadValidation implements ConstraintValidator<ValidateMessagePayload, HttpServletRequest> {
    @Override
    public void initialize(final ValidateMessagePayload constraintAnnotation) {

    }

    @Override
    public boolean isValid(HttpServletRequest request, ConstraintValidatorContext constraintValidatorContext) {
        if (request.getParameter("message") == null || request.getParameter(("message")).isEmpty()) {
            return false;
        }
        if (request.getParameter("conversationId") == null || request.getParameter(("conversationId")).isEmpty()) {
            return false;
        }
        return true;
    }
}
