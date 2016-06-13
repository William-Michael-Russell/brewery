package net.testaholic.brewery.controller.rest_controller;

import javassist.NotFoundException;
import net.testaholic.brewery.controller.rest_controller.error.InvalidRequestException;
import net.testaholic.brewery.domain.user.User;
import net.testaholic.brewery.domain.user.UserCreateForm;
import net.testaholic.brewery.domain.validator.UserCreateFormValidator;
import net.testaholic.brewery.domain.validator.UserUpdateFormValidator;
import net.testaholic.brewery.service.user.UserService;
import net.testaholic.brewery.utils.EmailValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.security.Principal;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Controller
@RequestMapping("/v1")
public class UserRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRestController.class);
    private final UserService userService;
    private final UserCreateFormValidator userCreateFormValidator;
    private AuthenticationManager authenticationManager;
    private final UserUpdateFormValidator userUpdateFormValidator;

    @Autowired
    public UserRestController(UserService userService, UserCreateFormValidator userCreateFormValidator, UserUpdateFormValidator userUpdateFormValidator,
                              AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.userCreateFormValidator = userCreateFormValidator;
        this.authenticationManager = authenticationManager;
        this.userUpdateFormValidator = userUpdateFormValidator;
    }

    @InitBinder("form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userCreateFormValidator);

    }

    @InitBinder("updater")
    public void initBinder2(WebDataBinder binder) {
        binder.addValidators(userUpdateFormValidator);

    }

    @ResponseBody
    @RequestMapping("/user/{id}")
    public User getUserPage(@PathVariable Long id) {
        LOGGER.debug("Getting user page for user={}", id);
        return  userService.getUserById(id).get();
    }

    @ResponseBody
    @PreAuthorize("@currentUserServiceImpl.canAccessUser(principal, #id)")
    @RequestMapping(value = "/user/update/{id}", method = RequestMethod.POST)
    public User updateUser(@PathVariable Long id, @RequestBody UserCreateForm form, BindingResult bindingResult, HttpServletRequest request,
                                   HttpServletResponse response) {
        try {
            UserCreateForm createForm = form;
            createForm.setId(id);




            if (form.getPassword().equalsIgnoreCase(form.getCurrentPassword())) {
                throw new InvalidRequestException("Current password and new password must be different.", bindingResult);
            }
            if (!form.getPassword().equalsIgnoreCase(form.getPasswordRepeated())) {
                throw new InvalidRequestException("The new password and verify password fields do not match.", bindingResult);
            }

            Optional<User> user = userService.getUserById(id);
            Principal principal = SecurityContextHolder.getContext().getAuthentication();
            if (userService.getUserByEmail(principal.getName()).get().getRole().toString().equalsIgnoreCase("ADMIN")) {
              return userService.update(createForm, id);
            } else if (new BCryptPasswordEncoder().matches(form.getCurrentPassword(), user.get().getPasswordHash())) {
                userService.update(createForm, id);
            } else {
                    throw new InvalidRequestException("Unable to update password, please try again.", bindingResult);
            }
        } catch (DataIntegrityViolationException e) {
            throw new InvalidRequestException("Unable to update password.", bindingResult);
        }
        throw new InvalidRequestException("Unable to update password.  Please try again", bindingResult);
    }


    @ResponseBody
//    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/user/update/{id}", method = RequestMethod.GET)
    public User getUserUpdateForm(@PathVariable Long id) {
        LOGGER.debug("Getting user update form");
        return userService.getUserById(id).get();
    }

    @ResponseBody
    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public User handleAdminUserCreateForm(@RequestBody UserCreateForm form, BindingResult bindingResult,
                                            HttpServletRequest request, HttpServletResponse response) throws Exception{
        LOGGER.debug("Processing user create form={}, bindingResult={}", form, bindingResult);
        if (!EmailValidator.validate(form.getEmail())) {
            bindingResult.reject("Invalid email format");
        }

        if (bindingResult.hasErrors()) {
            throw new InvalidRequestException("Invalid Email format, email must contain name@domain.com", bindingResult);
        }

        User user = null;
        try {
            return userService.create(form);
        }catch (DataIntegrityViolationException | JpaSystemException e){
            throw new InvalidRequestException("Unable to create user. Does this user already exist?", bindingResult);
        }
    }


    @ResponseBody
    @RequestMapping("/users")
    public Collection<User> getUsersPage() {
        LOGGER.debug("Getting users page");
        return  userService.getAllUsers();
    }
}
