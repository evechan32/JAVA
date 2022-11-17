package dianmingqi;

import javax.swing.*;
import java.util.Random;

public class operation extends Thread {
    int i = 5 ;
    GameJFrame gj;

    public operation(GameJFrame gj, int i) {
        this.gj = gj;
        this.i = i;

    }
    @Override
    public void run() {
        while (i>-1 )
        {
            gj.countDown.setText("倒计时："+ i--+ "秒");
            new Thread (new Runnable(){
                @Override
                public void run()
                {
                    String filepath = "src\\girl\\";
                 Random r =   new Random ();
                 int len = r.nextInt(1,12);
                    for (int i = 0; i < len; i++) {
                        filepath = filepath + i + ".jpg";
                        gj.setrollimage(filepath);
                         filepath = "src\\girl\\";
                        sleep(1);
                    }
                }
            }).start();
            new Thread (new Runnable(){
                @Override
            public void run()
            {
                for (int i1 = 0; i1 < 80; i1++) {
                    gj.dianming();
                }

            }
            }).start();


            sleep(10);


        }
        System.out.println(Thread.currentThread().getName());
    }
    public void sleep(int i) {
        try {
            Thread.sleep(i * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
