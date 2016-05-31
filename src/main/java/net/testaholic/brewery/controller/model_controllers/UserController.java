package net.testaholic.brewery.controller.model_controllers;

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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;
    private final UserCreateFormValidator userCreateFormValidator;
    private AuthenticationManager authenticationManager;
    private final UserUpdateFormValidator userUpdateFormValidator;

    @Autowired
    public UserController(UserService userService, UserCreateFormValidator userCreateFormValidator, UserUpdateFormValidator userUpdateFormValidator,
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

    @PreAuthorize("@currentUserServiceImpl.canAccessUser(principal, #id)")
    @RequestMapping("/user/{id}")
    public ModelAndView getUserPage(@PathVariable Long id) {
        LOGGER.debug("Getting user page for user={}", id);
        return new ModelAndView("user", "user", userService.getUserById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("User=%s not found", id))));
    }


    @PreAuthorize("@currentUserServiceImpl.canAccessUser(principal, #id)")
    @RequestMapping(value = "/user/update/{id}", method = RequestMethod.POST)
    public ModelAndView updateUser(@PathVariable Long id, @Valid @ModelAttribute("updater") UserCreateForm form, BindingResult bindingResult, HttpServletRequest request,
                                   HttpServletResponse response) {
        try {
            UserCreateForm createForm = form;
            createForm.setId(id);


            ModelAndView modelAndView = new ModelAndView("user_update", "form", form);
            if (form.getPassword().equalsIgnoreCase(form.getCurrentPassword())) {
                modelAndView.addObject("pass_and_current", "New email and current email must be different, please try again");
            }
            if (!form.getPassword().equalsIgnoreCase(form.getPasswordRepeated())) {
                modelAndView.addObject("password_no_match", "The new password and verify password fields do not match");
            }

            Optional<User> user = userService.getUserById(id);
            Principal principal = SecurityContextHolder.getContext().getAuthentication();
            if (userService.getUserByEmail(principal.getName()).get().getRole().toString().equalsIgnoreCase("ADMIN")) {
                userService.update(createForm, id);
            } else if (new BCryptPasswordEncoder().matches(form.getCurrentPassword(), user.get().getPasswordHash())) {
                userService.update(createForm, id);
            } else {

                modelAndView.addObject("err", "Unable to update password, please try again");
                modelAndView.addObject("user", userService.getUserById(id));

//                bindingResult.rejectValue("password", "messageCode", "Default error message");
                return modelAndView;
            }
        } catch (DataIntegrityViolationException e) {
            bindingResult.rejectValue("password", "messageCode", "Default error message");
        }
        return new ModelAndView("redirect:/user/" + id);
    }

    @ModelAttribute("updater")
    //    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/user/update/{id}", method = RequestMethod.GET)
    public ModelAndView getUserUpdateForm(Model model, @PathVariable Long id) {
        LOGGER.debug("Getting user update form");
        ModelAndView modelAndView = new ModelAndView("user_update", "user", userService.getUserById(id));
        modelAndView.addObject("updater", "");
        return modelAndView;
    }


    @RequestMapping(value = "/user/create", method = RequestMethod.GET)
    public ModelAndView getUserCreatePage() {
        LOGGER.debug("Getting user create form");
        return new ModelAndView("user_create", "form", new UserCreateForm());
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/admin/user/create", method = RequestMethod.GET)
    public ModelAndView getAdminUserCreatePage() {
        LOGGER.debug("Getting user create form");
        return new ModelAndView("user_create", "form", new UserCreateForm());
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public String handleAdminUserCreateForm(@Valid @ModelAttribute("form") UserCreateForm form, BindingResult bindingResult,
                                            HttpServletRequest request, HttpServletResponse response) {
        LOGGER.debug("Processing user create form={}, bindingResult={}", form, bindingResult);
        if (bindingResult.hasErrors()) {

            return "user_create";

        }
        if (!EmailValidator.validate(form.getEmail())) {
            bindingResult.reject("Please enter a valid email format.");
        }
        try {
            User user = userService.create(form);
            request.login(form.getEmail(), form.getPassword());
        } catch (DataIntegrityViolationException e) {

            LOGGER.warn("Exception occurred when trying to save the user, assuming duplicate email", e);
            bindingResult.reject("email.exists", "Email already exists");
            return "user_create";
        } catch (ServletException e) {
            e.printStackTrace();
        }
        return "redirect:/locations/1";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String handleUserCreateForm(@Valid @ModelAttribute("form") UserCreateForm form, BindingResult bindingResult) {
        LOGGER.debug("Processing user create form={}, bindingResult={}", form, bindingResult);
        if (bindingResult.hasErrors()) {
            // failed validation
            return "user_create";
        }
        if (!EmailValidator.validate(form.getEmail())) {
            bindingResult.reject("Please enter a valid email format.");
        }
        try {
            userService.create(form);
        } catch (DataIntegrityViolationException e) {
            // probably email already exists - very rare case when multiple admins are adding same user
            // at the same time and form validation has passed for more than one of them.
            LOGGER.warn("Exception occurred when trying to save the user, assuming duplicate email", e);
            bindingResult.reject("email.exists", "Email already exists");
            return "user_create";
        }
        return "redirect:/users";
    }

    @RequestMapping("/users")
    public ModelAndView getUsersPage() {
        LOGGER.debug("Getting users page");
        return new ModelAndView("users", "users", userService.getAllUsers());
    }


    protected boolean hasRole(String role) {
        // get security context from thread local
        SecurityContext context = SecurityContextHolder.getContext();
        if (context == null)
            return false;

        Authentication authentication = context.getAuthentication();
        if (authentication == null)
            return false;

        for (GrantedAuthority auth : authentication.getAuthorities()) {
            if (role.equals(auth.getAuthority()))
                return true;
        }

        return false;
    }


}
