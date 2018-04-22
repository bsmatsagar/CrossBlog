package com.crossover.techtrial.repository;

import java.util.List;
<<<<<<< HEAD

import org.springframework.data.repository.CrudRepository;

=======
import org.springframework.data.repository.CrudRepository;
>>>>>>> db7b55e04e8e64f5dd91a890dabfa09de3fa2f5e
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.crossover.techtrial.model.Article;

@RepositoryRestResource(exported = false)
public interface ArticleRepository extends CrudRepository<Article, Long> {
<<<<<<< HEAD
    
	
=======

>>>>>>> db7b55e04e8e64f5dd91a890dabfa09de3fa2f5e
	List<Article> findTop10ByTitleContainingIgnoreCase(String title);

}
