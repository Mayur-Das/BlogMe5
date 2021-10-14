package com.BlogMe.entities;

import javax.persistence.*;
import java.security.PrivateKey;

@Entity
@Table(name="blog")
public class Blog {

    //MAKING PRIMARY KEY
    @Id
    private Long  blogid;

    private String blogtitle;
    private String blogauthor;
    private String blogdetail;

    public Long getBlogid() {
        return blogid;
    }

    public void setBlogid(Long blogid) {
        this.blogid = blogid;
    }

    public String getBlogtitle() {
        return blogtitle;
    }

    public void setBlogtitle(String blogtitle) {
        this.blogtitle = blogtitle;
    }

    public String getBlogauthor() {
        return blogauthor;
    }

    public void setBlogauthor(String blogauthor) {
        this.blogauthor = blogauthor;
    }

    public String getBlogdetail() {
        return blogdetail;
    }

    public void setBlogdetail(String blogdetail) {
        this.blogdetail = blogdetail;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "blogid=" + blogid +
                ", blogtitle='" + blogtitle + '\'' +
                ", blogauthor='" + blogauthor + '\'' +
                ", blogdetail='" + blogdetail + '\'' +
                '}';
    }
}
