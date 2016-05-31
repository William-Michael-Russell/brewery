package net.testaholic.brewery.service.appetizer;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by williamrussell on 5/11/16.
 */
public interface AppetizerDetails extends Serializable {
    Collection<? extends GrantedAuthority> getAuthorities();

    String getAppetizerName();

    String getAppetizerImageURL();

    String getAppetizerIngredients();

    boolean isEnabled();
}

