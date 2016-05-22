package validators;


import entity.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class OrderValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Order.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        //Order order = (Order) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "product", "product.empty", "Не может быть пустым");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "userId.empty", "Не может быть пустым");
    }
}
