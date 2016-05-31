package net.testaholic.brewery.controller.rest_controller;

import net.testaholic.brewery.domain.user.User;
import net.testaholic.brewery.domain.user.UserCreateForm;
import net.testaholic.brewery.domain.validator.UserCreateFormValidator;
import net.testaholic.brewery.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by williamrussell on 5/12/16.
 */
@Controller
@EnableWebMvc
public class UserRestController extends WebMvcConfigurerAdapter{

    private UserService userService;
    private UserCreateFormValidator createFormValidator;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    public UserRestController(UserService userService, UserCreateFormValidator userCreateFormValidator) {
        this.userService = userService;
        this.createFormValidator = userCreateFormValidator;
    }


    @ResponseBody
    @RequestMapping("/greeting")
    public User greeting(@RequestParam(value = "email") String email,
                         @RequestParam(value = "password") String password,
                         @RequestParam(value = "role") String role) {
        UserCreateForm userCreateForm = new UserCreateForm(email, password, role);
        userService.create(userCreateForm);

        return new User(email, password, role);
    }

 }