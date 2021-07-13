package com.sadman.medicalinventory.iservice;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.Role;

import java.util.List;

/**
 * @author Sadman
 */
public interface RoleService {
    public List<Role> getAllRoles();

    public Role getRoleById(Long id) throws RecordNotFoundException;

    public Role createRole(Role role);

    public Role updateRole(Role newRole, Long id);

    public void deleteRoleById(Long id);
}
