package com.sadman.medicalinventory.service;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.iservice.RoleService;
import com.sadman.medicalinventory.model.Role;
import com.sadman.medicalinventory.model.User;
import com.sadman.medicalinventory.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository repository;

    public List<Role> getAllRoles() {
        return repository.findAll();
    }

    public Role getRoleById(Long id) throws RecordNotFoundException {
        return repository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Role createRole(Role role){
        return repository.save(role);
    }

    public Role updateRole(Role newRole, Long id) {
        return repository.findById(id)
                .map(role -> {
                    role.setName(newRole.getName());
                    return repository.save(role);
                })
                .orElseGet(() -> {
                    newRole.setId(id);
                    return repository.save(newRole);
                });
    }

    public void deleteRoleById(Long id){
        repository.deleteById(id);
    }
}
