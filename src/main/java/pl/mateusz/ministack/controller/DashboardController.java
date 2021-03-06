package pl.mateusz.ministack.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.mateusz.ministack.model.service.PostService;
import pl.mateusz.ministack.model.service.SessionService;

@Controller
public class DashboardController {

    @Autowired
    SessionService sessionService;

    @Autowired
    PostService postService;

    @GetMapping("/user/dashboard")
    public String dashboard(Model model) {
        if(!sessionService.isLogin()){
            return "redirect:/user/login";
        }

        model.addAttribute("posts", postService.getAllPosts());
        return "user/dashboard";
    }
}