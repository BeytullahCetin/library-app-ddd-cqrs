package com.turkcell.library_app_ddd_cqrs.domain.book.model;



import java.time.LocalDate;

public class Book {
	private final BookId id;
    private String title;
    private String isbn;
    private int pageCount;
    private LocalDate publishDate;

    private Book(BookId id, String title, String isbn, int pageCount, LocalDate publishDate) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.pageCount = pageCount;
        this.publishDate = publishDate;
    }

    public static Book create(String title, String isbn, int pageCount, LocalDate publishDate){
        validateName(title);
        validateName(isbn);
        validatePublishDate(publishDate);
        return new Book(BookId.generate(),title,isbn,pageCount,publishDate);
    }

    private static void validateName(String name) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Name cannot be null or empty!");

        if (name.length() >= 255)
            throw new IllegalArgumentException("Name length must be less than 255 characters!");
    }

    private static void validatePublishDate(LocalDate publishDate) {
        if (publishDate == null)
            throw new IllegalArgumentException("Publish date cannot be null!");
    }

    public static void validatePageCount(int pageCount){
        if (pageCount <= 0) {
            throw new IllegalArgumentException("Page count must be greater than zero. Given: " + pageCount);
        }
    }

    public static Book rehydrate(BookId id,String title, String isbn, int pageCount, LocalDate publishDate) {
        return new Book(id,title,isbn,pageCount,publishDate);
    }

    public void changeTitle(String title){
        validateName(title);
        this.title=title;
    }

    public void changeIsbn(String isbn){
        validateName(isbn);
        this.isbn=isbn;
    }

    public void changePublishDate(LocalDate publishDate){
        validatePublishDate(publishDate);
        this.publishDate=publishDate;
    }

    public void changePageCount(int pageCount){
        validatePageCount(pageCount);
        this.pageCount=pageCount;
    }

    public BookId getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPageCount() {
        return pageCount;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }
}
