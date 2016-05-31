package net.testaholic.brewery.service.appetizer;

import net.testaholic.brewery.domain.appetizer.Appetizer;
import net.testaholic.brewery.domain.appetizer.AppetizerCreateForm;

import java.util.Collection;
import java.util.Optional;

public interface AppetizerService {

    Optional<Appetizer> getAppetizerById(long id);

    Optional<Appetizer> getAppetizerByName(String name);

    Appetizer create(AppetizerCreateForm form);

    Collection<Appetizer> getAllAppetizers();

}
