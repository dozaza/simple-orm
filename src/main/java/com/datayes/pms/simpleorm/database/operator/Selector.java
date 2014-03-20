package com.datayes.pms.simpleorm.database.operator;

import com.datayes.pms.simpleorm.database.sqlparser.Query;
import com.datayes.pms.simpleorm.database.sqlparser.SqlParser;
import com.datayes.pms.simpleorm.database.sqlparser.SqlType;
import com.datayes.pms.simpleorm.javabeanhelper.JavaBeanHelper;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

/**
 * Editor: intellij@Ubuntu
 * User: baoan
 * Date: 3/17/14
 * Time: 10:16 PM
 */
public class Selector {

    public static <T> List<T> select(Statement statement, Query query, Class<T> clazz) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, SQLException {

        T object = JavaBeanHelper.createInstance(clazz);

        String sql = SqlParser.parse(query);
        ResultSet resultSet = statement.executeQuery(sql);


    }
}
