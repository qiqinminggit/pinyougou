package tourism.network.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import tourism.network.Permission;
import tourism.network.Role;
import tourism.network.service.IRoleService;

import java.util.List;
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService roleService;


    //查询所有角色以及能够添加的权限
    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id",required = true) String roleId) throws Exception{
        ModelAndView mv=new ModelAndView();
        //1.根据角色id查询role
       Role role= roleService.findById(roleId);
        //2.根据角色id查询所有能够添加的权限
      List<Permission> permissionList=  roleService.findOtherPermissions(roleId);
      mv.addObject("role",role);
      mv.addObject("permissionList",permissionList);
      mv.setViewName("role-permission-add");
      return mv;

    }

    //添加权限
    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "roleId",required = true) String roleId,@RequestParam(name = "ids",required = true) String[] permissionIds){
        roleService.addPermissionToRole(roleId,permissionIds);
        return "redirect:findAll.do";
    }


    //查询所有角色
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception{
        ModelAndView mv=new ModelAndView();
        List<Role> roleList=roleService.findAll();
        mv.addObject("roleList",roleList);
        mv.setViewName("role-list");
        return mv;

    }
    //增加角色
    @RequestMapping("/save.do")
    public String save(Role role) throws Exception{
        roleService.save(role);
        return "redirect:findAll.do";
    }

    /**
     * 角色详情查询
     * @param roleId
     * @return
     */
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name="id",required = true) String roleId) throws Exception{
        ModelAndView mv=new ModelAndView();
        Role role = roleService.findById(roleId);
        mv.addObject("role",role);
        mv.setViewName("role-show");
        return mv;

    }

    /**
     * 删除角色
     * @param roleId
     * @return
     * @throws Exception
     */
    @RequestMapping("/deleteRole.do")
    public String deleteRole(@RequestParam(name = "id",required = true) String roleId) throws Exception{
        roleService.deleteRole(roleId);
        return "redirect:findAll.do";
    }

}
