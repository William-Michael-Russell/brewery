package net.testaholic.brewery.controller.rest_controller;

import net.testaholic.brewery.controller.rest_controller.error.InvalidRequestException;
import net.testaholic.brewery.domain.user.Users;
import net.testaholic.brewery.domain.user.UserCreateForm;
import net.testaholic.brewery.domain.validator.UserCreateFormValidator;
import net.testaholic.brewery.domain.validator.UserUpdateFormValidator;
import net.testaholic.brewery.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;


@Controller
@RequestMapping("/v1")
public class LoginRestController{

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginRestController.class);

    private final UserService userService;
    private final UserCreateFormValidator userCreateFormValidator;
    private AuthenticationManager authenticationManager;
    private final UserUpdateFormValidator userUpdateFormValidator;

    @Autowired
    public LoginRestController(UserService userService, UserCreateFormValidator userCreateFormValidator, UserUpdateFormValidator userUpdateFormValidator,
                              AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.userCreateFormValidator = userCreateFormValidator;
        this.authenticationManager = authenticationManager;
        this.userUpdateFormValidator = userUpdateFormValidator;
    }


    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Users getLoginPage(@RequestBody UserCreateForm userCreateForm, BindingResult bindingResult) {
        Users users = null;
        try {

         users = userService.getUserByEmail(userCreateForm.getEmail()).get();
        }catch (NoSuchElementException nsee){
            throw new InvalidRequestException("Unable to login user, please check the username and password", bindingResult);
        }

        if (new BCryptPasswordEncoder().matches(userCreateForm.getPassword(), users.getPasswordHash())) {
            return users;
        }else {
            throw new InvalidRequestException("Unable to login user, please check the username and password", bindingResult);
        }
    }

}
