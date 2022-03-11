package com.seaBattle;

import java.util.ArrayList;

public class SimpleDotCom {

    private ArrayList<String> locationsCells;
    //int[] locationsCells;
    int numOfHits;

    public void setLocationCells(ArrayList<String> loc)
    {
        locationsCells = loc;
    }


    public String checkYourself(String userInput)
    {

        String result = "Мимо";
        int index = locationsCells.indexOf(userInput);
            if(index >= 0)
            {
                locationsCells.remove(index);

                if(locationsCells.isEmpty()){
                    result = "Потопил";
                }
                else{
                    result = "Потопил";
                }

            }


        return result;
    }
}
