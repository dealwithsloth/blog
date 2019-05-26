package pl.mateusz.ministack.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mateusz.ministack.model.entity.PostEntity;
import pl.mateusz.ministack.model.entity.UserEntity;
import pl.mateusz.ministack.model.form.PostForm;
import pl.mateusz.ministack.model.repository.PostRepository;

@Service
public class PostService {
    @Autowired
    SessionService sessionService;
    @Autowired
    PostRepository postRepository;

    public void addPost(PostForm postForm) {
        PostEntity post = new PostEntity();
        post.setTitle(postForm.getTitle());
        post.setContent(postForm.getContent());

        UserEntity user = new UserEntity();
        user.setId(sessionService.getUserId());

        post.setUser(user);

        postRepository.save(post);

    }

    public Iterable<PostEntity> getAllPosts() {
        return postRepository.findTop10ByOrderByIdDesc();
    }
}
