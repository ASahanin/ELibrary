package kg.elibrary.demo.controller;

import kg.elibrary.demo.entity.UserRole;
import kg.elibrary.demo.model.UserRoleModel;
import kg.elibrary.demo.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test/user-role")
public class UserRoleController {
    @Autowired
    private UserRoleService userRoleService;

    @GetMapping
    public List<UserRole> getAll(){
        return userRoleService.findAll();
    }

    @PostMapping
    public UserRole create(@RequestBody UserRoleModel userRoleModel){
        return userRoleService.create(userRoleModel);
    }

    @PostMapping("/old")
    public UserRole create(@RequestBody UserRole userRole){
        return userRoleService.create(userRole);
    }
}
