package net.testaholic.brewery.service.bartender;

import net.testaholic.brewery.domain.bartender.Bartender;
import net.testaholic.brewery.domain.bartender.BartenderCreateForm;
import net.testaholic.brewery.domain.location.Location;
import net.testaholic.brewery.domain.location.LocationCreateForm;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by williamrussell on 5/20/16.
 */
public interface BartenderService {

    Optional<Bartender> getBartenderById(long id);

    Optional<Bartender> getBartenderByName(String bartenderName);

    Collection<Bartender> getAllBartenders();

    Bartender update(BartenderCreateForm form, Long id);

    Bartender update(BartenderCreateForm form, String bartenderName);

    Bartender create(BartenderCreateForm form);
}
