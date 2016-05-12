package net.testaholic.brewery.service.drink;

import net.testaholic.brewery.domain.drink.Drink;
import net.testaholic.brewery.domain.drink.DrinkCreateForm;

import java.util.Collection;
import java.util.Optional;

public interface DrinkService {

    Optional<Drink> getDrinkById(long id);

    Optional<Drink> getDrinkByName(String name);

    Drink create(DrinkCreateForm form);

    Collection<Drink> getAllDrinks();

}
