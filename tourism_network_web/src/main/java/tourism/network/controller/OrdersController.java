package tourism.network.controller;


import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import tourism.network.Orders;
import tourism.network.service.IOrdersService;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private IOrdersService ordersService;

    //查询全部订单未分页的
//    @RequestMapping("/findAll.do")
//    public ModelAndView findAll() throws Exception {
//
//        ModelAndView mv=new ModelAndView();
//        List<Orders> ordersList = ordersService.findAll();
//        mv.addObject("ordersList`",ordersList);
//        mv.setViewName("orders-list");
//        return mv ;
//    }

    /**
     * 查询所有订单
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,@RequestParam(name = "size",required = true,defaultValue = "3")Integer size) throws Exception {
        ModelAndView mv=new ModelAndView();
        List<Orders> ordersList = ordersService.findAll(page, size);
        //PageInfo就是一个分页的Bean
        PageInfo pageInfo=new PageInfo(ordersList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }

    /**
     * 查询一个订单
     * @param ordersId
     * @return
     * @throws Exception
     */
    @RequestMapping("findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true)String ordersId) throws  Exception{
        ModelAndView mv=new ModelAndView();
       Orders orders= ordersService.findById(ordersId);
       mv.addObject("orders",orders);
       mv.setViewName("orders-show");
       return mv;
    }
    @RequestMapping("/delete.do")
    public String delete(String id) throws Exception {
        ordersService.delete(id);
        return "redirect:findAll.do";
    }
}
