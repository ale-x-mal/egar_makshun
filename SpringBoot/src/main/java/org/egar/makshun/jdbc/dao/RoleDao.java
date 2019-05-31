package org.egar.makshun.jdbc.dao;

import org.egar.makshun.jdbc.model.Role;

import java.util.List;

public interface RoleDao {

    Role getOne(Long roleId);

    List<Role> findAllRoles();
}
