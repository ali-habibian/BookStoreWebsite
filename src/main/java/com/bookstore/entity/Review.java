package com.bookstore.entity;

import javax.persistence.*;
import java.time.Instant;

@Table(name = "review", indexes = {
        @Index(name = "customer_fk_idx", columnList = "customer_id"),
        @Index(name = "book_fk_idx", columnList = "book_id")
})
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(name = "rating", nullable = false)
    private Integer rating;

    @Column(name = "headline", nullable = false, length = 128)
    private String headline;

    @Column(name = "comment", nullable = false, length = 500)
    private String comment;

    @Column(name = "review_time", nullable = false)
    private Instant reviewTime;

    public Instant getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(Instant reviewTime) {
        this.reviewTime = reviewTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}