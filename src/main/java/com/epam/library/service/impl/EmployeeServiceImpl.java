package com.epam.library.service.impl;


import com.epam.library.dao.impl.EmployeeDaoImpl;

import com.epam.library.entity.Employee;
import com.epam.library.exception.DAOException;
import com.epam.library.exception.ServiceException;
import com.epam.library.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeService{
    private static EmployeeService employeeService;

    private EmployeeServiceImpl() {
    }

    public static EmployeeService getInstance() {
        if (employeeService == null) {
            employeeService = new EmployeeServiceImpl();
            return employeeService;
        } else {
            return employeeService;
        }
    }

    @Override
    public List<String> readMoreThanOneBook() {
        return EmployeeDaoImpl.getInstance().readMoreThanOneBook().entrySet()
                .stream().map(entry -> entry.getKey() + " : " + entry.getValue())
                .collect(Collectors.toList());
    }

    @Override
    public List<String> readLessThanOrEqualTwoBook() {
        return EmployeeDaoImpl.getInstance().readLessThanOrEqualTwoBook().entrySet()
                .stream().map(entry -> entry.getKey() + " : " + entry.getValue())
                .collect(Collectors.toList());
    }

    @Override
    public boolean updateBookByTitle(String newTitle, String oldTitle) {
        return EmployeeDaoImpl.getInstance().updateBookByTitle(newTitle, oldTitle);
    }

    @Override
    public Employee getById(Integer key) throws ServiceException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Integer add(Employee persistenceObject) throws ServiceException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(Integer key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean update(Employee employee) {
        throw new UnsupportedOperationException();
    }
}
