package aop.validator;

import aop.annotations.ValidateMessagePayload;

import javax.servlet.http.HttpServletRequest;

public class MessagePayloadValidation implements ConstraintValidator<ValidateMessagePayload, HttpServletRequest> {
    @Override
    public void initialize(final ValidateMessagePayload constraintAnnotation) {

    }

    @Override
    public boolean isValid(final HttpServletRequest request, final ConstraintValidatorContext context) {
        if (request.getParameter("message") == null || request.getParameter(("message")).isEmpty()) {
            return false;
        }
        return true;
    }
}
