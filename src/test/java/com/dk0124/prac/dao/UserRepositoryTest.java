package com.dk0124.prac.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.dk0124.prac.QueryDslConfig;
import com.dk0124.prac.entity.BlogPost;
import com.dk0124.prac.entity.User;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

//@DataJpaTest
@SpringBootTest
@ExtendWith(SpringExtension.class)
@Transactional
@Slf4j

class UserRepositoryTest {

	@Autowired
	EntityManager em;

	@Autowired
	UserRepository userRepository;

	@Autowired
	BlogPostRepository blogPostRepository;

	@Autowired
	UserRepositoryCustom userRepositoryCustom;

	@BeforeEach
	public void setUp() {
		User u1 = FixtureFactory.user()
			.name("u1").build();

		User u2 = FixtureFactory.user()
			.name("u2").build();

		User u3 = FixtureFactory.user()
			.name("u3").build();

		BlogPost u1b1 = FixtureFactory.blogPost()
			.title("u1_b1")
			.build();

		BlogPost u1b2 = FixtureFactory.blogPost()
			.title("u1_b2")
			.build();

		BlogPost u1b3 = FixtureFactory.blogPost()
			.title("u1_b3")
			.build();

		BlogPost u2b1 = FixtureFactory.blogPost()
			.title("u2_b1")
			.build();

		blogPostRepository.saveAll(Arrays.asList(u1b1,u1b2,u1b3, u2b1));

		u1.getBlogPosts().addAll(Arrays.asList(u1b1, u1b2, u1b3));
		userRepository.save(u1);

		u2.getBlogPosts().add(u2b1);
		userRepository.save(u2);

		userRepository.save(u3);

		em.flush();
		em.clear();

	}

	@Test
	public void checkSetUp(){

		List<BlogPost> posts = blogPostRepository.findAll();
		List<User> users = userRepository.findAll();

		log.info("Hello world");
	}

	@Test
	public  void simpleJPQL(){
		List<User> users = userRepository.findUserByBookTitle("u1_b2");

		assertNotNull(users);
	}


	@Test
	public void simpleQueryDsl(){
		List<User> users = userRepositoryCustom.usersHavePosts();

		assertNotNull(users);
	}
}