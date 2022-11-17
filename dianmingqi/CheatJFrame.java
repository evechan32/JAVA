package dianmingqi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheatJFrame extends JFrame implements ActionListener {


    JButton submit = new JButton("确定");
    JTextField noRollName = new JTextField();
    JTextField rollName = new JTextField();
    JTextField count = new JTextField();
    public CheatJFrame() {
        //设置界面
        initJframe();

        //添加组件
        initView();

        //界面显示出来
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == submit){
            String s =must();
            zuobi();
            System.out.println(s);
           // if (s!=null)
            {
                this.setVisible(false);
                new GameJFrame(s);
            }

        }
    }

    //添加组件
    public void initView() {
        JLabel cheat = new JLabel("作弊时刻");
        cheat.setFont(new Font(null,1,30));
        cheat.setBounds(130,10,130,30);
        this.getContentPane().add(cheat);

        JLabel hint1 = new JLabel("不会被点到的人");
        hint1.setFont(new Font(null,0,20));
        hint1.setBounds(30,100,140,30);
        this.getContentPane().add(hint1);


        noRollName.setBounds(180,100,140,30);
        this.getContentPane().add(noRollName);

        JLabel hint2 = new JLabel("第");
        hint2.setFont(new Font(null,0,20));
        hint2.setBounds(30,200,30,30);
        this.getContentPane().add(hint2);


        count.setBounds(60,200,30,30);
        this.getContentPane().add(count);

        JLabel hint3 = new JLabel("次,一定会被点到的人是：");
        hint3.setFont(new Font(null,0,20));
        hint3.setBounds(100,200,230,30);
        this.getContentPane().add(hint3);


        rollName.setBounds(210,240,100,30);
        this.getContentPane().add(rollName);


       submit.setFont(new Font(null,1,20));
       submit.setBounds(110,300,150,50);
       submit.setBackground(Color.WHITE);
       submit.addActionListener(this);
       this.getContentPane().add(submit);

    }


    //设置界面
    public void initJframe() {
        //设置标题
        this.setTitle("随机点名器");
        //设置大小
        this.setSize(400, 500);
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

    public void zuobi()
    {
        String xinyuner= noRollName.getText();

        for (String s : GameJFrame.dm)
        {
            if (s.equalsIgnoreCase(xinyuner))
            {
                GameJFrame.dm.remove(s);
                return;
            }
        }


                JDialog jdialog0 = new JDialog();
                JLabel jlabel0 = new JLabel(new ImageIcon("src//girl//logo.jpg"));

                jlabel0.setBounds(0,0,99,100);
                //将图片加入到弹窗中
                jdialog0.setTitle("无此人信息");
                jdialog0.getContentPane().add(jlabel0);


                jdialog0.setSize(344,344);
                jdialog0.setAlwaysOnTop(true);
                jdialog0.setLocationRelativeTo(null);//set the dialog on the center

                jdialog0.setModal(true);
                jdialog0.setVisible(true);


    }
    public String must()
    {
        String mustpeople = rollName.getText();
        String countmust = count.getText();
        for (String s : GameJFrame.dm)
        {
            if (s.equalsIgnoreCase(mustpeople))
            {
              return countmust+"/"+s;
            }
        }

                JDialog jdialog0 = new JDialog();
                JLabel jlabel0 = new JLabel(new ImageIcon("src//girl//logo.jpg"));

                jlabel0.setBounds(0,0,99,100);
                //将图片加入到弹窗中
                jdialog0.setTitle("无此人信息");
                jdialog0.getContentPane().add(jlabel0);


                jdialog0.setSize(344,344);
                jdialog0.setAlwaysOnTop(true);
                jdialog0.setLocationRelativeTo(null);//set the dialog on the center

                jdialog0.setModal(true);
                jdialog0.setVisible(true);


        return null;
    }

}
