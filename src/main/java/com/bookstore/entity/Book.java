package com.bookstore.entity;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Table(name = "book", indexes = {
        @Index(name = "title_UNIQUE", columnList = "title", unique = true),
        @Index(name = "category_fk_idx", columnList = "category_id")
})
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false, length = 128)
    private String title;

    @Column(name = "author", nullable = false, length = 64)
    private String author;

    @Lob
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "isbn", nullable = false, length = 15)
    private String isbn;

    @Column(name = "image", nullable = false)
    private byte[] image;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "publish_date", nullable = false)
    private LocalDate publishDate;

    @Column(name = "last_update_time", nullable = false)
    private Instant lastUpdateTime;

    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private Set<Review> reviews = new LinkedHashSet<>();

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Instant getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Instant lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}