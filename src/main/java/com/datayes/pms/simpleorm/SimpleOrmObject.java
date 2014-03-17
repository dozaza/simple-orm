package com.datayes.pms.simpleorm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Editor: intellij@Ubuntu
 * User: baoan
 * Date: 3/16/14
 * Time: 7:27 PM
 */
class SimpleOrmObject {

    private static Connection connection = null;

    private static Statement statement = null;

    SimpleOrmObject(String url, String user, String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url, user, password);
        statement = connection.createStatement();
    }

    SimpleOrmObject(String url) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url);
        statement = connection.createStatement();
    }
}
