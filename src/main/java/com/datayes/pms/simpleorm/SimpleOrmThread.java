package com.datayes.pms.simpleorm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Editor: intellij@Ubuntu
 * User: baoan
 * Date: 3/16/14
 * Time: 7:27 PM
 */
class SimpleOrmThread implements Runnable {

    private Connection connection = null;

    SimpleOrmThread(String url, String user, String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url, user, password);
    }

    SimpleOrmThread(String url) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url);
    }

    @Override
    public void run() {

    }
}
