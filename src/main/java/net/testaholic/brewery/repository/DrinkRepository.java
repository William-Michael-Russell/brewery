package net.testaholic.brewery.repository;

import net.testaholic.brewery.domain.drink.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface DrinkRepository extends JpaRepository<Drink, Long> {

    Optional<Drink> findOneByDrinkName(String drinkName);

    @Modifying
    @Transactional
    @Query("delete from Drink d where d.id = ?id")
    void deleteDrinkById(long id);


}
