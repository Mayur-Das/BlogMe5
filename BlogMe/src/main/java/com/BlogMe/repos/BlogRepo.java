package com.BlogMe.repos;

import com.BlogMe.entities.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public interface BlogRepo extends JpaRepository<Blog, Long> {
}
