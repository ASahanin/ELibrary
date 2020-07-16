package kg.elibrary.demo.service;

import kg.elibrary.demo.entity.User;
import kg.elibrary.demo.entity.UserRole;
import kg.elibrary.demo.model.LoginModel;
import kg.elibrary.demo.model.RegistrationModel;
import kg.elibrary.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private  UserService userService;
    @Autowired
    private UserRoleService userRoleService;

    @Override
    public User create(User userModel) {
        User user = new User();
        String encodedPassword = passwordEncoder.encode(userModel.getPassword());
        user.setPassword(encodedPassword);
        user.setStatus(1);
        user.setLogin(userModel.getLogin());
        user =  userRepository.save(user);

        UserRole userRole = new UserRole();
        userRole.setRoleName("ROLE_USER");
        userRole.setUser(user);
        userRoleService.create(userRole);

        return user;
    }

    @Override
    public User createAdmin(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        User user1 =  userRepository.save(user);

        UserRole userRole = new UserRole();
        userRole.setRoleName("ROLE_ADMIN");
        userRole.setUser(user1);
        userRoleService.create(userRole);
        return user1;
    }


    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public String getToken(LoginModel loginModel) {
        User user = getByLogin(loginModel.getLogin());
        if(user == null) return "Error";
        String rawPassword = loginModel.getPassword();
        String encodedPassword = user.getPassword();
        if(passwordEncoder.matches(rawPassword, encodedPassword)){
            String loginPasswordPair = user.getLogin() + ":" + loginModel.getPassword();
            String token = Base64.getEncoder().encodeToString(loginPasswordPair.getBytes());
            return "Basic " + token;
        }
        return "Error";
    }

    @Override
    public User getByLogin(String login) {
        return userRepository.findByLogin(login).orElse(null);
    }

    @Override
    public User createUserByAdmin(String name, RegistrationModel registrationModel) {
        User user = new User();
        User admin = userRepository.getByLogin(name);
        String encodedPassword = passwordEncoder.encode(registrationModel.getPassword());
        user.setPassword(encodedPassword);
        user.setLogin(registrationModel.getLogin());
        user.setStatus(1);
        userRepository.save(user);

        UserRole userRole = new UserRole();
        userRole.setRoleName("ROLE_USER");
        userRole.setUser(user);
        userRoleService.create(userRole);
        return user;
    }

    @Override
    public User createUserAndUserRole(RegistrationModel registrationModel, Long id) {
        Random rd = new Random();
        User user = new User();
        String encodedPassword = passwordEncoder.encode(registrationModel.getPassword());
        user.setPassword(encodedPassword);
        user.setLogin(registrationModel.getLogin());
        userRepository.save(user);

        UserRole userRole = new UserRole();
        userRole.setRoleName("ROLE_ADMIN");
        userRole.setUser(user);
        userRoleService.create(userRole);
        return user;
    }
    @Override
    public User update(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User deleteById(Long id) {
        User user = getById(id);
        userRepository.delete(user);
        return user;
    }
}
