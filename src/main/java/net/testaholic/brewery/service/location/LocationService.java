package net.testaholic.brewery.service.location;

import net.testaholic.brewery.domain.location.Location;
import net.testaholic.brewery.domain.location.LocationCreateForm;


import java.util.Collection;
import java.util.Optional;

/**
 * Created by williamrussell on 5/20/16.
 */
public interface LocationService {

    Optional<Location> getLocationById(long id);

    Collection<Location> getAllLocations();

    Location update(LocationCreateForm form, Long id);

    Location create(LocationCreateForm form);
}
