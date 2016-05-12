package net.testaholic.brewery.service.drink;

import net.testaholic.brewery.domain.drink.Drink;
import net.testaholic.brewery.domain.drink.DrinkCreateForm;
import net.testaholic.brewery.repository.DrinkRepository;
import net.testaholic.brewery.service.user.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class DrinkServiceImpl implements DrinkService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private final DrinkRepository drinkRepository;

    @Autowired
    public DrinkServiceImpl(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    @Override
    public Optional<Drink> getDrinkById(long id) {
        return Optional.ofNullable(drinkRepository.findOne(id));
    }

    @Override
    public Optional<Drink> getDrinkByName(String drinkName) {
        LOGGER.debug("Getting user by email={}", drinkName.replaceFirst("@.*", "@***"));
        return drinkRepository.findOneByDrinkName(drinkName);
    }


    @Override
    public Collection<Drink> getAllDrinks() {
        LOGGER.debug("Getting all drinks");
        return drinkRepository.findAll(new Sort("drinkName"));
    }

    @Override
    public Drink create(DrinkCreateForm form) {
        Drink drink = new Drink();
        drink.setDrinkName(form.getDrinkName());
        drink.setDrinkImageUrl(form.getDrinkImageUrl());
        drink.setDrinkIngredients(form.getDrinkIngredients());
        return drinkRepository.save(drink);
    }
}
