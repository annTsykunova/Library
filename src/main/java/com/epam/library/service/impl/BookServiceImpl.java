package com.epam.library.service.impl;

import com.epam.library.entity.Book;
import com.epam.library.exception.ServiceException;
import com.epam.library.service.BookService;


public class BookServiceImpl implements BookService{
    private static BookService bookService;

    private BookServiceImpl() {
    }

    public static BookService getInstance() {
        if (bookService == null) {
            bookService = new BookServiceImpl();
            return bookService;
        } else {
            return bookService;
        }
    }

    @Override
    public Book getById(Integer key) throws ServiceException {
        return BookServiceImpl.getInstance().getById(key);
    }

    @Override
    public Integer add(Book persistenceObject) throws ServiceException {
        return BookServiceImpl.getInstance().add(persistenceObject);
    }

    @Override
    public boolean delete(Integer key) throws ServiceException {
        return BookServiceImpl.getInstance().delete(key);
    }

    @Override
    public boolean update(Book book) throws ServiceException {
        return BookServiceImpl.getInstance().update(book);
    }
}
