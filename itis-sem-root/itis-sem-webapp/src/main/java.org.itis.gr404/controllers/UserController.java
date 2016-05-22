package controllers;


import dao.UserRepository;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import validators.UserValidator;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserValidator userValidator;

    @RequestMapping(value = "/user/all", method = RequestMethod.GET)
    public String all(ModelMap model) {
        model.addAttribute("users", userRepository.getUsers());
        return "users";
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.GET)
    public Object addUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "addUser";
    }


    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute @Validated User user, BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "addUser";
        }
        try {
            userRepository.getUser(user.getId());
            userRepository.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            userRepository.createUser(user);
        }
        return "redirect:/user/all";
    }

    @RequestMapping(value = "/user/edit/{id}", method = RequestMethod.GET)
    public String editUser(ModelMap model, @PathVariable String id) {
        Object response = null;
        String error = "";
        try {
            response = userRepository.getUser(Integer.parseInt(id));
        } catch (Exception e) {
            error = e.getMessage();
        }
        model.addAttribute("error", error);
        model.addAttribute("user", response);
        return "user";
    }

    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.GET)
    public String deleteCustomer(@PathVariable String id) {
        userRepository.deleteUser(Integer.parseInt(id));
        return "redirect:/user/all";
    }
}
