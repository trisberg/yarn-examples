package com.springdeveloper.demo;

import java.net.URL;
import java.net.URLClassLoader;

/**
 */
public class HelloApp {

    private void run(String[] args) {
        System.out.println("ENV CLASSPATH: " + System.getenv("CLASSPATH"));
        System.out.println("MY CLASSPATH ...");
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        if (cl instanceof URLClassLoader) {
            for (URL url : ((URLClassLoader)cl).getURLs()) {
                System.out.println(url);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Running HelloApp!");
        new HelloApp().run(args);
        System.out.println("Done!");
    }

}
