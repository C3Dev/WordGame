
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Player
{
    private String Id;
    private String LastName = "";
    private String FirstName = "";
    private int GamesPlayed = 0;
    private int GamesWon = 0;
    private boolean newPlayer;

    public String getLastName()
    {
        return LastName;
    }

    public int getGamesPlayed()
    {
        return GamesPlayed;
    }

    public int getGamesWon()
    {
        return GamesWon;
    }

    public String getFirstName()
    {
        return FirstName;
    }

    public Player()
    {
        newPlayer = false;
    }

    public Player(String Id, String LastName, String FirstName, int roundsPlayed, int roundsWon)
    {
        this.Id = Id;
        this.LastName = LastName;
        this.FirstName = FirstName;
        this.GamesPlayed = roundsPlayed;
        this.GamesWon = roundsWon;
    }

    public boolean Login(String Id)
    {
        boolean result = false;
        try
        {
            FileReader fr = new FileReader("players.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while((line = br.readLine()) != null)
            {
                line = line.trim();
                if(line.equals(Id))
                {
                    this.Id = Id;
                    result = true;
                }
            }
            br.close();
            fr.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }

        if(result) this.Load();
        return result;
    }

    private void Load()
    {
        try
        {
            FileReader fr = new FileReader(Id+".txt");
            BufferedReader br = new BufferedReader(fr);
            LastName = br.readLine();
            FirstName = br.readLine();
            GamesPlayed = Integer.parseInt(br.readLine());
            GamesWon = Integer.parseInt(br.readLine());
            br.close();
            fr.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
    }

    public void Register()
    {
        newPlayer = true;
        boolean unique = true;
        Scanner scanner = new Scanner(System.in);
        do
        {
            try
            {
                if(!unique)
                    System.out.println("Your id exists already please try again.");
                System.out.print("Please enter your id:");
                Id = scanner.nextLine();
                FileReader fr = new FileReader("players.txt");
                BufferedReader br = new BufferedReader(fr);
                String line = "";
                while((line = br.readLine()) != null)
                {
                    if(line.equals(Id))
                    {
                        unique = false;
                    }
                }
                br.close();
                fr.close();
            }
            catch(Exception ex)
            {
                System.out.println(ex.toString());
            }
        } while(!unique);

        System.out.print("Please enter your last name :");
        LastName = scanner.nextLine();
        System.out.print("Please enter your first name :");
        FirstName = scanner.nextLine();
    }

    public void AddGamesWon()
    {
        GamesWon++;
    }

    public void AddGamesPlayed()
    {
        GamesPlayed++;
    }

    public void Save()
    {
        if(newPlayer)
        {
            try
            {
                FileWriter fw = new FileWriter(new File("players.txt"),true);
                fw.write(Id+"\n");
                fw.flush();
                fw.close();
            }
            catch(Exception ex)
            {
                System.out.println(ex.toString());
            }
        }

        try
        {
            FileWriter fw1 = new FileWriter(new File(Id + ".txt"));
            fw1.write(LastName + "\n");
            fw1.write(FirstName + "\n");
            fw1.write(GamesPlayed + "\n");
            fw1.write(GamesWon + "\n");
            fw1.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        
    }
}
			
	

		
			
			

		
	         
