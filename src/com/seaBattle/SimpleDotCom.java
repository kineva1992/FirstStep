package com.seaBattle;

import java.util.ArrayList;

public class SimpleDotCom {

    int[] locationCells;
    int numOfHits = 0;

    public void setLocationCells(int[] loc)
    {
        locationCells = loc;
    }


    public String checkYourself(String userInput) {


        int guess = Integer.parseInt(userInput);
        String result = "Мимо";

        for (int cell : locationCells) {
            if (guess == cell) {
                result = "Попал";
                numOfHits++;
                break;
            }
        }
        if (numOfHits == locationCells.length)
        {
            result = "Убил";
        }
        System.out.println(result);
        return result;
    }
}
