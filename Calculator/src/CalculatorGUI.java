import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame implements ActionListener {
    //Number buttons
    JButton one,two,three,four,five,six,seven,eight,nine,zero;

    //Operation buttons
    JButton plus,minus,multiply,divide,equals,reset;

    //result
    JLabel result,display;

    Calculator calculator;

    public CalculatorGUI(){
        super("Calculator");

        setSize(312,650);

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

        one=new JButton("1");
        one.setBounds(8,120,65,100);
        one.setFont(new Font("Dialog",Font.BOLD,18));
        one.addActionListener(this);
        add(one);

        two=new JButton("2");
        two.setBounds(81,120,65,100);
        two.setFont(new Font("Dialog",Font.BOLD,18));
        two.addActionListener(this);
        add(two);

        three=new JButton("3");
        three.setBounds(154,120,65,100);
        three.setFont(new Font("Dialog",Font.BOLD,18));
        three.addActionListener(this);
        add(three);

        plus=new JButton("+");
        plus.setBounds(227,120,65,100);
        plus.setFont(new Font("Dialog",Font.BOLD,18));
        plus.addActionListener(this);
        add(plus);

        four=new JButton("4");
        four.setBounds(8,240,65,100);
        four.setFont(new Font("Dialog",Font.BOLD,18));
        four.addActionListener(this);
        add(four);

        five=new JButton("5");
        five.setBounds(81,240,65,100);
        five.setFont(new Font("Dialog",Font.BOLD,18));
        five.addActionListener(this);
        add(five);

        six=new JButton("6");
        six.setBounds(154,240,65,100);
        six.setFont(new Font("Dialog",Font.BOLD,18));
        six.addActionListener(this);
        add(six);

        minus=new JButton("-");
        minus.setBounds(227,240,65,100);
        minus.setFont(new Font("Dialog",Font.BOLD,18));
        minus.addActionListener(this);
        add(minus);

        seven=new JButton("7");
        seven.setBounds(8,360,65,100);
        seven.setFont(new Font("Dialog",Font.BOLD,18));
        seven.addActionListener(this);
        add(seven);

        eight=new JButton("8");
        eight.setBounds(81,360,65,100);
        eight.setFont(new Font("Dialog",Font.BOLD,18));
        eight.addActionListener(this);
        add(eight);

        nine=new JButton("9");
        nine.setBounds(154,360,65,100);
        nine.setFont(new Font("Dialog",Font.BOLD,18));
        nine.addActionListener(this);
        add(nine);

        multiply=new JButton("*");
        multiply.setBounds(227,360,65,100);
        multiply.setFont(new Font("Dialog",Font.BOLD,18));
        multiply.addActionListener(this);
        add(multiply);

        reset=new JButton("C");
        reset.setBounds(8,480,65,100);
        reset.setFont(new Font("Dialog",Font.BOLD,18));
        add(reset);

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText("");
            }
        });

        zero=new JButton("0");
        zero.setBounds(81,480,65,100);
        zero.setFont(new Font("Dialog",Font.BOLD,18));
        zero.addActionListener(this);
        add(zero);

        equals=new JButton("=");
        equals.setBounds(154,480,65,100);
        equals.setFont(new Font("Dialog",Font.BOLD,18));
        equals.addActionListener(this);
        add(equals);

        divide=new JButton("/");
        divide.setBounds(227,480,65,100);
        divide.setFont(new Font("Dialog",Font.BOLD,18));
        divide.addActionListener(this);
        add(divide);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==equals) {
            String s= calculator.doCalculations(display.getText());
            display.setText(s);
            return;
        }

        display.setText(display.getText() + e.getActionCommand());
    }

}

