package com.datayes.pms.simpleorm.database.sqlparser;

/**
 * Created with IntelliJ IDEA.
 * System: Ubuntu
 * User: baoan @datayes
 * Date: 14-3-20
 * Time: 上午11:36
 */
public enum SqlSymbol {

    GREATER(">"),
    GREATER_EQUAL(">="),
    LESS("<"),
    LESS_EQUAL("<="),
    EQUAL("="),
    IN("IN"),
    AND("AND");


    private final String value;

    private SqlSymbol(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static SqlSymbol fromString(String s) {
        for ( SqlSymbol symbol : values() ) {
            if ( symbol.value.equals(s.toUpperCase()) ) {
                return symbol;
            }
        }
        return null;
    }

}
