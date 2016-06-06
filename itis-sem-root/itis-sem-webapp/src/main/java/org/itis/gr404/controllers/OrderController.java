package org.itis.gr404.controllers;



import org.itis.gr404.crud.OrderRepository;
import org.itis.gr404.crud.UserRepository;
import org.itis.gr404.entity.Order;
import org.itis.gr404.validators.OrderValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    OrderValidator orderValidator;

    @RequestMapping(value = "/order/all", method = RequestMethod.GET)
    public String all(ModelMap model) {
        model.addAttribute("orders", orderRepository.getOrders());
        return "orders";
    }

    @RequestMapping(value = "/order/edit/{id}", method = RequestMethod.GET)
    public String getOrderById(ModelMap model, @PathVariable String id) {
        model.addAttribute("order", orderRepository.getOrder(Integer.parseInt(id)));
        model.addAttribute("users", userRepository.getUsers());
        return "order";
    }

    @RequestMapping(value = "/order/add", method = RequestMethod.GET)
    public String addOrder(Model model) {
        model.addAttribute("order", new Order());
        model.addAttribute("users", userRepository.getUsers());
        return "order";
    }

    @RequestMapping(value = "/order/add", method = RequestMethod.POST)
    public String addOrder(@ModelAttribute Order order, BindingResult result, Model model) {
        orderValidator.validate(order, result);
        if (result.hasErrors()) {
            model.addAttribute("users", userRepository.getUsers());
            return "order";
        }
        order.setUser(userRepository.getUser(order.getUserId()));
        if (orderRepository.getOrder(order.getId()) != null) {
            orderRepository.updateOrder(order);
        } else{
            orderRepository.createOrder(order);
        }
        return "redirect:/order/all";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteOrder(@PathVariable String id) {
        orderRepository.deleteOrder(Integer.parseInt(id));
        return "redirect:/order/all";
    }
}
