package com.epam.library.service;


import com.epam.library.entity.Employee;

import java.util.List;

public interface EmployeeService extends CrudService<Employee, Integer> {
    List<String> readMoreThanOneBook();
    List<String> readLessThanOrEqualTwoBook();
    boolean updateBookByTitle(String newTitle, String oldTitle);
}
