package com.datayes.pms.simpleorm.database.sqlparser;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * System: Ubuntu
 * User: baoan @datayes
 * Date: 14-3-20
 * Time: 上午11:33
 */

public class SqlParser {

    /*
        *
        * Public methods
        *
     */

    /*
        *
        * Parse a query and return a normal sql
        *
     */
    public static String parse(Query query) {
        SqlType type = query.getType();
        Class clazz = query.getClazz();
        String conditionString = query.getConditions();
        Map<String, Object> parameters = query.getParameters();

        String[] symbols = conditionString.split(" ");

        List<Condition> conditionList = new ArrayList<>();
        List<String> oneConditionSymbol = new ArrayList<>();
        for ( String s : symbols ) {
            if ( !s.toUpperCase().equals(SqlSymbol.AND.getValue()) ) {   // is not "AND"
                oneConditionSymbol.add(s);
            }
            else {      // is "AND", and handle all symbols
                Condition condition = getCondition(oneConditionSymbol, parameters);
                conditionList.add(condition);
                oneConditionSymbol.clear();
            }
        }

        String prefixSqlString = convertToSqlString(type);
        String tableName = convertToSqlString(clazz);
        String conditionSqlString = convertToSqlString(conditionList);

        return prefixSqlString + tableName + conditionSqlString;
    }


    /*
        *
        * Private methods
        *
     */

    /*
        *
        * Create a Condition instance with symbols
        *
     */
    private static Condition getCondition(List<String> oneConditionSymbol, Map<String, Object> parameters) {
        String prefix = oneConditionSymbol.get(0);

        String symbol = oneConditionSymbol.get(1);
        SqlSymbol sqlSymbol = SqlSymbol.fromString(symbol);

        String post = oneConditionSymbol.get(2);
        String parameterName = post.substring(1);
        Object parameter = parameters.get(parameterName);

        return new Condition(prefix, sqlSymbol, parameter);
    }

    /*
        *
        * Convert a SqlType instance to sql prefix
        *
     */
    private static String convertToSqlString(SqlType type) {
        switch (type) {
            case SELECT:
                return "SELECT * FROM";
            case DELETE:
                return "DELETE FROM";
            case UPDATE:
                return "UPDATE FROM";
            default:
                throw new RuntimeException("The sql type is wrong: " + type);
        }
    }

    /*
        *
        * Convert a Class name to table name
        *
     */
    private static String convertToSqlString(Class clazz) {
        Entity annotation = (javax.persistence.Entity)clazz.getAnnotation(javax.persistence.Entity.class);
        return annotation.name();
    }

    /*
        *
        * Convert a list of Condition to a sql condition
        *
     */
    private static String convertToSqlString(List<Condition> conditionList) {
        String s = "";
        if ( !conditionList.isEmpty() ) {
            s += "WHERE";
        }
        for ( int i = 0; i < conditionList.size(); i++ ) {
            s += conditionList.get(i);
            if ( i != conditionList.size() - 1 ) {
                s += "AND";
            }
        }
        return s;
    }


}
