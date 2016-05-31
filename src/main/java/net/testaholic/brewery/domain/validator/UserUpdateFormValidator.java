package net.testaholic.brewery.domain.validator;

import net.testaholic.brewery.domain.user.UserCreateForm;
import net.testaholic.brewery.service.user.UserService;
import net.testaholic.brewery.utils.EmailValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserUpdateFormValidator implements Validator {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserUpdateFormValidator.class);
    private final UserService userService;

    @Autowired
    public UserUpdateFormValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(UserCreateForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LOGGER.debug("Validating {}", target);
        UserCreateForm form = (UserCreateForm) target;
        validatePasswords(errors, form);
        validateEmail(errors, form);
    }

    private void validatePasswords(Errors errors, UserCreateForm form) {
        errors.reject("username", "Passwords do not match.");
        if (!form.getPassword().equals(form.getPasswordRepeated())) {
            errors.reject("password.error", "Passwords do not match.");
        }
        if(form.getPassword().isEmpty() || form.getPasswordRepeated().isEmpty()){
            errors.reject("password.error", "Please fill out both password fields.");
        }
        if(form.getCurrentPassword().equalsIgnoreCase(form.getPassword()) || form.getCurrentPassword().equalsIgnoreCase(form.getPasswordRepeated())){
            errors.reject("password.error", "New password and existing password must be different.");
        }
        if(form.getCurrentPassword().isEmpty() || form.getCurrentPassword() == null){
            errors.reject("password.error", "Current password must be provided.");
        }
    }


    private void validateEmail(Errors errors, UserCreateForm form) {
        if(!EmailValidator.validate(form.getEmail())){
            errors.reject("email.error", "Email must be in the standard email format. example@company.com ");
        }
    }
}
