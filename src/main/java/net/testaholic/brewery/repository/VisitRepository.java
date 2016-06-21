

package net.testaholic.brewery.repository;

import net.testaholic.brewery.domain.visit.Visit;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface VisitRepository extends JpaRepository<Visit, Long> {

//    @Query("select v.exit from visit v")
    Collection<Visit> findAllByExit(String exit);

//    @Query("select v.enter from visit v")
    Collection<Visit> findAllByEnter(String enter);

}
