package tourism.network.service;

import tourism.network.Permission;
import tourism.network.Role;

import java.util.List;

public interface IRoleService {

    List<Role> findAll() throws Exception;


    void save(Role role);

    Role findById(String roleId);

    List<Permission> findOtherPermissions(String roleId);

    void addPermissionToRole(String roleId, String[] permissionIds);

    void deleteRole(String roleId);
}
