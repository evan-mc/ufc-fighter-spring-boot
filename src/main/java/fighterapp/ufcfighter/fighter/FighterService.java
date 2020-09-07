package fighterapp.ufcfighter.fighter;

import com.ftpix.sherdogparser.Sherdog;
import com.ftpix.sherdogparser.exceptions.SherdogParserException;
import com.ftpix.sherdogparser.models.Fighter;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class FighterService
{
    List<Fighter> fighters;

    List<String> names;
    public FighterService() throws IOException, ParseException, SherdogParserException
    {
        //move this to getFighterNames() once full app is done
        names = new ArrayList<>();
        //using this to test data so I dont have to wait a minute to build
        File file = new File("C:\\Folder of stuff\\Computer science stuff\\my stuff\\spring-apps\\ufcfighter\\src\\main\\resources\\topten.txt");
        Scanner scanner = new Scanner(file);
        while(scanner.hasNext())
        {
            String name = scanner.next();
            names.add(name.substring(32).replaceAll("[0-9\\-]", ""));
        }

        /*fighters = new ArrayList<>(10);

        Sherdog parser = new Sherdog.Builder().build();

        File file = new File("C:\\Folder of stuff\\Computer science stuff\\my stuff\\spring-apps\\ufcfighter\\src\\main\\resources\\topten.txt");
        Scanner scanner = new Scanner(file);

        while(scanner.hasNext())
        {
            fighters.add(parser.getFighter(scanner.next()));
            //sleep for 10 seconds so im not spamming their website
            try
            {
                Thread.sleep(10000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }*/
    }

    public List<String> getFighterNames()
    {
        /*for(int i = 0; i < fighters.size(); ++i)
        {
            names.add(fighters.get(i).getName());
        }*/

        return names;
    }

    public Boolean fighterExists(String name)
    {
        return names.contains(name);
    }
}
