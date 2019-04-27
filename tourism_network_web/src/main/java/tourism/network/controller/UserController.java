package tourism.network.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import tourism.network.Role;
import tourism.network.UserInfo;
import tourism.network.service.IUserService;

import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {
  @Autowired
  private IUserService userService;


  //查询用户以及能添加的角色
    @RequestMapping("findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id",required = true) String userId) throws Exception {
        ModelAndView mv=new ModelAndView();
        //1.根据用户id查询用户
        UserInfo userInfo= userService.findById(userId);

        //2.根据用户id查询能够添加的角色
       List<Role> otherRoles= userService.findOtherRoles(userId);

       mv.addObject("user",userInfo);
       mv.addObject("roleList",otherRoles);
       mv.setViewName("user-role-add");
       return mv;

    }

    //添加角色
    @RequestMapping("/addRoleToUser.do")
    @PreAuthorize("authentication.principal.username=='admin'")

    public String addRoleToUser(@RequestParam(name = "userId",required = true) String userid,@RequestParam(name = "ids",required = true) String[] roleIds){

        userService.addRoleToUser(userid,roleIds);
        return "redirect:findAll.do";
    }


@RequestMapping("findAll.do")
    public ModelAndView findAll() throws Exception{
        ModelAndView mv=new ModelAndView();
        List<UserInfo> userList= userService.findAll();
        mv.addObject("userList",userList);
        mv.setViewName("user-list");
        return mv;
    }
    //用户添加
    @PreAuthorize("authentication.principal.username=='admin'")
    @RequestMapping("save.do")
    public String save(UserInfo userInfo) throws Exception{
        userService.save(userInfo);
        return "redirect:findAll.do";
    }

    //查询用户详情
    @RequestMapping("/findById.do")
    public ModelAndView findById(String id) throws Exception{
    ModelAndView mv=new ModelAndView();
    UserInfo userInfo=userService.findById(id);
    mv.addObject("user",userInfo);
    mv.setViewName("user-show");
    return mv;
    }
}