package ua.artcode.fixtures;

import org.junit.runner.JUnitCore;
import org.junit.runners.JUnit4;

/**
 * Created by serhii on 11/26/16.
 */
public class RunTest {


    public static void main(String[] args) {
        JUnitCore.runClasses(ChildA.class);
    }
}
