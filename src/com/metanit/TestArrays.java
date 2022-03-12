package com.metanit;

public class TestArrays {
    public static void main(String[] args) {
        String[] isLands = new String[4];
        isLands[0] = "Бермуды";
        isLands[1] = "Фиджи";
        isLands[2] = "Азорские острова";
        isLands[3] = "Косумель";
        int[] index = new int[4];
        index[0] = 1;
        index[1] = 3;
        index[2] = 0;
        index[3] = 2;

        int y = 0;
        int ref;
        while (y < 4)
        {
            ref = index[y];
            System.out.print("Острова = ");
            System.out.println(isLands[ref]);
            y++;
        }
    }


}
