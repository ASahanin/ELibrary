package kg.elibrary.demo.service;

import kg.elibrary.demo.entity.User;
import kg.elibrary.demo.entity.UserRole;
import kg.elibrary.demo.model.UserRoleModel;
import kg.elibrary.demo.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService{
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private UserService userService;
    @Override
    public List<UserRole> findAll() {
        return userRoleRepository.findAll();
    }

    @Override
    public UserRole create(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    @Override
    public UserRole create(UserRoleModel userRoleModel) {
        User user = userService.getById(userRoleModel.getUserId());
        if(user == null) return null;
        UserRole userRole = new UserRole();
        userRole.setRoleName(userRoleModel.getRoleName());
        userRole.setUser(user);
        return userRoleRepository.save(userRole);
    }
}
