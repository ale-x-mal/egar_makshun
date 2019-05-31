package org.egar.makshun.jdbc.dao;

import org.egar.makshun.jdbc.model.Permission;

import java.util.List;

public interface PermissionDao {

    Permission getOne(Long permissionId);

    List<Permission> findAllPermissions();
}
