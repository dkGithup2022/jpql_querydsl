package com.dk0124.prac.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class BlogPost {

	@Id
	@GeneratedValue
	@Column(name = "blog_post_id")
	private Long id;

	private String title;
	private String body;


	@Builder
	public BlogPost(Long id, String title, String body) {
		this.id = id;
		this.title = title;
		this.body = body;

	}
}
