import java.util.Random;

public class RockPaperScissor {
    private static final String[] computerChoices = {"Rock", "Paper" , "Scissors"};


    public String getComputerChoice() {
        return computerChoice;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getComputerScore() {
        return computerScore;
    }

    private String computerChoice;

    private int playerScore,computerScore;

    //used to generate a random number
    private Random random;


    public RockPaperScissor(){
        random = new Random();
    }

    //call this to start playing
    //this method will return result of game(computer win,player win or draw)
    public String playRockPaperScissor(String playerChoice){
        computerChoice = computerChoices[random.nextInt(computerChoices.length)];


        //will contain returning message indicating result of game
        String result;

        //evaluate the winner
        if(computerChoice.equals("Rock")){
            if(playerChoice.equals("Paper")){
                result = "Player wins";
                playerScore++;
            }else if(playerChoice.equals("Scissors")){
                result = "Computer wins";
                computerScore++;
            }
            else{
                result = "Draw";
            }
        }else if(computerChoice.equals("Paper")){
            if(playerChoice.equals("Scissors")){
                result = "Player wins";
                playerScore++;
            }else if(playerChoice.equals("Rock")){
                result = "Computer wins";
                computerScore++;
            }
            else{
                result = "Draw";
            }
        }else{
            if(playerChoice.equals("Rock")){
                result = "Player wins";
                playerScore++;
            }else if(playerChoice.equals("Paper")){
                result = "Computer wins";
                computerScore++;
            }
            else{
                result = "Draw";
            }
        }
        return result;
    }
}





