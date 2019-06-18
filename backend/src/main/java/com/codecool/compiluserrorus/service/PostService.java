package com.codecool.compiluserrorus.service;

import com.codecool.compiluserrorus.model.Post;
import com.codecool.compiluserrorus.repository.PostRepository;
import com.codecool.compiluserrorus.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getOrderedPosts() {
        List<Post> posts = postRepository.getPostByOrderByPostingDateDesc();
//        List<Post> posts = postRepository.getPostByMemberIdOrderByPostingDateDesc(1);

        posts.forEach(post -> post.setRomanDate(Util.setRomanDate(post.getPostingDate())));
        return posts;
    }

    public void addPost(Post post) {
        postRepository.save(post);
    }

    public Post updatePost(Long id, Post post) {
        Post amendPost = postRepository.findById(id).orElse(null);
        assert amendPost != null;
        amendPost.setMessage(post.getMessage());
        amendPost.setLikes(post.getLikes());
        amendPost.setDislikes(post.getDislikes());
        amendPost.setImage(post.getImage());

        postRepository.save(amendPost);
        return amendPost;
    }

    public void deletePost(Long id) {
        Post deletablePost = postRepository.findById(id).orElse(null);
        assert deletablePost != null;
        postRepository.delete(deletablePost);
    }

}
