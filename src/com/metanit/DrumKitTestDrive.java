package com.metanit;

public class DrumKitTestDrive {

    public static void main2(String[] args)
    {
        DumKit d = new DumKit();

        if(d.snare == true)
        {
            d.playShare();
            d.snare = false;
        }
        d.playTopHat();
        d.topHat = false;
        if (d.topHat == false)
        {
            d.playTopHat();
        }
    }
}

