package com.datayes.pms;


import javax.persistence.Entity;
import java.lang.annotation.Annotation;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        Class clazz = Test.class;
        Entity annotation = (javax.persistence.Entity)clazz.getAnnotation(javax.persistence.Entity.class);
        System.out.println( annotation.name() );
    }
}
