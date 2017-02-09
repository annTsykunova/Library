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
    public List<String> readMoreThanOneBook() throws ServiceException {
        List<String> reportList;
        try {
            reportList = EmployeeDaoImpl.getInstance().readMoreThanOneBook().entrySet()
                    .stream().map(entry -> entry.getKey() + " : " + entry.getValue())
                    .collect(Collectors.toList());
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return reportList;
    }

    @Override
    public List<String> readLessThanOrEqualTwoBook() throws ServiceException {
        List<String> reportList;
        try {
            reportList =  EmployeeDaoImpl.getInstance().readLessThanOrEqualTwoBook().entrySet()
                    .stream().map(entry -> entry.getKey() + " : " + entry.getValue())
                    .collect(Collectors.toList());
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return reportList;
    }

    @Override
    public boolean updateBookByTitle(String newTitle, String oldTitle) throws ServiceException {
        boolean flag;
        try {
            flag = EmployeeDaoImpl.getInstance().updateBookByTitle(newTitle, oldTitle);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return flag;
    }
    
}
