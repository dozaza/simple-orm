package com.datayes.pms;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class SimpleOrmTest extends TestCase
{

    public SimpleOrmTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
