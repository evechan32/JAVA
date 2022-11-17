package com.qyw.ui;

import javax.swing.*;
import javax.swing.plaf.TextUI;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class loginjframe extends JFrame implements MouseListener{
    //初始化
    JButton dl =new JButton();
    JButton zc =new JButton();
    JTextField username = new JTextField();
    JPasswordField codename = new JPasswordField();
    JTextField yzmname = new JTextField();
    JTextField text = new JTextField();
    ArrayList<user> usepeople =  new ArrayList<user>();
    String yzmnr = new codeutil().getcode();



    public loginjframe()  {
        this.setSize(488,430);
        this.setTitle("登录");
        this.setAlwaysOnTop(true);
        //使页面居中
        this.setLocationRelativeTo(null);
        //设置游戏关闭模式 关闭一个界面时 虚拟机也关闭
        this.setDefaultCloseOperation(3);
        initimage();

        this.setVisible(true);
    }
    public void initimage()
    {   this.getContentPane().removeAll();


        username.setBounds(133,160,200,30);
        codename.setBounds(133,210,200,30);
        yzmname.setBounds(133,260,200,30);

        JLabel user =new JLabel(new ImageIcon("image/login/用户名.png"));
        user.setBounds(80,160,47,17);

        JLabel code =new JLabel(new ImageIcon("image/login/密码.png"));
        code.setBounds(80,210,32,16);
        JLabel yzm =new JLabel(new ImageIcon("image/login/验证码.png"));
        yzm.setBounds(80,260,56,21);



        text.setText(yzmnr);
        text.setEditable(false);
        text.setBounds(345,260,56,21);
        dl.setIcon((new ImageIcon("image/login/登录按钮.png")));
        dl.setBounds(80,310,128,47);
        dl.setBorderPainted(false);//set the border unvisible
        dl.setContentAreaFilled(false);//set the background unvisible
        zc.setIcon(new ImageIcon("image/login/注册按钮.png"));
        zc.setBounds(220,310,128,47);
        zc.setBorderPainted(false);//set the border unvisible
        zc.setContentAreaFilled(false);//set the background unvisible

        this.getContentPane().add(username);
        this.getContentPane().add(codename);
        this.getContentPane().add(yzmname);
        this.getContentPane().add(user);
        this.getContentPane().add(code);
        this.getContentPane().add(yzm);
        this.getContentPane().add(dl);
        this.getContentPane().add(zc);
        this.getContentPane().add(text);

        JLabel jlabel =new JLabel(new ImageIcon("image/login/background.png"));
        jlabel.setBounds(0,0,470,390);
        this.getContentPane().add(jlabel);
        this.getContentPane().repaint();
        //绑定事件
        dl.addMouseListener(this);
    }


    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == dl) {
            dl.setIcon(new ImageIcon("image/login/登录按下.png"));
        } else if (e.getSource() == zc) {
            zc.setIcon(new ImageIcon("image/login/注册按下.png"));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == dl) {
            dl.setIcon(new ImageIcon("image/login/登录按钮.png"));
                if (login())
                {
                    startgame();
                    this.setVisible(false);
                }


        } else if (e.getSource() == zc) {
            zc.setIcon(new ImageIcon("image/login/注册按钮.png"));
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }



    public boolean login()
    {
        usepeople.add(new user("zhangsan","1314520"));
        usepeople.add(new user("lisi","1315420"));
        String username0 = username.getText();
        String userpassword0 = new String (codename.getPassword());
        String yzmnr2 = yzmname.getText();
        JDialog jdialog0 = new JDialog();
        JLabel jlabel0 = new JLabel(new ImageIcon("image/damie.jpg"));

        jlabel0.setBounds(0,0,99,100);
        //将图片加入到弹窗中
        jdialog0.setTitle("用户名或者密码或者验证码输入有误");
        jdialog0.getContentPane().add(jlabel0);


        jdialog0.setSize(344,344);
        jdialog0.setAlwaysOnTop(true);
        jdialog0.setLocationRelativeTo(null);//set the dialog on the center

        for (int i = 0; i < usepeople.size(); i++) {
            if (username0.equalsIgnoreCase(usepeople.get(i).getUsername()))
            {
                    if(userpassword0.equalsIgnoreCase(usepeople.get(i).getUsercode()))
                    {
                       if (yzmnr2.equalsIgnoreCase(yzmnr)) return true;
                    }
            }

        }

        jdialog0.setModal(true);
        jdialog0.setVisible(true);
        yzmnr = new codeutil().getcode();
        text.setText(yzmnr);
        System.out.println(yzmnr);

        return false;
    }
    public void startgame()
    {


            gamejframe gameJframe = new gamejframe();


    }


}
