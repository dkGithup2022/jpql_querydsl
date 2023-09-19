package com.dk0124.prac.dao;


import com.dk0124.prac.entity.BlogPost;
import com.dk0124.prac.entity.User.UserBuilder;
import com.dk0124.prac.entity.BlogPost.BlogPostBuilder;
import com.dk0124.prac.entity.User;

public class FixtureFactory {

	public static UserBuilder user(){
		return User.builder().
			name("유저")
			.disabled(false);
	}

	public static BlogPostBuilder blogPost(){
		return BlogPost.builder()
			.body("아무 내용 ~")
			;
	}
}
