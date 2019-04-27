package tourism.network.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import tourism.network.Traveller;
import tourism.network.service.ITravellerService;

import java.util.List;

@Controller
@RequestMapping("/traveller")
public class TravellerController {


    @Autowired
    private ITravellerService travellerService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv=new ModelAndView();
        List<Traveller> travellerList= travellerService.findAll();
        mv.addObject("travellerList",travellerList);
        mv.setViewName("traveller-list");
        return mv;
    }

}
