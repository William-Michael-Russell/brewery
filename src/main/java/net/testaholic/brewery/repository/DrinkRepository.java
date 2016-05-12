package net.testaholic.brewery.repository;

import net.testaholic.brewery.domain.drink.Drink;
import net.testaholic.brewery.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DrinkRepository extends JpaRepository<Drink, Long> {

    Optional<Drink> findOneByDrinkName(String drinkName);
}
