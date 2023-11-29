package com.example.brussel.be.junit_tests;

import com.example.brussel.be.model.Role;
import com.example.brussel.be.repo.RoleRepository;
import com.example.brussel.be.service.RoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class RoleServiceTest {

    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void testGetAllRoles() {
        List<Role> roles = roleService.getAllRoles();
        assertEquals(1, roles.size());
    }

    @Test
    public void testSaveAndGetRole() {
        Role role = new Role();
        role.setRoleName("ROLE_USER");

        Role savedRole = roleService.saveRole(role);
        Long roleId = savedRole.getId();

        Optional<Role> retrievedRole = roleService.getRoleById(roleId);
        assertTrue(retrievedRole.isPresent());
        assertEquals("ROLE_USER", retrievedRole.get().getRoleName());
    }

    @Test
    public void testDeleteRole() {
        Role role = new Role();
        role.setRoleName("ROLE_ADMIN");

        Role savedRole = roleService.saveRole(role);
        Long roleId = savedRole.getId();

        roleService.deleteRole(roleId);

        Optional<Role> deletedRole = roleService.getRoleById(roleId);
        assertTrue(deletedRole.isEmpty());
    }
}