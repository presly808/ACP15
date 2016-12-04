package ua.artcode.fixtures;

import org.junit.*;

public class ChildA extends Parent {

    @BeforeClass
    public static void beforeClassChild(){
        System.out.println("BeforeClassChild");
    }

    @AfterClass
    public static void afterClassChild(){
        System.out.println("AfterClassChild");
    }

    @Before
    public void initData(){
        System.out.println("BeforeChildA");
    }

    @After
    public void tearData(){
        System.out.println("AfterChildA");
    }

    @Test
    public void test1(){
        System.out.println("Test1A");
    }

    @Test
    public void test2(){
        System.out.println("Test2A");
    }

}
