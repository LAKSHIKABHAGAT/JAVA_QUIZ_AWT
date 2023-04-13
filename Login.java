
package com.company;
import javax.swing.*;  //Swing package h java ke extended package se aata hain
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//Implement ActionListener interface for functionality - On click Event
public class Login extends JFrame implements ActionListener {

    JButton rules,back;
    JTextField tfname;
    Login(){
//        Frame ki jitni bhi coding h constructor ke andar coz at first constructor is called
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);//we are creating our own layout

//Color class in AWT
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("com/company/login.jpeg"));
//        To add component to frame use add function
        JLabel image =new JLabel(i1); //image ko JLabel m daal do
//        //Then add this to JFrame ,We have layouts in swing for how to place components on JFrame
        image.setBounds(0,0,600,500);
        add(image);

        JLabel heading=new JLabel("Brilliant Minds");
        //Frame par likhne ke liye
        heading.setBounds(750,60,300,45);
        heading.setFont(new Font("viner Hand ITC",Font.BOLD,36));
        heading.setForeground(Color.MAGENTA);
        add(heading);

        JLabel name=new JLabel("Enter Your name");
        //Frame par likhne ke liye
        name.setBounds(810,150,300,20);
        name.setFont(new Font("Mongolian",Font.BOLD,16));
        name.setForeground(Color.black);
        add(name);

        tfname=new JTextField();
        tfname.setBounds(735,200,300,25);
        tfname.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(tfname);

        rules=new JButton("Rules");
        rules.setBounds(735,270,120,25);
        rules.setBackground(Color.PINK);
        rules.setForeground(Color.BLACK);
        rules.addActionListener(this); //This shows ki yeh button h , ispe click hokar kuch hoga
        add(rules);

        back=new JButton("Back");
        back.setBounds(915,270,120,25);
        back.setBackground(Color.PINK);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        add(back);

        setSize(1200,500);
        setLocation(200,200);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()== rules){
            String name=tfname.getText();
            //To get the string in the textfield that user enetered
            setVisible(false);
            new Rules(name);
            //It should open new frame
        }else if (ae.getSource()== back){
            setVisible(false);
            //Back button ke click karke frame should end

        }

    }
    public static void main(String[] args) {
        new Login(); //Creating object of login class ->Anonymous object
    }
}
