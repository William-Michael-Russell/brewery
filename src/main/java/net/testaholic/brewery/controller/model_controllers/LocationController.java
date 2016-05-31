package net.testaholic.brewery.controller.model_controllers;

import net.testaholic.brewery.domain.location.LocationCreateForm;
import net.testaholic.brewery.domain.user.UserCreateForm;
import net.testaholic.brewery.service.location.LocationService;
import net.testaholic.brewery.utils.EmailValidator;
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
public class LocationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }


    @RequestMapping("/location/{id}")
    public ModelAndView getLocationPage(@PathVariable Long id) {
        return new ModelAndView("location", "location", locationService.getLocationById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("Location=%s not found", id))));
    }


//    @PreAuthorize("hasAuthority('ADMIN')")  #BUG any user can change store address
    @RequestMapping(value = "/location/update/{id}", method = RequestMethod.POST)
    public String handleLocationCreateForm(@PathVariable Long id, @Valid @ModelAttribute("form") LocationCreateForm form, BindingResult bindingResult) {
        LOGGER.debug("Processing location update form={}, bindingResult={}", form, bindingResult);
        try {
            locationService.update(form, id);
        } catch (DataIntegrityViolationException e) {
            // probably email already exists - very rare case when multiple admins are adding same user
            // at the same time and form validation has passed for more than one of them.
            LOGGER.warn("Exception occurred when trying to save the location, assuming duplicate location", e);
            bindingResult.reject("email.exists", "Email already exists");
            return "location_update";
        }
        return "redirect:/location/" + id;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/location/update/{id}", method = RequestMethod.GET)
    public ModelAndView getLocationUpdatePage(@PathVariable Long id) {
        LOGGER.debug("Getting user create form");
        return new ModelAndView("location_create", "form", locationService.getLocationById(id));
    }

}
