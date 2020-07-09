package kg.elibrary.demo.service;

import kg.elibrary.demo.entity.User;
import kg.elibrary.demo.model.LoginModel;
import kg.elibrary.demo.model.RegistrationModel;

import java.util.List;

public interface UserService {
    User create(User user);
    User createAdmin(User user);
    User getById(Long id);
    List<User> getAll();
    String getToken(LoginModel userAuthModel);
    User getByLogin(String login);
    User createUserByAdmin(String name, RegistrationModel registrationModel);
    User createUserAndUserRole(RegistrationModel registrationModel, Long id);
}
