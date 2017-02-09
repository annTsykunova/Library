package com.epam.library.dao.impl;


import com.epam.library.config.DataSource;
import com.epam.library.dao.BookDao;

import com.epam.library.entity.Book;
import com.epam.library.exception.DAOException;

import java.sql.*;

public class BookDaoImpl implements BookDao {
    private static final String SQL_INSERT_BOOK = "insert into book (title, brief, publish_year, author) values (?,?,?,?)";
    private static final String SQL_FIND_BOOK_BY_ID = "select id, title, brief, publish_year, author from book where id = ?";
    private static final String SQL_DELETE_BOOK_BY_ID = "delete from book where id = ?";
    private static final String SQL_UPDATE_BOOK_BY_ID = "update book set title = ?, brief = ?, year = ?, author = ? where id = ?";

    private static BookDao bookDao;

    private BookDaoImpl() {
    }

    public static BookDao getInstance() {
        if (bookDao == null) {
            bookDao = new BookDaoImpl();
            return bookDao;
        } else {
            return bookDao;
        }
    }

    @Override
    public Book getById(Integer key) throws DAOException {
        DataSource dataSource = DataSource.getInstance();
        Book book = new Book();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_BOOK_BY_ID)
        ) {
            statement.setInt(1, key);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                book.setId(resultSet.getInt("id"));
                book.setBrief(resultSet.getString("brief"));
                book.setTitle(resultSet.getString("title"));
                book.setAuthor(resultSet.getString("author"));
                book.setYear(resultSet.getInt("publish_year"));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }

        return book;
    }

    @Override
    public Integer add(Book book) throws DAOException {
        DataSource dataSource = DataSource.getInstance();
        Integer id = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_BOOK, Statement.RETURN_GENERATED_KEYS)
        ) {
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getBrief());
            preparedStatement.setInt(3, book.getYear());
            preparedStatement.setString(4, book.getAuthor());

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                id = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return id;
    }

    @Override
    public boolean delete(Integer key) throws DAOException {
        DataSource dataSource = DataSource.getInstance();
        boolean result;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_DELETE_BOOK_BY_ID)
        ) {
            statement.setInt(1, key);
            result = statement.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new DAOException(e);
        }

        return result;
    }

    @Override
    public boolean update(Book book) throws DAOException {
        DataSource dataSource = DataSource.getInstance();
        boolean result;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_BOOK_BY_ID)
        ) {
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getBrief());
            statement.setInt(3, book.getYear());
            statement.setString(4, book.getAuthor());

            result = statement.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new DAOException(e);
        }

        return result;
    }
}
