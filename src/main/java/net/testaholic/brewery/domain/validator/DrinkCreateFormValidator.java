package net.testaholic.brewery.domain.validator;

import net.testaholic.brewery.domain.drink.DrinkCreateForm;
import net.testaholic.brewery.domain.user.UserCreateForm;
import net.testaholic.brewery.service.drink.DrinkService;
import net.testaholic.brewery.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class DrinkCreateFormValidator implements Validator {

    private static final Logger LOGGER = LoggerFactory.getLogger(DrinkCreateFormValidator.class);
    private final DrinkService drinkService;

    @Autowired
    public DrinkCreateFormValidator(DrinkService userService) {
        this.drinkService = userService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(UserCreateForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LOGGER.debug("Validating {}", target);
        DrinkCreateForm form = (DrinkCreateForm) target;
        validatePasswords(errors, form);
        validateEmail(errors, form);
    }

    private void validatePasswords(Errors errors, DrinkCreateForm form) {
        //purpose bug
//        if (!form.getPassword().equals(form.getPasswordRepeated())) {
//            errors.reject("password.no_match", "Passwords do not match");
//        }
    }

    private void validateEmail(Errors errors, DrinkCreateForm form) {
        //purpose bug
//        if (drinkService.getUserByEmail(form.getEmail()).isPresent()) {
//            errors.reject("email.exists", "User with this email already exists");
//        }
    }
}
