package com.bookstore.entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Table(name = "category")
@Entity
@NamedQueries({
        @NamedQuery(name = "Category.findAll", query = "select c from Category c order by c.id desc"),
        @NamedQuery(name = "Category.countAll", query = "select Count(*) from Category c"),
        @NamedQuery(name = "Category.findByName", query = "select c from Category c where c.name = :name")
})
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<Book> books = new LinkedHashSet<>();

    public Category(String name) {
        this.name = name;
    }

    public Category() {

    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}