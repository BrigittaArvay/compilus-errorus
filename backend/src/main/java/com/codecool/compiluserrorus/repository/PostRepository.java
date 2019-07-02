package com.codecool.compiluserrorus.repository;

import com.codecool.compiluserrorus.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> getPostByOrderByPostingDateDesc();

    List<Post> getPostsByMember_EmailOrderByPostingDateDesc(@Param("userID") String email);
}