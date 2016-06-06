package org.itis.gr404.validators;


import org.itis.gr404.entity.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class OrderValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Order.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Order order = (Order) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "product", "product.empty", "Не может быть пустым");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "userId.empty", "Не может быть пустым");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "price.empty", "Не может быть пустым");
        if (order.getPrice() < 0) {
            errors.rejectValue("price", "price.min", "Цена не может быть отрицательной");
        }
    }
}
