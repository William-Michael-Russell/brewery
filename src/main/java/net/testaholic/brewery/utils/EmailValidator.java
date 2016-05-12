package net.testaholic.brewery.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by williamrussell on 5/11/16.
 */
public class EmailValidator {
    private static Matcher matcher;

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private EmailValidator() {
    }

    /**
     * Validate hex with regular expression
     *
     * @param hex
     *            hex for validation
     * @return true valid hex, false invalid hex
     */
    public static boolean validate(final String hex) {
        matcher =  Pattern.compile(EMAIL_PATTERN).matcher(hex);
        return matcher.matches();
    }
}