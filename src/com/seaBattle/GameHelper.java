
package com.seaBattle;

import  java.io.*;


public class GameHelper {
    public String getUserInput(String promt)
    {
        String inputLine = null;
        System.out.print(promt + " ");

        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if(inputLine.length() == 0)
                return null;
        }
        catch (IOException e) {
            System.out.println("IOExeption" + e);
        }
        return  inputLine;
    }
}
