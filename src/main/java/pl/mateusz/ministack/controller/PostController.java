package pl.mateusz.ministack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.mateusz.ministack.model.entity.UserEntity;
import pl.mateusz.ministack.model.form.PostForm;
import pl.mateusz.ministack.model.service.PostService;
import pl.mateusz.ministack.model.service.SessionService;

@Controller
public class PostController {

    @Autowired
    PostService postService;
    @Autowired
    SessionService sessionService;

    @GetMapping("/post/add")
    public String addPost(Model model) {
        if (!sessionService.isLogin()) {
            return "redirect:/user/login";
        }
        model.addAttribute("postForm", new PostForm());
        return "post/add_post";
    }

    @PostMapping("/post/add")
    public String addPost(@ModelAttribute PostForm postForm,
                          RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("info", "Dodano nowy post");
        postService.addPost(postForm);
        //System.out.println(postForm);
        return "redirect:/user/dashboard";
    }

    @GetMapping("/post/delete/{id}")
    public String deletePost(@PathVariable("id") int id) {
        if (sessionService.getAccountType() != UserEntity.AccountType.ADMIN) {
            return "redirect:/user/dashboard";
        }

        postService.deletePost(id);
        return "redirect:/user/dashboard";
    }

}
