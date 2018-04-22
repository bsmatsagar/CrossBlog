package com.crossover.techtrial.repository;

import java.util.List;

<<<<<<< HEAD
import org.springframework.data.repository.PagingAndSortingRepository;
=======
import org.springframework.data.repository.CrudRepository;
>>>>>>> db7b55e04e8e64f5dd91a890dabfa09de3fa2f5e
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.crossover.techtrial.model.Comment;

@RepositoryRestResource(exported = false)
<<<<<<< HEAD
public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {
=======
public interface CommentRepository extends CrudRepository<Comment, Long> {
>>>>>>> db7b55e04e8e64f5dd91a890dabfa09de3fa2f5e

	@Override
	List<Comment> findAll();

	List<Comment> findByArticleIdOrderByDate(Long articleId);
}
