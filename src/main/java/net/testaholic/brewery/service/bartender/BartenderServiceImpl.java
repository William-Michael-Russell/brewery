package net.testaholic.brewery.service.bartender;

import net.testaholic.brewery.domain.bartender.Bartender;
import net.testaholic.brewery.domain.bartender.BartenderCreateForm;
import net.testaholic.brewery.repository.BartenderRepository;
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
public class BartenderServiceImpl implements BartenderService {


    private static final Logger LOGGER = LoggerFactory.getLogger(BartenderServiceImpl.class);
    private final BartenderRepository bartenderRepository;

    @Autowired
    public BartenderServiceImpl(BartenderRepository bartenderRepository) {
        this.bartenderRepository = bartenderRepository;
    }

    @Override
    public Optional<Bartender> getBartenderById(long id) {
        LOGGER.debug("Getting bartender={}", id);
        return Optional.ofNullable(bartenderRepository.findOne(id));
    }

    @Override
    public Optional<Bartender> getBartenderByName(String bartenderName) {
        LOGGER.debug("Getting bartender={}", bartenderName);
        return bartenderRepository.findOneByBartenderName(bartenderName);
    }

    @Override
    public Collection<Bartender> getAllBartenders() {
        LOGGER.debug("Getting all bartenders");
        return bartenderRepository.findAll(new Sort("bartender_name"));
    }

    @Override
    public Bartender update(BartenderCreateForm form, Long id) {
        Bartender bartender = parseBartender(form);
        bartender.setId(id);
        return bartenderRepository.save(bartender);
    }

    @Override
    public Bartender update(BartenderCreateForm form, String bartenderName) {
        Bartender bartender = parseBartender(form);
        bartender.setBartenderName(bartenderName);
        return bartenderRepository.save(bartender);
    }


    @Override
    public Bartender create(BartenderCreateForm form) {
        return bartenderRepository.save(parseBartender(form));
    }

    private Bartender parseBartender(BartenderCreateForm form) {
        Bartender bartender = new Bartender();
        bartender.setBartenderName(form.getBartenderName());
        bartender.setBartenderBio(form.getBartenderBio());
        bartender.setBartenderImageUrl(form.getBartenderImageUrl());
        bartender.setBartenderJoinDate(form.getBartenderJoinDate());
        return bartender;
    }
}


