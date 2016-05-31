package net.testaholic.brewery.service.appetizer;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by williamrussell on 5/11/16.
 */
public interface AppetizerDetailsService {
    AppetizerDetails loadAppetizerByName(String var1) throws UsernameNotFoundException;
}
