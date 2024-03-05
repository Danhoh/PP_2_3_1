package web.controller;

import model.Role;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.UserService;


@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(@Qualifier("userServiceRepositoryImpl") UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String get(
            Model model
    ) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/add")
    public String post(
            @ModelAttribute("user") User user
    ) {
        System.out.println(user);
        userService.save(user);

        return "redirect:/";
    }
    @GetMapping("/delete")
    public String delete(
            @RequestParam long id
    ) {
        userService.removeById(id);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String update(
            @RequestParam long id,
            Model model
    ) {
        model.addAttribute("user", userService.findById(id));
        return "update";
    }

    @ModelAttribute("roles")
    public Role[] getRoles() {
        return Role.values();
    }
}
