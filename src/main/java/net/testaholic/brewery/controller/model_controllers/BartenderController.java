package net.testaholic.brewery.controller.model_controllers;

import net.testaholic.brewery.domain.bartender.BartenderCreateForm;
import net.testaholic.brewery.service.bartender.BartenderService;
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

@Controller
public class BartenderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private final BartenderService bartenderService;

    @Autowired
    public BartenderController(BartenderService bartenderService) {
        this.bartenderService = bartenderService;
    }


    @RequestMapping("/bartender/{id}")
    public ModelAndView getBartenderPage(@PathVariable Long id) {
        return new ModelAndView("bartender", "bartender", bartenderService.getBartenderById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("Bartender=%s not found", id))));
    }


//    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/bartender/update/{id}", method = RequestMethod.POST)
    public String handleBartenderCreateForm(@PathVariable Long id, @Valid @ModelAttribute("form") BartenderCreateForm form, BindingResult bindingResult) {
        LOGGER.debug("Processing bartender update form={}, bindingResult={}", form, bindingResult);
//        if (bindingResult.hasErrors()) {
//            // failed validation
//            return "user_create";
//        }
//        if(!EmailValidator.validate(form.getEmail())){
//            bindingResult.reject("Please enter a valid email format.");
//        }
        try {
            bartenderService.update(form, id);
        } catch (DataIntegrityViolationException e) {
            // probably email already exists - very rare case when multiple admins are adding same user
            // at the same time and form validation has passed for more than one of them.
            LOGGER.warn("Exception occurred when trying to save the bartender, assuming duplicate bartender", e);
            bindingResult.reject("email.exists", "Email already exists");
            return "bartender_update";
        }
        return "redirect:/bartender/" + id;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/bartender/update/{id}", method = RequestMethod.GET)
    public ModelAndView getBartenderUpdatePage(@PathVariable Long id) {
        LOGGER.debug("Getting user create form");
        return new ModelAndView("bartender_create", "form", bartenderService.getBartenderById(id));
    }

}
