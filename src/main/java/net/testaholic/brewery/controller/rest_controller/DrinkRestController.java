package net.testaholic.brewery.controller.rest_controller;

import net.testaholic.brewery.controller.rest_controller.error.InvalidRequestException;
import net.testaholic.brewery.domain.drink.Drink;
import net.testaholic.brewery.domain.drink.DrinkCreateForm;
import net.testaholic.brewery.domain.validator.DrinkCreateFormValidator;
import net.testaholic.brewery.service.drink.DrinkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/v1")
public class DrinkRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DrinkRestController.class);
    private DrinkService drinkService;
    private  DrinkCreateFormValidator drinkCreateFormValidator;


    @Autowired
    public DrinkRestController(DrinkService drinkService, DrinkCreateFormValidator drinkCreateFormValidator) {
        this.drinkService = drinkService;
        this.drinkCreateFormValidator = drinkCreateFormValidator;
    }


    @ResponseBody
    @RequestMapping(value = "/drink/create", method = RequestMethod.POST)
    public Drink handleDrinkCreateForm(@RequestBody DrinkCreateForm form, BindingResult bindingResult) {
        LOGGER.debug("Processing user create form={}, bindingResult={}", form, bindingResult);

        if(form.getDrinkName().toCharArray().length > 25){
            throw new InvalidRequestException("Drink name is too long, please reduce it to 25 characters", bindingResult);
        }

        if(form.getDrinkName().toCharArray().length == 1){
            throw new InvalidRequestException("Drink name is too short, please increase it greater than one.", bindingResult);
        }

        if (bindingResult.hasErrors()) {
            throw new InvalidRequestException("An issue while processing the drink request, please try again", bindingResult);
        }
        try {
            return  drinkService.create(form);
        } catch (DataIntegrityViolationException | JpaSystemException e) {
            throw new InvalidRequestException("An error while saving the drink has occured, please try again", bindingResult);
        }
    }

    @ResponseBody
    @RequestMapping("/drinks")
    public Collection<Drink> getDrinksPage() {
        return  drinkService.getAllDrinks();
    }

    @ResponseBody
    @RequestMapping("/drink/{id}")
    public Drink getDrinkPage(@PathVariable Long id) {
        LOGGER.debug("Getting user page for user={}", id);
        return  drinkService.getDrinkById(id).get();
    }

}
