package fighterapp.ufcfighter.fighter;

import com.ftpix.sherdogparser.Sherdog;
import com.ftpix.sherdogparser.exceptions.SherdogParserException;
import com.ftpix.sherdogparser.models.Fighter;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

@Service
public class FighterService
{
    Map<String, Fighter> fighterMap;
    public FighterService() throws IOException, ParseException, SherdogParserException
    {
        fighterMap = new HashMap<>();

        Sherdog parser = new Sherdog.Builder().build();

        File file = new File("C:\\Folder of stuff\\Computer science stuff\\my stuff\\spring-apps\\ufcfighter\\src\\main\\resources\\topten.txt");
        Scanner scanner = new Scanner(file);

        while(scanner.hasNext())
        {
            Fighter fighter = parser.getFighter(scanner.next());
            //strips whitespace from name
            String fighterName = fighter.getName().replaceAll("\\s","");

            fighterMap.put(fighterName, fighter);

            //sleep for 10 seconds so im not spamming their website
            try
            {
                Thread.sleep(10000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    public List<String> getFighterNames()
    {
        return new ArrayList<>(fighterMap.keySet());
    }

    public Boolean fighterExists(String name)
    {
        return fighterMap.containsKey(name);
    }

    public Fighter getFighter(String name)
    {
        return fighterMap.get(name);
    }
}
