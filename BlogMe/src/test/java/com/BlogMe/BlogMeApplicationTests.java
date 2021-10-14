package com.BlogMe;


import com.BlogMe.controllers.BlogController;
import com.BlogMe.entities.Blog;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BlogMeApplicationTests {


    @Value("${productresapi.services.url}")
    public String  baseURL;



    @BeforeEach
    void BeforeEach() {
        System.out.println("--> THIS METHOD WILL GET EXECUTED BEFORE EACH TEST CASE METHOD");

    }

    @AfterEach
    void AfterEach() {
        System.out.println("--> THIS METHOD WILL GET EXECUTED AFTER EACH TEST CASE METHOD");

    }


	@Test
	void RestEndPointTestFindByIdNullCheck() {
        RestTemplate restTemplate = new RestTemplate();
        Blog blog = restTemplate.getForObject(baseURL+"findbyid/"+"2", Blog.class);
        System.out.println("RestEndPointTestFindByIdNullCheck");
        assertNotNull(blog);

    }

    @Test
    void RestEndPointTestFindByIdEqualCheck() {
        RestTemplate restTemplate = new RestTemplate();
        Blog blog = restTemplate.getForObject(baseURL+"findbyid/"+"2", Blog.class);
        System.out.println("RestEndPointTestFindByIdEqualCheck");
        assertEquals("A", blog.getBlogtitle());

    }

    @Test
    void IllegalArgumentException() {
        BlogController blogController = new BlogController();

       assertThrows(IllegalArgumentException.class, ()->{
           blogController.getBlogById(null);
           System.out.println("IllegalArgumentException");
       });



    }


}
