package net.testaholic.brewery.service.drink;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by williamrussell on 5/11/16.
 */
public interface DrinkDetailsService {
    DrinkDetails loadDrinkByName(String var1) throws UsernameNotFoundException;
}
