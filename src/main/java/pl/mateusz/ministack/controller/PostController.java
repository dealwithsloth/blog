package pl.mateusz.ministack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.mateusz.ministack.model.form.PostForm;

@Controller
public class PostController {
    @GetMapping("/post/add")
    public String addPost (Model model){
        model.addAttribute("postForm", new PostForm());
        return "post/add_post";
    }
    @PostMapping("/post/add")
    public String addPost (@ModelAttribute PostForm postForm){
        System.out.println(postForm);
        return "redirect:/user/dashboard";
    }

}
