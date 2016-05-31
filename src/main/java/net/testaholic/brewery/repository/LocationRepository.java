package net.testaholic.brewery.repository;


import net.testaholic.brewery.domain.location.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, Long> {

    Optional<Location> findOneById(Long id);

//    @Modifying
//    @Query("update location l set l.store_title = ?1, l.store_address = ?2, l.phone_number = ?3, " +
//            "l.store_email =?4, l.store_description = ?5 where l.id = ?6")
//    Optional<Location> setLocationInfoById(String storeTitle, String storeAddress, String phoneNumber, String storeEmail, String storeDescription, Long locationId);
}
