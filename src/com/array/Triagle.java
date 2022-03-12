package com.array;

 public class Triagle {
    double area;
    int heigth;
    int length;

     public static void main(String[] args) {
        Triagle[] ta = new Triagle[4];
        int x = 0;
        while (x < 4)
        {
            ta[x] = new Triagle();
            ta[x].heigth = (x + 1) * 2;
            ta[x].length = x + 4;
            ta[x].setArea();
            System.out.print("triangle" + x + ", area");
            System.out.println("=" + ta[x].area);
            x = x + 1;
        }
        int y = x;
        x = 27;
        Triagle ta5 = ta[2];
        ta[2].area = 343;
        System.out.print("y = " + y);
        System.out.println(", зона t5 = " + ta5.area);
    }

     private  void setArea()
     {
         area = (heigth * length) / 2;
     }
    }





