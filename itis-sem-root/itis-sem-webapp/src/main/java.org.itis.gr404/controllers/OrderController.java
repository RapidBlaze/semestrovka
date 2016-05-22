package controllers;


import dao.OrderRepository;
import dao.UserRepository;
import entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import validators.OrderValidator;

@Controller
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    OrderValidator orderValidator;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String all(ModelMap model) {
        model.addAttribute("orders", orderRepository.getOrders());
        return "orders";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String getOrderById(ModelMap model, @PathVariable String id) {
        model.addAttribute("order", orderRepository.getOrder(Integer.parseInt(id)));
        model.addAttribute("users", userRepository.getUsers());
        return "order";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addOrder(Model model) {
        model.addAttribute("order", new Order());
        model.addAttribute("customers", userRepository.getUsers());
        return "order";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
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
        return "redirect:/all";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteOrder(@PathVariable String id) {
        orderRepository.deleteOrder(Integer.parseInt(id));
        return "redirect:/all";
    }
}
