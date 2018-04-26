package com.crossover.techtrial.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.crossover.techtrial.model.Article;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ArticleControllerTest {

	@Autowired
	private TestRestTemplate template;

	@Before
	public void setup() throws Exception {

	}
	 private MockMvc mockMvc;
	

	@Test
	public void testArticleShouldBeCreated() throws Exception {
		HttpEntity<Object> article = getHttpEntity("{\"email\": \"user1@gmail.com\", \"title\": \"hello\" }");
		ResponseEntity<Article> resultAsset = template.postForEntity("/articles", article, Article.class);
		Assert.assertNotNull(resultAsset.getBody().getId());
	}
	
	 @Test
	    public void testgetArticleById() throws Exception {
		 ResponseEntity<Article> responseEntity = template.getForEntity("/articles/{article-id}", 
				  Article.class, 
				  new Long(1));
				 
				  // collect response
				  int status = responseEntity.getStatusCodeValue();
				  Article resultalrticle = responseEntity.getBody();
				 
				  // verify
				  assertEquals("Incorrect Response Status", HttpStatus.OK.value(), status);
				 
				  assertNotNull(resultalrticle);
				  assertEquals(1l, resultalrticle.getId().longValue());
	    }
	 @Test
	 public void testupdateArticle() throws Exception {
	
			Article article = new Article();
			HttpEntity<Article> requestEntity = new HttpEntity<Article>(article);
			 
			  // execute
			  ResponseEntity<Article> responseEntity = template.exchange("/articles/{id}", 
			  HttpMethod.PUT, 
			  requestEntity, 
			  Article.class);
			 
			  // verify
			  int status = responseEntity.getStatusCodeValue();
			  assertEquals("Incorrect Response Status", HttpStatus.OK.value(), status);
			
		 
	 }
	 
	 @Test
	 public void testdeleteArticleById() throws Exception {
		 
		  ResponseEntity<Article> responseEntity = template.exchange("/articles/{article-id}", 
		  HttpMethod.DELETE, 
		  null, 
		  Article.class,
		  new Long(1));
		
		  int status = responseEntity.getStatusCodeValue();
		  assertEquals("Incorrect Response Status", HttpStatus.GONE.value(), status);
		 
		}
	 
	
	 
	private HttpEntity<Object> getHttpEntity(Object body) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return new HttpEntity<Object>(body, headers);
	}
}
