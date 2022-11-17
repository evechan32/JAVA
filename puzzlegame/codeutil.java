package com.qyw.ui;

import java.util.Random;

public class codeutil {
    public codeutil() {
    }
    public static String getcode()
  {
        Random r =new Random();



        String sb ;
        char[]co = new char[5];
        for (int i = 0; i < 5; i++) {
            //97 'a'
            //65 'A'
            //49 '1'
            if (i<2)
            {    int num = r.nextInt(0,26);
                 int sum = 97+num;
                 co[i] =(char)sum;
            }
            else if (i>=2&&i<4)
            {   int num = r.nextInt(0,26);
                int sum = 65+num;
                co[i] =(char)sum;
            }
            else {
                int num = r.nextInt(0,9);
                int sum = 48+num;
                co[i] =(char)sum;
            }

        }
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < 5; i++) {

            while (true){
                int num = r.nextInt(0,5);
                if(co[num]!= '!') {
                    sb1.append(co[num]);
                    co[num] = '!' ;
                    break;
                }
            }

        }
        sb = sb1.toString();

        return sb;
    }
}
