package net.testaholic.brewery.service.visit;

import net.testaholic.brewery.domain.visit.Visit;
import net.testaholic.brewery.repository.VisitRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by williamrussell on 6/18/16. GrindrLabs
 */
@Service
public class VisitServiceImpl implements VisitService {

    private static final Logger LOGGER = LoggerFactory.getLogger(VisitServiceImpl.class);
    private final VisitRepository visitRepository;

    @Autowired
    public VisitServiceImpl(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Visit create(Visit visit) {
        return visitRepository.save(visit);
    }

    @Override
    public Collection<Visit> getAllExits(String exit) {
        LOGGER.debug("Getting all users");
        return visitRepository.findAllByExit(exit);
    }

    @Override
    public Collection<Visit> getAllEnters(String enter) {
        LOGGER.debug("Getting all users");
        return visitRepository.findAllByEnter(enter);
    }
}
