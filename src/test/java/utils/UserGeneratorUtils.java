package utils;

import rest.jsm.users.User;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.min;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class UserGeneratorUtils {

    private static final String SEPARATOR = ",";
    private static final String DEFAULT_EMAIL_DOMAIN = "@realworld.io";
    private static final int FIRST_NAME_MAX_LENGTH = 12;
    public static final String FIRST_NAME = "firstName";
    public static final String DEFAULT_PASSWORD = "passw0rd";

    public static User getRandomUser(){
        return User.builder()
                .username(makeStringRandom(FIRST_NAME))
                .email(generateRandomEmail())
                .password(DEFAULT_PASSWORD)
                .build();
    }


    public static String generateRandomEmail() {
        return generateRandomEmail(DEFAULT_EMAIL_DOMAIN);
    }

    public static String generateRandomEmail(String domain) {
        String emailDomain = domain;
        int length = 16;
        if (isBlank(domain)) {
            emailDomain = DEFAULT_EMAIL_DOMAIN;
        } else if (domain.contains(SEPARATOR)) {
            String[] split = domain.split(SEPARATOR);
            emailDomain = split[0];
            length = Integer.parseInt(split[1]);
        }
        return (randomAlphanumeric(length) + emailDomain).toLowerCase();
    }

    public static String makeStringRandom(String value) {
        if (value.length() < FIRST_NAME_MAX_LENGTH) {
            return value + randomAlphabetic(min(5, FIRST_NAME_MAX_LENGTH - value.length())).toLowerCase();
        }
        return shuffleString(value).substring(0, FIRST_NAME_MAX_LENGTH);
    }

    private static String shuffleString(String value) {
        List<Character> letters = value.chars().boxed().map(c -> (char) c.intValue()).collect(Collectors.toList());
        Collections.shuffle(letters);
        StringBuilder result = new StringBuilder(value.length());
        letters.forEach(result::append);
        return result.toString();
    }

}
