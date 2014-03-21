package com.datayes.pms;

import com.datayes.pms.simpleorm.SimpleOrm;
import com.datayes.pms.simpleorm.SimpleOrmObject;
import junit.framework.TestCase;

import java.sql.SQLException;


public class SimpleOrmTest extends TestCase {

    public void testConnect() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        SimpleOrmObject soo = SimpleOrm.connect("jdbc:mysql://localhost:3306", "test");
        assertNotNull(soo);
        assertNotNull(soo.getConnection());
        assertNotNull(soo.getStatement());
    }

}
