package com.company;

public class Main {

    public static void main(String[] args) {
	int x = 1;
    while (x < 2)
    {
        System.out.print("Doo");
        System.out.print("Bee");
        x = x +1;
    }
    if (x == 2)
        System.out.print("Do");

    System.out.println();
     //   PhraceOMatic();
        Shuffle shuffleClass = new Shuffle();
        shuffleClass.shuffle1();

    }

    private static void BeerSong()
    {
        int beerNum = 99;
        String word = "бутылок";

        while (beerNum > 0)
        {
            System.out.println(beerNum +" " + word + " "+ "пива на стене");
            System.out.println(beerNum +" " + word + " "+"пива");
            System.out.println("Возьми одну");
            System.out.println("Пусти по кругу");
            beerNum--;
            if(beerNum == 1)
                word = "бутылка";
            if(beerNum > 0)
            {
                System.out.println(beerNum +" " + word + " "+ "пива на стене");
            }
            else
            {
                System.out.println("Нет бутылок пива на стене");
                System.out.println();
                System.out.println("Нет бутылок пива на стене, Пойдите в магазин и купите еще, 99 бутылок пива на стене.");
            }

        }



    }

    private static void PhraceOMatic()
    {
        String[] wordListOne = {"уполномоченный", "трудный", "чистый продукт", "ориентированный", "центральный", "распределенный",
                "кластеризированный", "фирменный", "нестандартный ум", "позиционированный", "сетевой", "сфокусированный",
                "использованный с выгодой", "выровненный", "нацеленный на", "общий", "совместный", "ускоренный"};

        String[] wordListTwo = {"процесс", "пункт разгрузки", "выход из положения", "тип структуры", "талант", "подход",
                "уровень завоеванного внимания", "портал", "период времени", "обзор", "образец", "пункт следования"};

        String[] wordListThree = {"круглосуточный", "трех-звенный", "300-фунтовый", "взаимный", "обоюдный выигрыш",
                "фронтэнд", "на основе веб-технологий", "проникающий", "умный", "шесть сигм", "метод критического пути", "динамичный"};
        int oneLength = wordListOne.length;
        int twoLength = wordListTwo.length;
        int threeLength = wordListThree.length;

        int rand1 = (int) (Math.random() * oneLength);
        int rand2 = (int) (Math.random() * twoLength);
        int rand3 = (int) (Math.random() * threeLength);

        String phrase = wordListOne[rand1] + " " + wordListTwo[rand2]+ " " + wordListThree[rand3];

        System.out.println("Всё, что нам нужно - это"+" " + phrase);

    }
}
