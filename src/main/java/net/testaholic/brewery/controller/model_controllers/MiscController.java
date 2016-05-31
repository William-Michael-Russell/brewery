package net.testaholic.brewery.controller.model_controllers;

import net.testaholic.brewery.domain.validator.DrinkCreateFormValidator;
import net.testaholic.brewery.domain.validator.UserCreateFormValidator;
import net.testaholic.brewery.service.drink.DrinkService;
import net.testaholic.brewery.service.location.LocationService;
import net.testaholic.brewery.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.NoSuchElementException;

@Controller
public class MiscController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private final LocationService locationService;

    @Autowired
    public MiscController(LocationService locationService) {
        this.locationService = locationService;
    }

    @RequestMapping("/contact")
    public String getContactPage() {
        return "contact";
    }


}
