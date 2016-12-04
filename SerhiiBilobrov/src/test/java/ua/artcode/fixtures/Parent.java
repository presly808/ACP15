package ua.artcode.fixtures;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 * Created by serhii on 11/26/16.
 */
public class Parent {

    protected static String db;

    @BeforeClass
    public static void beforeClass(){
        System.out.println("BeforeClass Parent");
        db = "Connection";
    }

    @Before
    public void setUpData(){
        System.out.println("BeforeParent");
    }

    @After
    public void tearDownData(){
        System.out.println("AfterParent");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("AfterClass Parent");
        db = null;
    }


}
