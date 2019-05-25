package pl.mateusz.ministack.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/user/dashboard")
    public String dashboard() {
        return "user/dashboard";
    }
}