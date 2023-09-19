package com.dk0124.prac.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dk0124.prac.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {

	@Query("select u from User u join u.blogPosts bp where bp.title = :title")
	public List<User> findUserByBookTitle(@Param("title" ) String title);

}
