package kg.elibrary.demo.service;

import kg.elibrary.demo.entity.User;
import kg.elibrary.demo.model.UserAuthModel;
import kg.elibrary.demo.model.UserCreateModel;

import java.util.List;

public interface UserService {
    User create(UserCreateModel user);
    User createAdmin(User user);
    User getById(Long id);
    List<User> getAll();
    String getToken(UserAuthModel userAuthModel);
    User getByLogin(String login);
}
