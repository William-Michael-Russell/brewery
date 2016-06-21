package net.testaholic.brewery.service.visit;

import net.testaholic.brewery.domain.visit.Visit;

import java.util.Collection;

/**
 * Created by williamrussell on 6/18/16. GrindrLabs
 */
public interface VisitService {

    Visit create(Visit visit);

    Collection<Visit> getAllExits(String exit);

    Collection<Visit> getAllEnters(String enter);

}