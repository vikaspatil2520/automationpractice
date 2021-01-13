package com.automationpractice.qa.base;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!!" );
        String s1= "YellowLemon  (Mapped)";     //UI
        String s2= "YellowLemon | Yellow Lemon(Mapped)";  //excel
        s1=s1.split("\\s+")[0].trim();
        System.out.println(s1);
        System.out.println(s2.startsWith(s1));
    }
}
