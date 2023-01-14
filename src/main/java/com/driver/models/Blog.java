package com.driver.models;

import com.driver.models.User;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table

public class Blog{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String content;
    @CreationTimestamp
    @Temporal(value= TemporalType.TIMESTAMP)
    private Date createdOn;

    @ManyToOne
    @JoinColumn
    private User user;

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL)
    private List<Image> imageList;

    public Blog(String title, String content, Date published) {
        this.title = title;
        this.content = content;
        this.createdOn= published;
    }

    public Blog() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }

    public int getId() {
        return id;
    }

    public Date getUpdatedOn() {
        return createdOn;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
}