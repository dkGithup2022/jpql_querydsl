package com.dk0124.prac.dao;

import static com.dk0124.prac.entity.QBlogPost.*;
import static com.dk0124.prac.entity.QUser.*;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.dk0124.prac.entity.User;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserRepositoryCustom {

	private final JPAQueryFactory jpaQueryFactory;

	public List<User> usersHavePosts(){
		return jpaQueryFactory.selectFrom(user)
			.join(user.blogPosts, blogPost)
			.groupBy(user.id)
			.having(blogPost.count().gt(2))
			.fetch()
			;
	}
}
