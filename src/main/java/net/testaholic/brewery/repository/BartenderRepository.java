package net.testaholic.brewery.repository;

import net.testaholic.brewery.domain.bartender.Bartender;
import net.testaholic.brewery.domain.drink.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface BartenderRepository extends JpaRepository<Bartender, Long> {

    Optional<Bartender> findOneByBartenderName(String bartenderName);
}
