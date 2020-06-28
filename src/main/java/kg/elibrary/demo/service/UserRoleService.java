package kg.elibrary.demo.service;

import kg.elibrary.demo.entity.UserRole;
import kg.elibrary.demo.model.UserRoleModel;

import java.util.List;

public interface UserRoleService {
    List<UserRole> findAll();
    UserRole create(UserRole userRole);
    UserRole create(UserRoleModel userRoleModel);
}

