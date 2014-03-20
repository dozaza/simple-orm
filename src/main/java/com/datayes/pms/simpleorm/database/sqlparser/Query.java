package com.datayes.pms.simpleorm.database.sqlparser;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * System: Ubuntu
 * User: baoan @datayes
 * Date: 14-3-20
 * Time: 下午2:07
 */
public class Query {

    private SqlType type = null;

    private Class clazz = null;

    private String conditions = null;

    private Map<String, Object> parameters = new HashMap<>();

    public Query() {

    }

    public void setParameters(String name, Object value) {
        parameters.put(name, value);
    }

    public void setParameters(String name, Number number) {
        parameters.put(name, number);
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public Object getParameter(String name) {
        return parameters.get(name);
    }

    public String getConditions() {
        return conditions;
    }

    public SqlType getType() {
        return type;
    }

    public void setType(SqlType type) {
        this.type = type;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }
}
