package net.testaholic.brewery.controller.model_controllers;

import net.testaholic.brewery.domain.appetizer.AppetizerCreateForm;
import net.testaholic.brewery.domain.validator.AppetizerCreateFormValidator;
import net.testaholic.brewery.service.appetizer.AppetizerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;

@Controller
public class AppetizerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppetizerController.class);
    private AppetizerService appetizerService;
    private  AppetizerCreateFormValidator appetizerCreateFormValidator;


    @Autowired
    public AppetizerController(AppetizerService appetizerService, AppetizerCreateFormValidator appetizerCreateFormValidator) {
        this.appetizerService = appetizerService;
        this.appetizerCreateFormValidator = appetizerCreateFormValidator;
    }

    @RequestMapping("/appetizer/create")
    public String handleAppetizerCreateForm() {
        LOGGER.debug("Getting home page");
        return "appetizer_create";
    }

    @RequestMapping(value = "/appetizer/create", method = RequestMethod.POST)
    public String handleAppetizerCreateForm(@Valid @ModelAttribute("form") AppetizerCreateForm form, BindingResult bindingResult) {
        LOGGER.debug("Processing user create form={}, bindingResult={}", form, bindingResult);

        if(form.getAppetizerName().toCharArray().length > 25){
            return "error";
        }

        if(form.getAppetizerName().toCharArray().length == 1){
            return "error";
        }

        if(fakeErrors(form.getAppetizerName())){
            return "error";
        }

        if (bindingResult.hasErrors()) {
            // failed validation
            bindingResult.reject("email.exists", "Email already exists");
            return "appetizer_create";
        }
        try {
            appetizerService.create(form);
        } catch (DataIntegrityViolationException e) {
            // probably email already exists - very rare case when multiple admins are adding same user
            // at the same time and form validation has passed for more than one of them.
            LOGGER.warn("Exception occurred when trying  to save the appetizer, assuming duplicate appetizer", e);
            bindingResult.reject("email.exists", "Email already exists");
            return "appetizer_create";
        }
        // ok, redirect
        return "redirect:/appetizers";
    }

    @RequestMapping("/appetizers")
    public ModelAndView getAppetizersPage() {
        LOGGER.debug("Getting home page");
        return new ModelAndView("appetizers", "appetizers", appetizerService.getAllAppetizers());
    }

//    @PreAuthorize("@currentUserServiceImpl.canAccessUser(principal, #id)")
    @RequestMapping("/appetizer/{id}")
    public ModelAndView getAppetizerPage(@PathVariable Long id) {
        LOGGER.debug("Getting user page for user={}", id);
        return new ModelAndView("appetizer", "appetizer", appetizerService.getAppetizerById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("User=%s not found", id))));
    }

    public Boolean fakeErrors(String fakeErrors){
        return Pattern.compile("[$&+,:;=?@#|'<>.-^*()%!]").matcher(fakeErrors).matches();
    }


}
