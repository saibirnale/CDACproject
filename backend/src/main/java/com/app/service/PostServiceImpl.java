package com.app.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CategoryRepository;
import com.app.dao.CommentRepository;
import com.app.dao.PostRepository;
import com.app.pojos.Category;
import com.app.pojos.Post;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	PostRepository postRespository; 
	@Autowired
	CategoryRepository categoryRespository; 
	
	
	@Override
	public List<Post> findAll() {
		return postRespository.findAll();
	}

	@Override
	public Post findById(Long id) {
		Post abc=postRespository.findById(id).orElseThrow();
		return abc;
	}

	@Override
	public void deleteById(Long id) {
		postRespository.deleteById(id);
		
	}

	@Override
	public Post addPost(Post post,long id) {
		Category abc=categoryRespository.findById(id).orElseThrow();
		post.setCategories(abc);
		post.setPublishDate(Timestamp.valueOf(LocalDateTime.now()));
		//Post p=postRespository.save(post);
		Post p=postRespository.save(post);
//		Set<Post> setEntity=new HashSet<>();
//		setEntity=abc.getPosts();
//		setEntity.add(p);
//		abc.setPosts(setEntity);
		return p;
	}

//	@Override
//	public List<Post> findByCategories(String categoryName) {
//		List<Post> listEntity=new ArrayList<>();
//		Category categories=categoryRepository.findByName(categoryName);
//		listEntity.addAll(categories.getPosts());
//		return listEntity;
//	}

	@Override
	public Post addPost(Post post) {
		// TODO Auto-generated method stub
		return postRespository.save(post);
	}

	//@Override
//	public Post addPostByName(Post post, String name) {
	//	Category abc=categoryRespository.findByName(name);
	//	post.setCategories(abc);
	//	post.setPublishDate(Timestamp.valueOf(LocalDateTime.now()));
	//	return postRespository.save(post);
		
	//}

	@Override
	public Post getPost(long id) {
		return postRespository.getById(id);
	}

	@Override
	public Post addPostByName(Post post, String name) {
		// TODO Auto-generated method stub
		return null;
	}


   
}