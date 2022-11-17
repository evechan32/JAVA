package dianmingqi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameJFrame extends JFrame implements MouseListener {

    JButton start = new JButton("开始");
    static JLabel rollName = new JLabel("");
    static JLabel countDown = new JLabel("倒计时：5秒");
    JLabel rollImage = new JLabel(new ImageIcon("src\\girl\\1.jpg"));
    int count = 5;
    operation po;
    operationzuob po1;
    int flag = 0;
    int count0 = 0;
    static ArrayList<String> dm = new name().namelist();
    String s1 = "";

    public GameJFrame() {
        //设置界面
        initJframe();

        //添加组件
        initView();

        //界面显示出来
        this.setVisible(true);

    }

    public GameJFrame(String s1) {
        this.s1 = s1;
        //设置界面
        initJframe();

        //添加组件
        initView();

        //界面显示出来
        this.setVisible(true);

    }

    //添加组件
    public void initView() {
        this.getContentPane().removeAll();

        countDown.setFont(new Font(null, 1, 50));
        countDown.setBounds(50, 50, 300, 60);
        this.getContentPane().add(countDown);


        JLabel namePrompt = new JLabel("中奖选手为：");
        namePrompt.setFont(new Font(null, 1, 20));
        namePrompt.setBounds(80, 150, 125, 30);
        this.getContentPane().add(namePrompt);


        rollName.setFont(new Font(null, 1, 20));
        rollName.setBounds(200, 150, 125, 30);

        this.getContentPane().add(rollName);


        rollImage.setBounds(87, 200, 210, 210);
        this.getContentPane().add(rollImage);


        start.setFont(new Font(null, 1, 20));
        start.setBounds(118, 430, 150, 50);
        start.setBackground(Color.WHITE);
        //start.addActionListener(this);
        this.getContentPane().add(start);
        start.addMouseListener(this);

    }


    //设置界面
    public void initJframe() {
        //设置标题
        this.setTitle("随机点名器");
        //设置大小
        this.setSize(400, 600);
        //设置关闭模式
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口无法进行调节
        this.setResizable(false);
        //界面居中
        this.setLocationRelativeTo(null);
        //取消内部默认居中放置
        this.setLayout(null);
        //设置背景颜色
        this.getContentPane().setBackground(Color.white);
        this.setAlwaysOnTop(true);//置顶
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        int num = 0;
        String mustname = null;//"";
        System.out.println(count);
        if (s1 != null) {
            num = Integer.valueOf(s1.split("/")[0]);
            System.out.println(num);
            mustname = s1.split("/")[1];
            System.out.println(mustname);

        }

        if(mustname !=null)
        {
            flag =1;
        }
        if(e.getSource()==start)
        {
            if (flag ==1)
            {
                if (count0 < num ) {
                    count0++;
                    po = new operation(this, 5);
                    po.start();
                }
                if (count0 == num ) {
                    count0 =0;
                    po1 = new operationzuob(this, 5,mustname);
                    po1.start();
                }
            }
            else{
                po = new operation(this, 5);
                po.start();

        }
        }
//        if (e.getSource() == start && !mustname.equals("")) {
//            if (count0 < num) {
//                count0++;
//                po = new operation(this, 5);
//                po.start();
//                // new Thread(po).start();
//
//            }
//            if (count0 == num) {
//                count0 = 0;
//                po1 = new operationzuob(this, 5, mustname);
//                try {
//                    Thread.sleep(250);
//                } catch (InterruptedException ex) {
//                    ex.printStackTrace();
//                }
//                po1.start();
//                //  new Thread(po1).start();
//
//            }
//        } else if (e.getSource() == start && mustname.equals("")) {
//            po = new operation(this, 5);
//            po.start();
//        }


    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void dianming() {
        ArrayList<Integer> weight = new ArrayList<>();
        List list = new ArrayList();
        weight.add(1);

        for (int i = 0; i < dm.size() - 1; i++) {
            weight.add(2);
        }

        list.addAll(dm);
        int index;
        int temp;
        if (rollName.getText().equals(null)) {
            Random r = new Random();
            index = r.nextInt(dm.size());
            temp = index;
            rollName.setText((String) list.get(index));
            Collections.swap(list, 0, index);

        } else {
            index = random(weight);
            if (index == 0) {
                weight.set(0, weight.get(0) / 2);
            }
            rollName.setText((String) list.get(index));

            Collections.swap(list, 0, index);


        }
    }

    public int random(List<Integer> weight) {
        List<Integer> weightTmp = new ArrayList<Integer>(weight.size() + 1);
        weightTmp.add(0);
        Integer sum = 0;
        for (Integer d : weight) {
            sum += d;//
            weightTmp.add(sum);//1,3,5,7,9,11 0-1,1-3,3-5,5-7,7-9,9-11,
        }
        Random random = new Random();
        int rand = random.nextInt(sum);
        int index = 0;
        /*  rand =4
            rand >weightTmp.get(1) index = 1
            rand =3
            rand =weightTmp.get(1) index =1
            rand = 1
            rand = weightTmp.get(0) index = 0
        */
        for (int i = weightTmp.size() - 1; i > 0; i--) {
            if (rand >= weightTmp.get(i)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void setrollimage(String path) {
        rollImage.setIcon(new ImageIcon(path));

    }
}
