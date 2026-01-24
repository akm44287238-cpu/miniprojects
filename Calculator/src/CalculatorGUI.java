import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame implements ActionListener {
    //Number buttons
    JButton one,two,three,four,five,six,seven,eight,nine,zero;

    //Operation buttons
    JButton plus,minus,multiply,divide,equals,reset,dot,back;

    //result
    JLabel numberDisplay,display,operator;

    Calculator calculator;

    public CalculatorGUI(){
        super("Calculator");

        setSize(312,500);

        setLayout(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        calculator=new Calculator();

        addGUIComponents();
    }

    private void addGUIComponents(){
        display=new JLabel("");
        display.setBounds(25,20,250,50);
        display.setFont(new Font("Dialog",Font.BOLD,26));
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.BLACK));
        add(display);

        numberDisplay=new JLabel("");
        numberDisplay.setBounds(28,20,100,15);
        numberDisplay.setFont(new Font("Dialog",Font.BOLD,12));
        numberDisplay.setHorizontalAlignment(SwingConstants.LEFT);
        add(numberDisplay);

        operator=new JLabel("");
        operator.setBounds(28,35,50,25);
        operator.setFont(new Font("Dialog",Font.BOLD,26));
        operator.setHorizontalAlignment(SwingConstants.LEFT);
        add(operator);



        one=new JButton("1");
        one.setBounds(8,190,65,60);
        one.setFont(new Font("Dialog",Font.BOLD,18));
        one.addActionListener(this);
        add(one);

        two=new JButton("2");
        two.setBounds(81,190,65,60);
        two.setFont(new Font("Dialog",Font.BOLD,18));
        two.addActionListener(this);
        add(two);

        three=new JButton("3");
        three.setBounds(154,190,65,60);
        three.setFont(new Font("Dialog",Font.BOLD,18));
        three.addActionListener(this);
        add(three);

        plus=new JButton("+");
        plus.setBounds(227,190,65,60);
        plus.setFont(new Font("Dialog",Font.BOLD,18));
        plus.addActionListener(this);
        add(plus);

        four=new JButton("4");
        four.setBounds(8,260,65,60);
        four.setFont(new Font("Dialog",Font.BOLD,18));
        four.addActionListener(this);
        add(four);

        five=new JButton("5");
        five.setBounds(81,260,65,60);
        five.setFont(new Font("Dialog",Font.BOLD,18));
        five.addActionListener(this);
        add(five);

        six=new JButton("6");
        six.setBounds(154,260,65,60);
        six.setFont(new Font("Dialog",Font.BOLD,18));
        six.addActionListener(this);
        add(six);

        minus=new JButton("-");
        minus.setBounds(227,260,65,60);
        minus.setFont(new Font("Dialog",Font.BOLD,18));
        minus.addActionListener(this);
        add(minus);

        seven=new JButton("7");
        seven.setBounds(8,330,65,60);
        seven.setFont(new Font("Dialog",Font.BOLD,18));
        seven.addActionListener(this);
        add(seven);

        eight=new JButton("8");
        eight.setBounds(81,330,65,60);
        eight.setFont(new Font("Dialog",Font.BOLD,18));
        eight.addActionListener(this);
        add(eight);

        nine=new JButton("9");
        nine.setBounds(154,330,65,60);
        nine.setFont(new Font("Dialog",Font.BOLD,18));
        nine.addActionListener(this);
        add(nine);

        multiply=new JButton("*");
        multiply.setBounds(227,330,65,60);
        multiply.setFont(new Font("Dialog",Font.BOLD,18));
        multiply.addActionListener(this);
        add(multiply);

        reset=new JButton("C");
        reset.setBounds(227,120,65,60);
        reset.setFont(new Font("Dialog",Font.BOLD,18));
        add(reset);

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText("");
                numberDisplay.setText("");
                operator.setText("");
            }
        });

        zero=new JButton("0");
        zero.setBounds(81,400,65,60);
        zero.setFont(new Font("Dialog",Font.BOLD,18));
        zero.addActionListener(this);
        add(zero);

        equals=new JButton("=");
        equals.setBounds(154,400,65,60);
        equals.setFont(new Font("Dialog",Font.BOLD,18));
        equals.addActionListener(this);
        add(equals);

        divide=new JButton("/");
        divide.setBounds(227,400,65,60);
        divide.setFont(new Font("Dialog",Font.BOLD,18));
        divide.addActionListener(this);
        add(divide);

        dot=new JButton(".");
        dot.setBounds(8,400,65,60);
        dot.setFont(new Font("Dialog",Font.BOLD,18));
        add(dot);

        dot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String check= display.getText();
                if(!check.contains(".")){
                    display.setText(display.getText()+".");
                }
            }
        });

        back=new JButton("⌫");
        back.setBounds(8,120,65,60);
        back.setFont(new Font("Dialog",Font.BOLD,18));
        add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if((!(display.getText()).equals(""))){
                    String s = display.getText();
                    s=s.substring(0,s.length()-1);
                    display.setText(s);
                }
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==minus || e.getSource()==multiply || e.getSource()==divide || e.getSource()==plus) {

            if((operator.getText()).equals("=") || (operator.getText()).equals("")){
                operator.setText(e.getActionCommand());
                numberDisplay.setText(display.getText());
                display.setText("");
                return;
            }
            String s= calculator.doCalculations(numberDisplay.getText(),operator.getText(),display.getText());
            numberDisplay.setText(s);
            operator.setText(e.getActionCommand());
            display.setText("");
            return;
        }


        if (e.getSource()==equals) {
            String s= calculator.doCalculations(numberDisplay.getText(),operator.getText(),display.getText());
            display.setText(s);
            numberDisplay.setText("");
            operator.setText("=");
            return;
        }

        display.setText(display.getText() + e.getActionCommand());
    }

}
