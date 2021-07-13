package com.sadman.medicalinventory.controller.api;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.iservice.RoleService;
import com.sadman.medicalinventory.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RoleController {
    @Autowired
    RoleService service;

    @GetMapping("/roles")
    public List<Role> getAllRoles(Model model) {
        return service.getAllRoles();
    }

    @GetMapping("/roles/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable(value = "id") Long roleId)
            throws RecordNotFoundException {
        Role role = service.getRoleById(roleId);
        return ResponseEntity.ok().body(role);
    }

    @PostMapping("/roles")
    public Role createRole(@Valid @RequestBody Role role) {
        return service.createRole(role);
    }

    @PutMapping("/roles/edit/{id}")
    public Role editRoleById(@RequestBody Role newRole, @PathVariable(value = "id") Long roleId) {
        return service.updateRole(newRole, roleId);
    }

    @DeleteMapping("/roles/delete/{id}")
    public void deleteRoleById(@PathVariable(value = "id") Long roleId){
        service.deleteRoleById(roleId);
    }
}
