package kg.elibrary.demo.boot;

import kg.elibrary.demo.service.UserRoleService;
import kg.elibrary.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class Boot implements CommandLineRunner {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;

    @Override
    public void run(String... args) throws Exception {
//        userRoleService.create(UserRole.builder().role("ROLE_USER").build());
//        userRoleService.create(UserRole.builder().role("ROLE_ADMIN").build());
//        userService.create(new User("user", "1234", 30, "Some User"));
//        userService.create(new User("usr2", "qwerty", 50, "Qwerty zxcv"));
//        userService.create(new User("user3", "1234", 22, "Lorem ipsum"));
//        userService.create(User.builder()
//                .login("admin")
//                .password("12345")
//                .userRole(userRoleService.getById(2L))
//                .build());
    }
}
