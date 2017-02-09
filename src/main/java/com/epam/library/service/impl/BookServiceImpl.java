package com.epam.library.service.impl;

import com.epam.library.dao.BookDao;
import com.epam.library.dao.impl.BookDaoImpl;
import com.epam.library.entity.Book;
import com.epam.library.exception.DAOException;
import com.epam.library.exception.ServiceException;
import com.epam.library.service.BookService;


public class BookServiceImpl implements BookService{
    private static BookService bookService;
    private BookDao bookDao = BookDaoImpl.getInstance();

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
        Book book;
        try {
            book = bookDao.getById(key);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return book;
    }

    @Override
    public Integer add(Book persistenceObject) throws ServiceException {
        Integer bookId;
        try {
            bookId = bookDao.add(persistenceObject);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return bookId;
    }

    @Override
    public boolean delete(Integer key) throws ServiceException {
        boolean flag;
        try {
            flag = bookDao.delete(key);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return flag;
    }

    @Override
    public boolean update(Book book) throws ServiceException {
        boolean flag;
        try {
            flag = bookDao.update(book);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return flag;
    }
}
