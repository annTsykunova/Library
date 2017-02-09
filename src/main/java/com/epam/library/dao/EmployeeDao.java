package com.epam.library.dao;


import java.util.Map;

public interface EmployeeDao {
    Map<String, Integer> readMoreThanOneBook();
    Map<String, Integer> readLessThanOrEqualTwoBook();
    boolean updateBookByTitle(String newTitle, String oldTitle);
}
