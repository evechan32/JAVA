package com.qyw.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.*;
import java.util.Random;

public class gamejframe extends JFrame implements KeyListener,ActionListener{
    int [][] Arr4 =new int [4][4];
    //记录空白方块的位置
    int x=0;
    int y=0;
    String path = "image/animal/animal3/";
    int bs=0;
    int click = 0;
    JMenu function = new JMenu("Function");
    JMenu about = new JMenu("About me");
    JMenu changeimage = new JMenu("changeimage");
    JMenuItem replay = new JMenuItem("Replay");
    JMenuItem relogin = new JMenuItem("Relogin");
    JMenuItem close = new JMenuItem("Close");
    JMenuItem account = new JMenuItem("微信号");
    JMenuItem beauty = new JMenuItem("beauty");
    JMenuItem animal = new JMenuItem("animal");
    JMenuItem sports = new JMenuItem("sports");
    //初始化
    public gamejframe()
    {
        daluan();
        initImage();
        initgame();
        //初始化菜单
        //创建整个菜单对象
        initjmenubar();
        this.addKeyListener(this);//执行本类对应的办法
        this.setVisible(true);
    }

    private void initjmenubar() {
        JMenuBar jMenuBar = new JMenuBar();
        jMenuBar.add(function);
        jMenuBar.add(about);
        //建立各个组件的关系
        function.add(replay);
        function.add(relogin);
        function.add(close);
        function.add(account);
        function.add(changeimage);
        changeimage.add(beauty);
        changeimage.add(animal);
        changeimage.add(sports);
        about.add(account);

        //为组件绑定事件
        replay.addActionListener(this);
        relogin.addActionListener(this);
        close.addActionListener(this);
        account.addActionListener(this);
        changeimage.addActionListener(this);
        beauty.addActionListener(this);
        animal.addActionListener(this);
        sports.addActionListener(this);
        this.setJMenuBar(jMenuBar);
    }

    private void initgame() {
        this.setSize(603,680);
        this.setTitle("Puzzle");
        //使游戏界面一直在上面
        this.setAlwaysOnTop(true);
        //使页面居中
        this.setLocationRelativeTo(null);
        //取消默认的居中放置的设置
        this.setLayout(null);
//        //创建一个按钮对象
//        JButton jtb = new JButton("click");
//        //设置位置和宽高
//        jtb.setBounds(0,0,100,50);



        //给按钮添加动作监听:
        //jtb组件对象，表示给哪个组件添加事件
        //addActionListener，表示要给组件添加哪个时间监听（动作监听包括鼠标左键点击，空格）
        //参数为时间被触发后所执行的代码
//        jtb.addActionListener(new MyActionListener()
//        {
//            @Override
//            public void actionPerformed(ActionEvent e)
//            {
//                System.out.println("wait !");
//            }
//        });
//        this.addKeyListener(new KeyListener() {
//            @Override
//            public void keyTyped(KeyEvent e) {
//
//                System.out.println("do nothing");
//            }
//
//            @Override
//            public void keyPressed(KeyEvent e) {
//                System.out.println("press something");
//            }
//
//            @Override
//            public void keyReleased(KeyEvent e) {
//                int a = e.getKeyCode();
//                System.out.println("Release something"+a);
//            }
//        });
        //只用一次因此使用匿名内部类
        //添加按钮到界面中
        //this.getContentPane().add(jtb);
        //设置游戏关闭模式 关闭一个界面时 虚拟机也关闭
        this.setDefaultCloseOperation(3);

    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Random r = new Random();
        Object obj = e. getSource();
        if (obj == replay) {
            bs=0;
            x=0;y=0;
            daluan();
            initImage();
                }
        else if(obj == close)
        {
            System.exit(3);
        }
        else if(obj == relogin){
            this.setVisible(false);//将当前界面隐藏起来
            new loginjframe();//实例化登录界面
        }
        else if (obj == account)
        {      //创建一个弹窗对象
            JDialog jdialog = new JDialog();
            JLabel jlabel0 = new JLabel(new ImageIcon("image/damie.jpg"));
            jlabel0.setBounds(0,0,99,100);
            //将图片加入到弹窗中
            jdialog.getContentPane().add(jlabel0);
            jdialog.setSize(344,344);
            jdialog.setAlwaysOnTop(true);
            jdialog.setLocationRelativeTo(null);//set the dialog on the center
            //can no more do anonther option until it's closed
            jdialog.setModal(true);
            jdialog.setVisible(true);
        }
        else if (obj == beauty)
        {   int a = r.nextInt(1,14);

            path = "image/girl/girl"+a+"/";

            bs=0;
            x=0;y=0;
            daluan();
            initImage();
        }
        else if (obj == animal)
        {   int a = r.nextInt(1,9);

            path = "image/animal/animal"+a+"/";

            bs=0;
            x=0;y=0;
            daluan();
            initImage();
        }
        else if (obj == sports)
        {   int a = r.nextInt(1,11);

            path = "image/sport/sport"+a+"/";
            bs=0;
            x=0;y=0;
            daluan();
            initImage();
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == 65)
        {   this.getContentPane().removeAll();
            String address = path+"all.jpg";
            JLabel jlabel = new JLabel(new ImageIcon(address));
            jlabel.setBounds(83,134,420,420);
            this.getContentPane().add(jlabel);
            this.getContentPane().repaint();
            ImageIcon bg = new ImageIcon("image/background.png");
            JLabel background = new JLabel (bg);
            background.setBounds(40,40,508,560);
            this.getContentPane().add(background);
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {
        //左：37 上：38 右：39 下：40

        int code = e.getKeyCode();
        if (vitory())
        {
            return;
        }
        switch (code) {
            case 38 -> {
                if (y == 3) return;
                Arr4[x][y] = Arr4[x ][y + 1];
                Arr4[x ][y + 1] = 0;
                bs++;

                initImage();
                break;
            }
            case 40 -> {

                if (y == 0) return;
                Arr4[x][y] = Arr4[x ][y - 1 ];
                Arr4[x  ][y -1 ] = 0;
                bs++;

                initImage();
                break;

            }
            case 37 -> {
                if (x == 3) return;
                Arr4[x][y] = Arr4[x + 1][y];
                Arr4[x+ 1 ][y ] = 0;
                bs++;
                initImage();
                break;
            }
            case 39 -> {

                if(x==0) return;
                Arr4[x][y] = Arr4[x - 1][y ];
                Arr4[x - 1][y ] = 0;

                bs++;
                initImage();
                break;

            }
            case 65 -> {
                initImage();
                break;
            }
            case 87 ->
                    {
                        Arr4 =new int[][] {{1,5,9,13},{2,6,10,14},{3,7,11,15},{4,8,12,0}};
                        initImage();
                    }
        }

    }
    public void daluan()
    {
        int [] tempArr ={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        Random r = new Random();
        int index ,h;

        for (int i = 0; i < 4; i++) {
            for (int i1 = 0; i1 < 4; i1++) {
                h=0;
                while ( h <17) {
                    index = r.nextInt(0, 16);

                        if (tempArr[index] != 100) {
                            Arr4[i][i1] = tempArr[index];
                            tempArr[index] = 100;
                            break;
                    }
                    h++;
                }
            }
        }

    }
    private void initImage()
    {   this.getContentPane().removeAll();

        if(vitory())
        {   String lj1 = "image/win.png";
            JLabel jlabel1 = new JLabel(new ImageIcon(lj1));
            jlabel1.setBounds(191,239,193,73);
            //将管理容器添加到界面中
            this.getContentPane().add(jlabel1);
        }

        JLabel bsxs = new JLabel ("Step:"+bs);
        bsxs.setBounds(30,30,80,20);
        this.getContentPane().add(bsxs);
       //先加載的在上方，后加載的在下面
        for (int i1 = 0; i1 < 4; i1++) {
            for (int i = 0; i < 4; i++) {
                //创建一个Jlabel的对象（管理容器）
                //指定位置
                String lj ;
                int add=Arr4[i][i1];

                if (add==0) {
                    x = i;
                    y= i1;
                }
                lj=path+add+".jpg";
                JLabel jlabel = new JLabel(new ImageIcon(lj));
                jlabel.setBounds(105*i +83,105*i1 +134,105,105);
                jlabel.setBorder(new BevelBorder(1));//讓圖片突起 0 ，凹下去 1
                //将管理容器添加到界面中
                this.getContentPane().add(jlabel);

            }
        }
        ImageIcon bg = new ImageIcon("image/background.png");
        JLabel background = new JLabel (bg);
        background.setBounds(40,40,508,560);
        this.getContentPane().add(background);
        this.getContentPane().repaint();//重新刷新一下
    }

    private boolean vitory()
    {
        int [][]win = {{1,5,9,13},{2,6,10,14},{3,7,11,15},{4,8,12,0}};
        for (int i = 0; i < Arr4.length; i++) {
            for (int i1 = 0; i1 < Arr4[i].length; i1++) {
                if(Arr4[i][i1]!=win[i][i1])
                {
                    return false;
                }
            }
        }
        return true;

    }


}
