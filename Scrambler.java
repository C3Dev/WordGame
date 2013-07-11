
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;


public class Scrambler
{
    private String originalWord;
    private String scrambledWord;

    public Scrambler()
    {
        
    }

    public String getOriginalWord()
    {
        return originalWord;
    }

    public String getScrambledWord()
    {
        return scrambledWord;
    }

    public Scrambler(String originalWord, String scrambledWord)
    {
        this.originalWord = originalWord;
        this.scrambledWord = scrambledWord;
    }

    public void ChooseRandom()
    {
        try
        {
            FileReader fr = new FileReader("words.txt");
            BufferedReader br = new BufferedReader(fr);

            int num = Integer.parseInt(br.readLine());

            Random rand = new Random();
            int randomNum = rand.nextInt(num);
            String line = "";
            int cnt = 0;
            while((line=br.readLine()) != null)
            {
                if(cnt == randomNum)
                {
                    originalWord = line;
                }
                cnt++;
            }

            br.close();
            fr.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        this.Scramble();
    }

    private void Scramble()
    {
        Random rand = new Random();
        scrambledWord = originalWord;
        for(int i=0;i<1000;i++)
        {
            int x = rand.nextInt(originalWord.length());
            String tmp = scrambledWord.substring(x) + scrambledWord.substring(0, x);
            scrambledWord = tmp;
        }
    }

    public boolean Check(String guess)
    {
        return originalWord.equals(guess.trim());
    }
}
