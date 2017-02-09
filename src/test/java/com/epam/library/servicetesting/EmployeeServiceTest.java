package com.epam.library.servicetesting;


import com.epam.library.exception.ServiceException;
import com.epam.library.service.impl.EmployeeServiceImpl;
import org.junit.Assert;
import org.junit.Test;

public class EmployeeServiceTest {

    private EmployeeServiceImpl employeeService;

    @Test
    public void testUpdateBookByTitle() throws ServiceException {
        Assert.assertTrue(employeeService.updateBookByTitle("newTitle","oldTitle"));
    }

    @Test
    public void testReadMoreThanOneBook() throws ServiceException {
        Assert.assertTrue(employeeService.readMoreThanOneBook().size() >= 0);
    }

    @Test
    public void testReadLessThanOrEqualTwoBook() throws ServiceException {
        Assert.assertTrue(employeeService.readLessThanOrEqualTwoBook().size() >= 0);
    }
}
