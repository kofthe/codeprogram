package mehmetari.codeprogram.webapi.controller;

import mehmetari.codeprogram.business.abstracts.UserService;
import mehmetari.codeprogram.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    private MessageSource messageSource;

    @PostMapping(path = "/add", params = "version1")
    public User add(User user) {
        return userService.add(user);
    }

    @GetMapping("/helloworldint")
    public String helloworld(){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "Default Message", locale);

    }



}
