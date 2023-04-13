package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class score extends JFrame{
    score(String name, int score)
    {
        JLabel qno;
        JButton submit;
        setBounds(600,150,750,550);
        getContentPane().setBackground(Color.WHITE);
        this.setLayout((LayoutManager)null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("com/company/score.png"));
        // To add component to frame use add function
       //        //Then add this to JFrame ,We have layouts in swing for how to place components on JFrame
        Image i2=i1.getImage().getScaledInstance(300,250,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3); //image ko JLabel m daal do
        image.setBounds(0,200,300,250);
        add(image);

        JLabel heading=new JLabel("Thankyou "+name +" for playing Brilliant minds");
        //Frame par likhne ke liye
        heading.setBounds(45,30,700,30);
        heading.setFont(new Font("Tahoma",Font.PLAIN,28));
//        heading.setForeground(new Color(30,144,254));
        add(heading);

        JLabel lblscore=new JLabel("Your score is "+ score);
        lblscore.setBounds(350,200,300,30);
        lblscore.setFont(new Font("Tahoma",Font.PLAIN,26));
        add(lblscore);

        submit=new JButton("Play Again");
        submit.setBounds(380,270,120,30);
        submit.setBackground(Color.MAGENTA);
        submit.setForeground(Color.BLACK);
        submit.addActionListener(this::actionPerformed);
//
        add(submit);

        setVisible(true);

//        qno=new JLabel();
//        qno.setBounds(100,450,50,30);
//        qno.setFont(new Font("Tahoma",Font.PLAIN,24));
//        this.add(qno);

    }
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();

    }
    public static void main(String[] args) {
        new score("user",0);
    }
}
