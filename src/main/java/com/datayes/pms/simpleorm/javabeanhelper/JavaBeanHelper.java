package com.datayes.pms.simpleorm.javabeanhelper;

import javax.persistence.Column;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    /**
     *
     * Public methods
     *
     */

    /**
     *
     * Create a list of instance with a Class type and a ResultSet of SQL
     *
     */
    public static <T> List<T> createInstances(Class<T> clazz, ResultSet resultSet) throws NoSuchMethodException, SQLException, InvocationTargetException, IllegalAccessException, InstantiationException {
        List<T> list = new ArrayList<>();
        while (resultSet.next()) {
            T instance = createInstance(clazz, resultSet);
            list.add(instance);
        }
        return list;
    }

    /**
     *
     * Private methods
     *
     */

    /**
     *
     * Create a default instance
     *
     */
    private static <T> T createEmptyInstance(Class<T> clazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = clazz.getDeclaredConstructor();
        boolean isAccessible = constructor.isAccessible();
        if ( !isAccessible ) {
            constructor.setAccessible(true);
        }
        return (T) constructor.newInstance();
    }

    /**
     *
     * Create an instance and set value with ResultSet
     *
     */
    private static <T> T createInstance(Class<T> clazz, ResultSet resultSet) throws NoSuchMethodException, SQLException, IllegalAccessException, InstantiationException, InvocationTargetException {
        T instance = createEmptyInstance(clazz);
        Method[] methods = clazz.getDeclaredMethods();
        for ( Method method : methods ) {
            try {
                Column annotation = method.getAnnotation(javax.persistence.Column.class);

                String getterName = method.getName();
                String setterName = "s" + getterName.substring(1);
                Method setter = clazz.getDeclaredMethod(setterName);

                String columnName = annotation.name();
                Object value = resultSet.getObject(columnName);

                setter.invoke(instance, value);
            }
            catch (NullPointerException e){  // No Column annotation method
                // Do nothing
            }
        }
        return instance;
    }

}
