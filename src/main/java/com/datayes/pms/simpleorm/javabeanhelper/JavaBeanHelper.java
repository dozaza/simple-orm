package com.datayes.pms.simpleorm.javabeanhelper;

import javax.persistence.Column;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * System: Ubuntu
 * User: baoan @datayes
 * Date: 14-3-20
 * Time: 上午11:22
 */
public class JavaBeanHelper {

    public static <T> T createInstance(Class<T> clazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = clazz.getDeclaredConstructor();
        boolean isAccessible = constructor.isAccessible();
        if ( !isAccessible ) {
            constructor.setAccessible(true);
        }
        return (T) constructor.newInstance();
    }

    public static <T> void initializeInstance(T instance, ResultSet resultSet) {
        Class<T> clazz = (Class<T>) instance.getClass();

        Method[] methods = clazz.getDeclaredMethods();
        List<Column> columns = new ArrayList<>();

        for ( Method method : methods ) {
            method.getAnnotation(javax.persistence.Column.class);
        }



    }
}
