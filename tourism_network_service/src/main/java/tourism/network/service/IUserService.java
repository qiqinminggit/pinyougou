package tourism.network.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import tourism.network.Role;
import tourism.network.UserInfo;

import java.util.List;

public interface IUserService extends UserDetailsService {
    //查询所有用户
    List<UserInfo> findAll() throws Exception;
    //增加用户
    void save(UserInfo userInfo) throws  Exception;
    //通过id查询显示详情
    UserInfo findById(String id);

    List<Role> findOtherRoles(String userId) throws Exception;

    void addRoleToUser(String userid, String[] roleIds);
}
