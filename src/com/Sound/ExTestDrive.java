package com.Sound;

class myEx extends Exception {}

public class ExTestDrive
{
static void doRisky(String t) throws myEx{
    System.out.print("h");

    if("yes".equals(t))
        System.out.print("a");
    else
        throw new myEx();
}
public static void main(String[] args)
{

    String test = args[0];
    System.out.print("t");

    try{
        doRisky(test);
    }
    catch (myEx e){
        System.out.print("t");
        System.out.print("o");
    }
    finally {
        System.out.print("w");
        System.out.print("s");
    }
}
}
