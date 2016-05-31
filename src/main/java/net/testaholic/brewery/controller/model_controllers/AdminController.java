package net.testaholic.brewery.controller.model_controllers;

import net.testaholic.brewery.domain.validator.DrinkCreateFormValidator;
import net.testaholic.brewery.service.drink.DrinkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class AdminController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);
    private DrinkService drinkService;
    private  DrinkCreateFormValidator drinkCreateFormValidator;


    @Autowired
    public AdminController(DrinkService drinkService, DrinkCreateFormValidator drinkCreateFormValidator) {
        this.drinkService = drinkService;
        this.drinkCreateFormValidator = drinkCreateFormValidator;
    }

    @RequestMapping("/account")
    public String getDrinkPage() {
        LOGGER.debug("Getting home page");
        return "account";
    }
}
