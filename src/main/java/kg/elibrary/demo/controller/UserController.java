package kg.elibrary.demo.controller;

import kg.elibrary.demo.entity.User;
import kg.elibrary.demo.model.UserAuthModel;
import kg.elibrary.demo.model.UserChangePassModel;
import kg.elibrary.demo.model.UserCreateModel;
import kg.elibrary.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/test/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id){
        return userService.getById(id);
    }

    @PostMapping
    public User create(@RequestBody UserCreateModel user){
        return userService.create(user);
    }

    @PostMapping("/auth")
    public ResponseEntity<String> getToken(@RequestBody UserAuthModel userAuthModel) {
        String result = userService.getToken(userAuthModel);
        if (result.equals("Error")) return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @GetMapping("/check")
    public User getByToken(Principal principal) {
        String login = principal.getName();
        return userService.getByLogin(login);
    }

    @PostMapping("/admin")
    public User create(@RequestBody User user) { return userService.createAdmin(user); }

    @PutMapping("/admin")
    public User changePassword(@RequestBody UserChangePassModel req, Principal principal){
        String login = principal.getName();
        User user = userService.getByLogin(login);
        user.setPassword(req.getPass());
        return userService.createAdmin(user);
    }
}
