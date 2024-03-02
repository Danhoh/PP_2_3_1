package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {
    @GetMapping("/")
    public String test(
            Model model,
            @RequestParam(value = "a", defaultValue = "def") String a
    ) {
        model.addAttribute("a", a);
        return "index";
    }
}
