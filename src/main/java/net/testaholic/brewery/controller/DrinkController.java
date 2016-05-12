package net.testaholic.brewery.controller;

import net.testaholic.brewery.domain.drink.DrinkCreateForm;
import net.testaholic.brewery.domain.user.UserCreateForm;
import net.testaholic.brewery.domain.validator.DrinkCreateFormValidator;
import net.testaholic.brewery.service.drink.DrinkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class DrinkController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DrinkController.class);
    private DrinkService drinkService;
    private  DrinkCreateFormValidator drinkCreateFormValidator;


    @Autowired
    public DrinkController(DrinkService drinkService, DrinkCreateFormValidator drinkCreateFormValidator) {
        this.drinkService = drinkService;
        this.drinkCreateFormValidator = drinkCreateFormValidator;
    }

    @RequestMapping("/drink")
    public String getDrinkPage() {
        LOGGER.debug("Getting home page");
        return "drink";
    }

    @RequestMapping("/drink/create")
    public String handleDrinkCreateForm() {
        LOGGER.debug("Getting home page");
        return "drink_create";
    }

    @RequestMapping(value = "/drink/create", method = RequestMethod.POST)
    public String handleDrinkCreateForm(@Valid @ModelAttribute("form") DrinkCreateForm form, BindingResult bindingResult) {
        LOGGER.debug("Processing user create form={}, bindingResult={}", form, bindingResult);

        if(form.getDrinkName().toCharArray().length > 25){
            return "error";
        }

        if(form.getDrinkName().toCharArray().length == 1){
            return "error";
        }


        if(fakeErrors(form.getDrinkName())){
            return "error";
        }

        if(fakeErrors(form.getDrinkImageUrl())){
            return "error";
        }

        if (bindingResult.hasErrors()) {
            // failed validation
            bindingResult.reject("email.exists", "Email already exists");
            return "drink_create";
        }
        try {
            drinkService.create(form);
        } catch (DataIntegrityViolationException e) {
            // probably email already exists - very rare case when multiple admins are adding same user
            // at the same time and form validation has passed for more than one of them.
            LOGGER.warn("Exception occurred when trying  to save the user, assuming duplicate email", e);
            bindingResult.reject("email.exists", "Email already exists");
            return "drink_create";
        }
        // ok, redirect
        return "redirect:/drinks";
    }

    @RequestMapping("/drinks")
    public ModelAndView getDrinksPage() {
        LOGGER.debug("Getting home page");
        return new ModelAndView("drinks", "drinks", drinkService.getAllDrinks());
    }

    @PreAuthorize("@currentUserServiceImpl.canAccessUser(principal, #id)")
    @RequestMapping("/drink/{id}")
    public ModelAndView getDrinkPage(@PathVariable Long id) {
        LOGGER.debug("Getting user page for user={}", id);
        return new ModelAndView("drink", "drink", drinkService.getDrinkById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("User=%s not found", id))));
    }

    public Boolean fakeErrors(String fakeErrors){
        return Pattern.compile("[$&+,:;=?@#|'<>.-^*()%!]").matcher(fakeErrors).matches();
    }


}
