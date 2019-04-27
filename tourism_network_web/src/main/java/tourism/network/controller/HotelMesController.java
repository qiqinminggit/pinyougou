package tourism.network.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import tourism.network.Hotel;
import tourism.network.service.IHotelService;

import java.util.List;


@Controller
@RequestMapping("/hotel")
public class HotelMesController {


    @Autowired
    private IHotelService hotelService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv= new ModelAndView();
        List<Hotel> hotelList= hotelService.findAll();
        mv.addObject("hotelList",hotelList);
        mv.setViewName("hotel-list");
        return mv;
    }
}
