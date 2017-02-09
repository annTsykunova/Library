package com.epam.library.service;


import com.epam.library.entity.Employee;
import com.epam.library.exception.DAOException;
import com.epam.library.exception.ServiceException;

import java.util.List;

public interface EmployeeService  {
    List<String> readMoreThanOneBook() throws ServiceException;
    List<String> readLessThanOrEqualTwoBook() throws ServiceException;
    boolean updateBookByTitle(String newTitle, String oldTitle) throws ServiceException;
}
