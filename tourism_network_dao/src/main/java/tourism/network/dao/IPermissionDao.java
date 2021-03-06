package tourism.network.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import tourism.network.Permission;

import java.util.List;

public interface IPermissionDao {
    //查询关联role权限的所有的数据
    @Select("select * from permission where id in(select permissionId from role_permission where roleId=#{id})")
    public List<Permission> findPermissionByRoleId(String id) throws Exception;

    @Select("select * from permission")
    List<Permission> findAll();


    @Insert("insert into permission(permissionName,url) values (#{permissionName},#{url})")
    void save(Permission permission);
}
