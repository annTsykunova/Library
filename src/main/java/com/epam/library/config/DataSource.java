package com.epam.library.config;


import org.apache.commons.dbcp.BasicDataSource;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class DataSource {
    public static final String DRIVER = "driver";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String URL = "url";
    public static final Integer MIN_IDLE = 5;
    public static final Integer MAX_IDLE = 20;
    public static final Integer MAX_PREPARED_STATEMENTS = 180;
    private static DataSource datasource;
    private BasicDataSource ds;

    private DataSource() throws IOException, SQLException, PropertyVetoException {
        ds = new BasicDataSource();
        ds.setDriverClassName(PropertyReader.getProperty(DRIVER));
        ds.setUsername(PropertyReader.getProperty(USERNAME));
        ds.setPassword(PropertyReader.getProperty(PASSWORD));
        ds.setUrl(PropertyReader.getProperty(URL));
        ds.setMinIdle(MIN_IDLE);
        ds.setMaxIdle(MAX_IDLE);
        ds.setMaxOpenPreparedStatements(MAX_PREPARED_STATEMENTS);
    }

    public static DataSource getInstance() {
        if (datasource == null) {
            try {
                datasource = new DataSource();
            } catch (IOException | SQLException | PropertyVetoException e) {
                throw new RuntimeException("Error in initialization Data Source");
            }
            return datasource;
        } else {
            return datasource;
        }
    }

    public Connection getConnection() throws SQLException {
        return this.ds.getConnection();
    }
}
