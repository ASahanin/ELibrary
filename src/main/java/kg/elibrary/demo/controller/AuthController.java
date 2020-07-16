package kg.elibrary.demo.controller;

import kg.elibrary.demo.entity.User;
import kg.elibrary.demo.model.UserAuthRequest;
import kg.elibrary.demo.service.UserService;
import kg.elibrary.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;

@RestController
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String sayHello(Principal principal) {
        return "Hello, " + principal.getName();
    }

    @PostMapping("/registration")
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @PostMapping("/auth")
    public String getToken(@RequestBody UserAuthRequest user) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getLogin(), user.getPassword()));
        } catch (Exception e) {
            throw new Exception("Auth failed");
        }
        return jwtUtil.generateToken(user.getLogin());
    }
}
