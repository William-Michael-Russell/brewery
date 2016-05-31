package net.testaholic.brewery.service.location;

import net.testaholic.brewery.domain.location.Location;
import net.testaholic.brewery.domain.location.LocationCreateForm;
import net.testaholic.brewery.repository.LocationRepository;
import net.testaholic.brewery.service.user.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by williamrussell on 5/20/16.
 */
@Service
public class LocationServiceImpl implements LocationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private final LocationRepository locationRepository;

    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public Optional<Location> getLocationById(long id) {
        LOGGER.debug("Getting location={}", id);
        return Optional.ofNullable(locationRepository.findOne(id));
    }

    @Override
    public Collection<Location> getAllLocations() {
        LOGGER.debug("Getting all locations");
        return locationRepository.findAll(new Sort("store_name"));
    }

    @Override
    public Location update(LocationCreateForm form, Long id) {
        Location location = parseLocation(form);
        location.setId(id);
        return locationRepository.save(location);
    }

    @Override
    public Location create(LocationCreateForm form) {
        return locationRepository.save(parseLocation(form));
    }

    private Location parseLocation(LocationCreateForm form){
        Location location = new Location();
        location.setStoreTitle(form.getStoreTitle());
        location.setStoreEmail(form.getStoreEmail());
        location.setStoreAddress(form.getStoreAddress());
        location.setStoreDescription(form.getStoreDescription());
        location.setStorePhoneNumber(form.getStorePhoneNumber());
        return location;
    }
}


