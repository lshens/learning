package com.arcone.learning.validator.secret;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static java.util.Objects.isNull;
import static java.util.regex.Pattern.matches;
import static org.springframework.http.HttpMethod.POST;

@Component
public class SecretValidator implements ConstraintValidator<Secret, String>, ApplicationContextAware {
    /**
     * The secret must have:
     * 1 number and
     * 1 special char and
     * size of 8.
     */
    private static final String SECRET_PATTERN = "^(?=.*[0-9])(?=.*[!@#$%^&*()_+{}\\[\\]:;<>,.?~]).{8,}$";
    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (POST.equals(getHttpStatus())) {
            if (isNull(value) || value.isBlank()) {
                return false;
            }
            return matches(SECRET_PATTERN, value);
        } else {
            return true;
        }
    }

    public HttpMethod getHttpStatus() {
        try {
            return this.context.getBean(HttpRequest.class).getMethod();
        } catch (BeansException ex) {
            return POST;
        }
    }

}

