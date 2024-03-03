package web.controller;

import model.Role;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;


@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(@Qualifier("userServiceImpl") UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String get(
            Model model
    ) {
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }

    @PostMapping("/add")
    public String post(
            Model model,
            HttpServletRequest request
    ) {
        User user = new User(
                request.getParameter("username"),
                request.getParameter("firstName"),
                request.getParameter("lastName"),
                Date.valueOf(request.getParameter("age")).toLocalDate(),
                Role.valueOf(request.getParameter("role"))
        );
        if (request.getParameter("id") != null) {
            user.setId(Long.parseLong(request.getParameter("id")));
        }

        userService.save(user);
        System.out.println(user);

        return "redirect:/";
    }
    @GetMapping("/delete")
    public String delete(
            @RequestParam long id
    ) {
        System.out.println("removing user with id " + id);
        userService.removeById(id);
        return "redirect:/";
    }
}
