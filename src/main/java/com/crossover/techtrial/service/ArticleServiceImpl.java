package com.crossover.techtrial.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crossover.techtrial.model.Article;
import com.crossover.techtrial.repository.ArticleRepository;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	ArticleRepository articleRepository;

	public Article save(Article article) {
		return articleRepository.save(article);
	}

	public Article findById(Long id) {
		return articleRepository.findById(id).orElse(null);
	}

	
	public void updateArticle(Article article) {
		articleRepository.save(article);
	}
	
	
	public void delete(Long id) {
		articleRepository.deleteById(id);
	}
	

	public List<Article> search(String search) {
		List<Article> list = new ArrayList<>();
		articleRepository.findAll().forEach(e -> list.add(e));
		 
	       	return articleRepository.findTop10ByTitleContainingIgnoreCase(list);
	}

}