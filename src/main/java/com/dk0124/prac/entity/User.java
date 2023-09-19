package com.dk0124.prac.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.junit.jupiter.api.Test;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "\"user\"")
public class User {
	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private Long id;

	private String name;

	private Boolean disabled;

	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "user_id")
	private List<BlogPost> blogPosts = new ArrayList();

	@Builder
	public User(Long id, String name, Boolean disabled, List<BlogPost> blogPosts) {
		this.id = id;
		this.name = name;
		this.disabled = disabled;
		this.blogPosts = blogPosts == null ? new ArrayList<>() : blogPosts;
	}
}
