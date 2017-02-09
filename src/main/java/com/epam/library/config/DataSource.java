package com.epam.library.config;


import org.apache.commons.dbcp.BasicDataSource;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class DataSource {
    private static DataSource datasource;
    private BasicDataSource ds;

    private DataSource() throws IOException, SQLException, PropertyVetoException {
        ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUsername("root");
        ds.setPassword("root");
        ds.setUrl("jdbc:mysql://localhost/test");

        // the settings below are optional -- dbcp can work with defaults
        ds.setMinIdle(5);
        ds.setMaxIdle(20);
        ds.setMaxOpenPreparedStatements(180);
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
