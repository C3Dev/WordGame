
import java.util.Scanner;

public class Assig2
{
    public static void main(String[] args)
    {
        Player player = new Player();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to The Scrambler");

        String response = "";
        while(true)
        {
            System.out.print("Have you visited with us before (Y/N)?:");
            response = scanner.next().toLowerCase();
            if(response.equals("y") || response.equals("n")) break;
            else System.out.println("Invalid Input !!!");
        }

        if(response.equals("y"))
        {
            int cnt = 0;
            while(cnt < 3)
            {
                System.out.print("Please enter your ID:");
                String id = scanner.next().trim();
                if(player.Login(id)) break;
                else 
                {
                    System.out.println("Your ID is taken - please choose again");
                    cnt++;
                }
            }
            if(cnt == 3) 
            {
                System.out.println("Sorry, we could not log you in");
                System.exit(0);
            }
        }

        if(response.equals("n"))
        {
            System.out.println("Welcome to The Scrambler");
            player.Register();
        }

        Scrambler scrambler = new Scrambler();
        scrambler.ChooseRandom();
        System.out.println("You have 5 guesses to guess today's Scramble");
        System.out.println("Good luck!");
        
        boolean flag = false;
        for(int i=0;i<5;i++)
        {
            System.out.println("Scramble: " + scrambler.getScrambledWord());
            System.out.print("Your Guess: ");
            String guess = scanner.next();
            if(scrambler.Check(guess))
            {
                flag = true;
                player.AddGamesWon();
                player.AddGamesPlayed();
                System.out.println("Great Job!  You got it!\n");
                System.out.println("Here is your updated information: ");
                System.out.println("\tName: " + player.getFirstName() + " " + player.getLastName());
                System.out.println("\tTotal Rounds Played: " + player.getGamesPlayed());
                System.out.println("\tTotal Rounds Won: " + player.getGamesWon());

                break;
            }
            System.out.println("You have " + (4 - i) + " guesses remaining");
        }
        if(!flag)
        {
            player.AddGamesPlayed();
            System.out.println("Game over!  Better luck next time!");
            System.out.println("The actual word is " + scrambler.getOriginalWord());
        }

        
        player.Save();
    }
}
