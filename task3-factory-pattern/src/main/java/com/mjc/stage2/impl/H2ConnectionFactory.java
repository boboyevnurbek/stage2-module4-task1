package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class H2ConnectionFactory implements ConnectionFactory {

    @Override
    public Connection createConnection() {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("classpath:h2database.properties"));

            String url = properties.getProperty("db_url");

            return DriverManager.getConnection(url, properties);

        } catch (Exception e) {
        }
        return null;
    }
}

