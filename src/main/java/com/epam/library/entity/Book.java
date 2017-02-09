package com.epam.library.entity;


public class Book {
    private Integer id;
    private String title;
    private String brief;
    private Integer year;
    private String author;

    public Book() {
    }

    public Book(Integer id, String title, String brief, Integer year, String author) {
        this.id = id;
        this.title = title;
        this.brief = brief;
        this.year = year;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (!id.equals(book.id)) return false;
        if (!title.equals(book.title)) return false;
        if (!brief.equals(book.brief)) return false;
        if (!year.equals(book.year)) return false;
        return author.equals(book.author);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + brief.hashCode();
        result = 31 * result + year.hashCode();
        result = 31 * result + author.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", brief='" + brief + '\'' +
                ", year=" + year +
                ", author='" + author + '\'' +
                '}';
    }
}
