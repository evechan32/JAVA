package dianmingqi;

import java.util.Random;

public class operationzuob extends Thread {
    int i = 5 ;
    GameJFrame gj;
    String s ="";
    public operationzuob(GameJFrame gj, int i,String s ) {
        this.gj = gj;
        this.i = i;
        this.s = s;
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
                for (int i1 = 0; i1 < 75; i1++) {
                    gj.dianming();
                }
                GameJFrame.rollName.setText(s);
            }
            }).start();


            sleep(100);


        }
        System.out.println(Thread.currentThread().getName()+"ZUOBI");
    }
    public void sleep(int i) {
        try {
            Thread.sleep(i );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
