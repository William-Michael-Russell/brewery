package net.testaholic.brewery.service.appetizer;

import net.testaholic.brewery.domain.appetizer.Appetizer;
import net.testaholic.brewery.domain.appetizer.AppetizerCreateForm;
import net.testaholic.brewery.repository.AppetizerRepository;
import net.testaholic.brewery.service.user.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class AppetizerServiceImpl implements AppetizerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private final AppetizerRepository appetizerRepository;

    @Autowired
    public AppetizerServiceImpl(AppetizerRepository appetizerRepository) {
        this.appetizerRepository = appetizerRepository;
    }

    @Override
    public Optional<Appetizer> getAppetizerById(long id) {
        return Optional.ofNullable(appetizerRepository.findOne(id));
    }

    @Override
    public Optional<Appetizer> getAppetizerByName(String appetizerName) {
        LOGGER.debug("Getting user by email={}", appetizerName.replaceFirst("@.*", "@***"));
        return appetizerRepository.findOneByAppetizerName(appetizerName);
    }


    @Override
    public Collection<Appetizer> getAllAppetizers() {
        LOGGER.debug("Getting all appetizers");
        return appetizerRepository.findAll(new Sort("appetizerName"));
    }

    @Override
    public Appetizer create(AppetizerCreateForm form) {
        Appetizer appetizer = new Appetizer();
        appetizer.setAppetizerName(form.getAppetizerName());
        appetizer.setAppetizerImageUrl(form.getAppetizerImageUrl());
        appetizer.setAppetizerIngredients(form.getAppetizerIngredients());
        return appetizerRepository.save(appetizer);
    }
}
