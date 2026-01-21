import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JColorChooser.showDialog;

public class RockPaperScissorGUI extends JFrame implements ActionListener{

    //player buttons
    JButton rockButton,paperButton,scissorButton;

    //will display choice of computer
    JLabel computerChoice;

    JLabel computerScoreLabel,playerScoreLabel;

    RockPaperScissor rockPaperScissor;

    public RockPaperScissorGUI(){
        //invoke jfarme constructor amd add title to the GUI
        super("Rock Paper Scissors");

        //set size of GUI
        setSize(450,574);

        //set layout to null to disable layout management, so we can use asolute positioning for the elements
        // that is setting x,y co-ords and width/height values
        setLayout(null);

        //terminate the java virtual machine when closing the GUI
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        //load GUI in the center of the screen everytime we run the application
        setLocationRelativeTo(null);

        rockPaperScissor=new RockPaperScissor();

        //add GUI components
        addGUIComponents();  //adding in another method to keep code clean
    }

    private void addGUIComponents(){
        //create computer score label
        computerScoreLabel=new JLabel("Computer: 0");

        //set x,y co-ords and width/length value
        computerScoreLabel.setBounds(0,30,450,30);

        //set the font family to have a font family of dialog, font-weight bold and font size 26
        computerScoreLabel.setFont(new Font("Dialog",Font.BOLD,26));

        //place the text in center
        computerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //add to GUI
        add(computerScoreLabel);

        //create computer choice
        computerChoice=new JLabel("?");
        computerChoice.setBounds(175,100,100,80);
        computerChoice.setFont(new Font("Dialog",Font.PLAIN,18));
        computerChoice.setHorizontalAlignment(SwingConstants.CENTER);

        //create a black border
        computerChoice.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        add(computerChoice);

        //create player score label
        playerScoreLabel=new JLabel("Player: 0");
        playerScoreLabel.setBounds(98,230,250,30);
        playerScoreLabel.setFont(new Font("Dialog",Font.BOLD,26));
        playerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(playerScoreLabel);

        //player buttons

        //rock button
        rockButton = new JButton("Rock");
        rockButton.setBounds(12,300,130,80);
        rockButton.setFont(new Font("Dialog",Font.PLAIN,18));
        rockButton.addActionListener(this);
        add(rockButton);

        //paper button
        paperButton = new JButton("Paper");
        paperButton.setBounds(154,300,130,80);
        paperButton.setFont(new Font("Dialog",Font.PLAIN,18));
        paperButton.addActionListener(this);
        add(paperButton);

        //scissor button
        scissorButton = new JButton("Scissors");
        scissorButton.setBounds(296,300,130,80);
        scissorButton.setFont(new Font("Dialog",Font.PLAIN,18));
        scissorButton.addActionListener(this);
        add(scissorButton);

    }

    //displays a message dialog which will show the winner and a try again button to play again
    private void dialog(String message){
        JDialog resultDialog=new JDialog(this,"Result",true);
        //owner refers to parent object which in this case is our GUI which is represented by this keyword
        //title represents the title of Dialog same as main GUI
        //modal refers to property of dialog that requires the users immediate attention and blocks input to anything else until its closed
        resultDialog.setSize(250,150);
        resultDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        resultDialog.setResizable(false);

        //message label
        JLabel resultLabel=new JLabel(message);
        resultLabel.setFont(new Font("Dialog",Font.BOLD,18));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultDialog.add(resultLabel,BorderLayout.CENTER);

        //try again button
        JButton tryAgainButton=new JButton("Try Again?");
        tryAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //reset computer choice
                computerChoice.setText("?");

                //close the dialog box
                resultDialog.dispose();
            }
        });
        resultDialog.add(tryAgainButton,BorderLayout.SOUTH);

        resultDialog.setLocationRelativeTo(this);
        resultDialog.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //get player choice
        String playerChoice = e.getActionCommand().toString();

        String result = rockPaperScissor.playRockPaperScissor(playerChoice);

        //load computers choice
        computerChoice.setText(rockPaperScissor.getComputerChoice());

        //update score
        computerScoreLabel.setText("Computer: " +rockPaperScissor.getComputerScore());
        playerScoreLabel.setText("Player: " +rockPaperScissor.getPlayerScore());

        //display result dialog
        dialog(result);
    }
}













