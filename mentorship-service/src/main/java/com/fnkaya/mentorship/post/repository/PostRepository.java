package com.fnkaya.mentorship.post.repository;

import com.fnkaya.mentorship.post.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, String> {

    Page<Post> findByCategoryName(String category, Pageable pageable);
}
