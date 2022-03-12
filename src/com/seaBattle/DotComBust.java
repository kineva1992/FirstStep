package com.seaBattle;
import java.util.ArrayList;

public class DotComBust {
    private GameHelper hepler = new GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
    private int numOfGuesses = 0;

    void setUpGame()
    {
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("eToys.com");
        DotCom three = new DotCom();
        three.setName("Go2.com");
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);

        System.out.println("Ваша цель потопить три 'сайта'.");
        System.out.println("Pets.com, eToys.com, Go2.com");
        System.out.println("Попытайтесь потопить их за минимальное количество ходов");

        for(DotCom dotComToSet : dotComsList)
        {
            ArrayList<String> newLocations = hepler.placeDotCom(3);
            dotComToSet.setLocationCells(newLocations);
        }
    }

    private void startPlaying()
    {
        while(!dotComsList.isEmpty())
        {
            String userGuess = hepler.getUserInput("Сделайте ход");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess)
    {
        numOfGuesses++;
        String result = "Мимо";

        for(DotCom dotComToTest : dotComsList)
        {
            result = dotComToTest.checkYourself(userGuess);
            if(result.equals("Попал"))
            {
                break;
            }
            if(result.equals("Потопл"))
            {
                dotComsList.remove(dotComToTest);
                break;
            }
        }
        System.out.println(result);
    }

    private void finishGame()
    {
        System.out.println("Все сайты пошли ко дну! Ваши акции теперь ничего не стоят");
        if(numOfGuesses <= 18)
        {
            System.out.println("Это заняло у вас всего " + numOfGuesses+ " попыток");
            System.out.println("Вы успели выбраться до того, как ваши вложения утонули");
        }
        else
        {
            System.out.println("Это заняло у вас достаточно много времени " + numOfGuesses+ " попыток");
            System.out.println("Рыбы водят хороводы вокруг ваших предложений");
        }
    }

    public static void main(String[] args)
    {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }


}
