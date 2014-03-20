package com.datayes.pms.simpleorm;

import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Editor: intellij@Ubuntu
 * User: baoan
 * Date: 3/16/14
 * Time: 7:10 PM
 */
public class SimpleOrm {

    private static Map<String, SimpleOrmObject> map = new ConcurrentHashMap<>();

    /**
     *
     * Public methods
     *
     */

    /**
     *
     * Connect database with user & password, return a SimpleOrmObject
     *
     */
    public static SimpleOrmObject connect(String url, String user, String password) throws SQLException, ClassNotFoundException {
        SimpleOrmObject object = new SimpleOrmObject(url, user, password);
        if ( map.containsKey(url) ) {
            throw new RuntimeException("The database " + url + " is already existed");
        }
        map.put(url, object);
        return object;
    }

    /**
     *
     * Connect database with no user or password, return a SimpleOrmObject
     *
     */
    public static SimpleOrmObject connect(String url) throws SQLException, ClassNotFoundException {
        SimpleOrmObject object = new SimpleOrmObject(url);
        if ( map.containsKey(url) ) {
            throw new RuntimeException("The database " + url + " is already existed");
        }
        map.put(url, object);
        return object;
    }

    /**
     *
     * Get a SimpleOrmObject with a url
     *
     */
    public static SimpleOrmObject get(String url) {
        SimpleOrmObject object = map.get(url);
        if ( null == object ) {
            throw new RuntimeException("Cannot find object of database: " + url);
        }
        return object;
    }

}
