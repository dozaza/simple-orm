package com.datayes.pms.simpleorm.database.sqlparser;

/**
 * Created with IntelliJ IDEA.
 * System: Ubuntu
 * User: baoan @datayes
 * Date: 14-3-20
 * Time: 上午11:35
 */
public class Condition {

    private String prevParameterName = null;

    private SqlSymbol symbol = null;

    private Object postParameterValue = null;


    public Condition(SqlSymbol symbol) {
        this.symbol = symbol;
    }

    public Condition(String prevParameterName, SqlSymbol symbol, Object postParameterValue) {
        this.prevParameterName = prevParameterName;
        this.postParameterValue = postParameterValue;
        this.symbol = symbol;
    }

    public String getPrevParameterName() {
        return prevParameterName;
    }

    public void setPrevParameterName(String prevParameterName) {
        this.prevParameterName = prevParameterName;
    }

    public Object getPostParameterValue() {
        return postParameterValue;
    }

    public void setPostParameterValue(Object postParameterValue) {
        this.postParameterValue = postParameterValue;
    }

    public SqlSymbol getSymbol() {
        return symbol;
    }

    public void setSymbol(SqlSymbol symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        String s = "";
        if ( prevParameterName != null ) {
            s += prevParameterName;
        }
        if ( symbol != null ) {
            s += symbol.getValue();
        }
        if ( postParameterValue != null ) {
            s += postParameterValue;
        }
        return s;
    }
}
