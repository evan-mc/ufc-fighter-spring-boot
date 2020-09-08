package fighterapp.ufcfighter.fighter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class FighterController
{
    @Autowired
    FighterService fighterService;

    @GetMapping("/")
    public String getAllFighters(Model model)
    {
        model.addAttribute("names", fighterService.getFighterNames());
        return "homePage";
    }

    @GetMapping("/fighter/{name}")
    public String getFighter(@PathVariable String name, Model model)
    {
        if(fighterService.fighterExists(name))
        {
            model.addAttribute("fighterWins", fighterService.getFighter(name).getWins());
            model.addAttribute("fighterLosses", fighterService.getFighter(name).getLosses());
            model.addAttribute("fighterNoContest", fighterService.getFighter(name).getNc());
            return ("/fighters/" + name);
        }
        else
        {
            return "invalidFighter";
        }
    }
}
