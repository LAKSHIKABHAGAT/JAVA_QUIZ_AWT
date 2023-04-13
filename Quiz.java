package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz extends JFrame implements ActionListener {

    String questions[][]=new String[10][5];
    //1 question , 4 Options 1 row main => total 5 columns
    String answers[][]=new String[10][2];
    String useranswers[][]=new String[10][1]; //10 question , 1 ans/column
    JLabel qno;
    JLabel question;
    ButtonGroup groupOptions;
    JRadioButton opt1,opt2,opt3,opt4;
    JButton next,lifeline,submit;

    public static int timer=15;
    public static int ans_given=0;
    public static int count=0;
    //Times up hone ke baad , to see
    public static int score=0;

    String name;
    Quiz(String username){
        this.name=username;
        setBounds(50,0,1440,850);
        getContentPane().setBackground(Color.WHITE);
        this.setLayout((LayoutManager)null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("com/company/quiz.jpg"));
       // To add component to frame use add function
        JLabel image =new JLabel(i1); //image ko JLabel m daal do
//        //Then add this to JFrame ,We have layouts in swing for how to place components on JFrame
        image.setBounds(0,0,1440,392);
        add(image);

        this.qno=new JLabel();
        this.qno.setBounds(100,450,50,30);
        this.qno.setFont(new Font("Tahoma",Font.PLAIN,24));
        this.add(this.qno);

        this.question=new JLabel();
        this.question.setBounds(150,450,900,30);
        this.question.setFont(new Font("Tahoma",Font.PLAIN,24));
        this.add(question);

        questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";

        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM";

         this.opt1=new JRadioButton();
        this.opt1.setBounds(170, 520, 700, 30);
        this.opt1.setBackground(Color.WHITE);
        this.opt1.setFont(new Font("Dialog",Font.PLAIN,20));
        this.add(opt1);

        this.opt2=new JRadioButton();
        this.opt2.setBounds(170, 560, 700, 30);
        this.opt2.setBackground(Color.WHITE);
        this.opt2.setFont(new Font("Dialog",Font.PLAIN,20));
        this.add(opt2);

        this.opt3=new JRadioButton();
        this.opt3.setBounds(170, 600, 700, 30);
        this.opt3.setBackground(Color.WHITE);
        this.opt3.setFont(new Font("Dialog",Font.PLAIN,20));
        this.add(opt3);

        this.opt4=new JRadioButton();
        this.opt4.setBounds(170, 640, 700, 30);
        this.opt4.setBackground(Color.WHITE);
        this.opt4.setFont(new Font("Dialog",Font.PLAIN,20));
        this.add(opt4);

        this.groupOptions=new ButtonGroup();
        this.groupOptions.add(opt1);
        this.groupOptions.add(opt2);
        this.groupOptions.add(opt3);
        this.groupOptions.add(opt4);
        //To select exactly one option out of 4

        this.next=new JButton("Next");
        this.next.setBounds(1100,550,200,40);
        this.next.setFont(new Font("Tahoma",Font.PLAIN,22));
        this.next.setBackground(Color.MAGENTA);
        this.next.setForeground(Color.BLACK);
        next.addActionListener(this);
        this.add(next);

        this.lifeline=new JButton("50-50 lifeline");
        this.lifeline.setBounds(1100,630,200,40);
        this.lifeline.setFont(new Font("Tahoma",Font.PLAIN,22));
        this.lifeline.setBackground(Color.MAGENTA);
        this.lifeline.setForeground(Color.BLACK);
        lifeline.addActionListener(this);
        this.add(lifeline);

        this.submit=new JButton("submit");
        this.submit.setBounds(1100,710,200,40);
        this.submit.setFont(new Font("Tahoma",Font.PLAIN,22));
        this.submit.setBackground(Color.MAGENTA);
        this.submit.setForeground(Color.BLACK);
        submit.addActionListener(this);
        this.add(submit);
        //To disable submit button initially
        this.submit.setEnabled(false);

        start(0);

        setVisible(true);
    }
    //Graphics class ka use for setting timer
    public void paint(Graphics g){
        //paint method is itself called as soon as object is created
        //It is called once , to call it again , after 1sec use repaint() method
        super.paint(g);
        String time="Time left "+timer + " seconds";
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma",Font.BOLD,25));
        if (timer>0){
            g.drawString(time,1100,500);
        }
        else{
            g.drawString("Times up!! ",1100,500);
        }
        timer--;
        try{
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(ans_given==1){
            ans_given=0;
            timer=15;
        }else if(timer < 0) { //ans nhi diya h , next karke , timer=15
            timer = 15;
            this.opt1.setEnabled(true);
            this.opt2.setEnabled(true);
            this.opt3.setEnabled(true);
            this.opt4.setEnabled(true);
            if (count == 8) {
                this.next.setEnabled(false);
                this.submit.setEnabled(true);
            }
            if (count == 9) {
                //times up par submit nhi kiya , so auto-submit it
                //Also , calculate total marks after submission
                if (groupOptions.getSelection() == null) {
                    useranswers[count][0] = "";

                } else {//getActionCommand returns value of selected option
                    useranswers[count][0] = groupOptions.getSelection().getActionCommand();

                }
                for(int i=0;i< useranswers.length;i++){
                    if(useranswers[i][0].equals(answers[i][1])){
                        score+=10;
                    }
                    else{
                        score+=0;
                    }
                }
                setVisible(false);//closing the screen
            } else {
                //to check if ans is given by user or not within time
                //getselection Method will return the one option ,if selected by user

                if (groupOptions.getSelection() == null) {
                    useranswers[count][0] = "";

                } else {//getActionCommand returns value of selected option
                    useranswers[count][0] = groupOptions.getSelection().getActionCommand();

                }
                count++;
                start(count);

            }
        }

    }

//Questions , options print karwane ke liye start function
    private void start(int count) {
        //Convert int to string , inside label you cannot directly enter int , you need to pass a string

        qno.setText(" " +(count + 1 )+ ". ");
        question.setText(questions[count][0]);

        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        //This is used to clear the selected option ,jab next par click hoga toh 2nd ka automatically ans display ho jayega
        groupOptions.clearSelection();

    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            this.opt1.setEnabled(true);
            this.opt2.setEnabled(true);
            this.opt3.setEnabled(true);
            this.opt4.setEnabled(true);
            ans_given = 1;
            if (groupOptions.getSelection() == null) {
                this.useranswers[count][0] = "";

            } else {//getActionCommand returns value of selected option
                this.useranswers[count][0] = groupOptions.getSelection().getActionCommand();

            }
            //last question pe next disabled ,submit enabled
            if (count == 8) {
               this. next.setEnabled(false);
                this.submit.setEnabled(true);
            }
            ++count;
            this.start(count);

           }else if (ae.getSource() == lifeline) {
            if (count != 2 && count != 4 && count != 6 && count != 8 && count != 9) {
                this.opt1.setEnabled(false);
                this.opt4.setEnabled(false);
            } else {
                this.opt2.setEnabled(false);
                this.opt3.setEnabled(false);
            }
            this.lifeline.setEnabled(false);
        }else if(ae.getSource()==submit){
            ans_given = 1;
            if (this.groupOptions.getSelection() == null) {
                this.useranswers[count][0] = "";
            } else {
                this.useranswers[count][0] = this.groupOptions.getSelection().getActionCommand();
            }
            for(int i = 0; i < this.useranswers.length; ++i) {
                if (this.useranswers[i][0].equals(this.answers[i][1])) {
                    score += 10;
                } else {
                    score += 0;
                }
            }
            this.setVisible(false);
            new score(this.name, score);
        }
    }
    public static void main(String[] args) {
        new Quiz("user");
    }


}
