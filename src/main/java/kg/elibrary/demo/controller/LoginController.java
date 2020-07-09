package kg.elibrary.demo.controller;

import kg.elibrary.demo.entity.User;
import kg.elibrary.demo.model.LoginModel;
import kg.elibrary.demo.model.RegistrationModel;
import kg.elibrary.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/auth")
    public ResponseEntity<String> getToken(@RequestBody LoginModel loginModel) {
        String result = userService.getToken(loginModel);
        if (result.equals("Error")) return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/registration")
    public ResponseEntity<String> createAccount(@RequestBody RegistrationModel registrationModel) {
        User user = new User();
        User user1 = userService.create(user);
        Long id = user1.getId();
        userService.createUserAndUserRole(registrationModel, id);
        if (user == null){
            return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("User has been successfully created!", HttpStatus.OK);
    }

    @PostMapping("/registration/user")
    public ResponseEntity<String> createNewUser(@RequestBody RegistrationModel registrationModel, Principal principal) {
        String login = principal.getName();
        User user = userService.createUserByAdmin(login, registrationModel);
        if (user == null){
            return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("User has been successfully created!", HttpStatus.OK);
    }

}
