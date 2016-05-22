package validators;

import entity.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        //User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "label.validate.firstnameEmpty", "Не может содержать пробелы или быть пустым");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "label.validate.lastnameEmpty", "Не может содержать пробелы или быть пустым");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "label.validate.ageEmpty", "Не может содержать пробелы или быть пустым");
    }
}
