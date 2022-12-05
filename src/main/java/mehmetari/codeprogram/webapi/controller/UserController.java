package mehmetari.codeprogram.webapi.controller;

import mehmetari.codeprogram.business.abstracts.UserService;
import mehmetari.codeprogram.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/add")
    public User add(User user) {
        return userService.add(user);
    }




}
