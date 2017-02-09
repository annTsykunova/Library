package com.epam.library.dao;


import com.epam.library.exception.DAOException;

import java.util.Map;

public interface EmployeeDao {
    Map<String, Integer> readMoreThanOneBook() throws DAOException;
    Map<String, Integer> readLessThanOrEqualTwoBook() throws DAOException;
    boolean updateBookByTitle(String newTitle, String oldTitle) throws DAOException;
}
