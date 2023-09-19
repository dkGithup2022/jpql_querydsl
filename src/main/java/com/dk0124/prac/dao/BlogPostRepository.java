package com.dk0124.prac.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dk0124.prac.entity.BlogPost;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {

}
