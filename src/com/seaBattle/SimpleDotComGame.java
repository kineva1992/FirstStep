package com.seaBattle;

import java.util.ArrayList;

public class SimpleDotComGame {
    public static void main(String[] args)
    {
    int numOfGuesses = 0;
    GameHelper hepler = new GameHelper();

    SimpleDotCom theDotCom = new SimpleDotCom();
    int randoNumber = (int)(Math.random() * 5);
    int[] locations = {randoNumber, randoNumber + 1, randoNumber + 2};
    theDotCom.setLocationCells(locations);
    boolean isAviable = true;

    while(isAviable == true)
    {
        String guess = hepler.getUserInput("Введите число");
        String result = theDotCom.checkYourself(guess);
        numOfGuesses++;
        if(result.equals("Потопил"))
        {
            isAviable = false;
            System.out.println("Вам потребовалось " + numOfGuesses + " попыток");
        }
    }



    }
}
