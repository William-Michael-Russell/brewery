package net.testaholic.brewery.service.drink;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by williamrussell on 5/11/16.
 */
public interface DrinkDetails extends Serializable {
    Collection<? extends GrantedAuthority> getAuthorities();

    String getDrinkName();

    String getDrinkImageURL();

    String getDrinkIngredients();

    boolean isEnabled();
}

