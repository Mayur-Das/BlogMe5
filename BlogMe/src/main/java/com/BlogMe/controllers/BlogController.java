package com.BlogMe.controllers;

import com.BlogMe.cusexception.BlogException;
import com.BlogMe.entities.Blog;
import com.BlogMe.repos.BlogRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@Slf4j
public class BlogController {

    @Autowired
    private BlogRepo blogRepoobj;

    @RequestMapping(value = "/add/", method = RequestMethod.POST)
    public Blog createProduct(@RequestBody Blog blog) {

        return blogRepoobj.save(blog);
    }

    @RequestMapping(value = "/findbyid/{id}", method = RequestMethod.GET)
    public ResponseEntity<Blog> getBlogById(@PathVariable("id") Long id) {
        log.error(String.valueOf(id));
        log.info(String.valueOf(id));
        return new ResponseEntity<Blog>(blogRepoobj.findById(id).get(), HttpStatus.OK);
    }


    @RequestMapping(value = "/deletebyid/{id}", method = RequestMethod.DELETE)
    public void deleteBlogById(@PathVariable("id") Long id) {
        blogRepoobj.deleteById(id);
    }

    @RequestMapping(value = "/findallblog/", method = RequestMethod.GET)
    public List<Blog> getAllBolg() {
        if(blogRepoobj.findAll().isEmpty()){
               throw new BlogException("");
        }
        return blogRepoobj.findAll();
    }

    @RequestMapping(value = "/updateblog/", method = RequestMethod.PUT)
    public Blog updateblog(@RequestBody Blog blog) {
        Blog existingProduct = blogRepoobj.findById(blog.getBlogid()).orElse(null);
        existingProduct.setBlogtitle(blog.getBlogtitle());
        existingProduct.setBlogauthor(blog.getBlogauthor());
        existingProduct.setBlogdetail(blog.getBlogdetail());
        return blogRepoobj.save(blog);
    }
}




