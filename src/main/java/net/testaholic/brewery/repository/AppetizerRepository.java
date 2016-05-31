package net.testaholic.brewery.repository;


import net.testaholic.brewery.domain.appetizer.Appetizer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppetizerRepository extends JpaRepository<Appetizer, Long> {

    Optional<Appetizer> findOneByAppetizerName(String appetizerkName);
}
