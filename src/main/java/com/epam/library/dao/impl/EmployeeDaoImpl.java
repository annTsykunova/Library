package com.epam.library.dao.impl;


import com.epam.library.config.DataSource;
import com.epam.library.dao.EmployeeDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class EmployeeDaoImpl implements EmployeeDao {
    private static final String SQL_READ_MORE_THAN_ONE = "SELECT EMPLOYEE.NAME, COUNT(BOOK_ID) as NUMBER_OF_BOOKS " +
            "FROM EMPLOYEE JOIN EMPLOYEE_BOOK ON EMPLOYEE.ID = EMPLOYEE_ID GROUP BY NAME " +
            "HAVING COUNT(BOOK_ID) > 1 ORDER BY NUMBER_OF_BOOKS";
    private static final String SQL_READ_LESS_THAN_TWO = "SELECT EMPLOYEE.NAME, EMPLOYEE.DATE_OF_BIRTH, " +
            "COUNT(BOOK_ID) as NUMBER_OF_BOOKS FROM EMPLOYEE JOIN EMPLOYEE_BOOK ON EMPLOYEE.ID = EMPLOYEE_ID " +
            "GROUP BY NAME, DATE_OF_BIRTH HAVING COUNT(BOOK_ID) <= 2 ORDER BY NUMBER_OF_BOOKS DESC, DATE_OF_BIRTH";
    private static final String SQL_UPDATE_BY_TITLE = "UPDATE BOOK SET BOOK.TITLE = ? WHERE BOOK.TITLE = ?";

    private static EmployeeDao employeeDao;

    private EmployeeDaoImpl() {
    }

    public static EmployeeDao getInstance() {
        if (employeeDao == null) {
            employeeDao = new EmployeeDaoImpl();
            return employeeDao;
        } else {
            return employeeDao;
        }
    }

    @Override
    public Map<String, Integer> readMoreThanOneBook() {
        Map<String, Integer> result = Collections.emptyMap();
        try(Connection connection = DataSource.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_READ_MORE_THAN_ONE);
        ){
            ResultSet set = statement.executeQuery();
            result = new HashMap<>();
            while (set.next()){
                String name = set.getString(1);
                int numberOfBooks = set.getInt(2);
                result.put(name, numberOfBooks);
            }
        }catch (Exception e){

        }
        return result;
    }

    @Override
    public Map<String, Integer> readLessThanOrEqualTwoBook() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
        Map<String, Integer> result = Collections.emptyMap();
        try(Connection connection = DataSource.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_READ_LESS_THAN_TWO);
        ){
            ResultSet set = statement.executeQuery();
            result = new HashMap<>();
            while (set.next()){
                String resultInfo = set.getString(1) + dateFormat.format(set.getDate(2));
                Integer numberOfBooks = set.getInt(3);
                result.put(resultInfo, numberOfBooks);
            }
        }catch (Exception e){

        }
        return result;
    }

    @Override
    public boolean updateBookByTitle(String newTitle, String oldTitle) {
        boolean flag = false;
        try(
                Connection connection = DataSource.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_BY_TITLE);
        ){
            statement.setString(1, newTitle);
            statement.setString(2, oldTitle);
            statement.executeUpdate();
            flag = true;
        }catch (Exception e){

        }
        return flag;
    }
}
