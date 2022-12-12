package mehmetari.codeprogram.webapi.controller;

import mehmetari.codeprogram.business.abstracts.UserService;
import mehmetari.codeprogram.business.request.user.CreateUserRequest;
import mehmetari.codeprogram.business.request.user.UpdateUserRequest;
import mehmetari.codeprogram.business.response.GetAllUsersResponse;
import mehmetari.codeprogram.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;
import java.util.Objects;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    private MessageSource messageSource;

    @PostMapping(path = "/add")
    public ResponseEntity<User> add(@RequestBody CreateUserRequest createUserRequest) {
        return new ResponseEntity<>(userService.add(createUserRequest), HttpStatus.OK) ;
    }

    @GetMapping("/helloworldint")
    public String helloworld(){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "Default Message", locale);

    }

    @GetMapping("/listusers")
    public ResponseEntity<List<GetAllUsersResponse>> getAll(){
        return  new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<User> update(@RequestBody UpdateUserRequest updateUserRequest,@PathVariable int id){
        User user = userService.update(updateUserRequest, id);
       if (Objects.nonNull(updateUserRequest)) {
           return new ResponseEntity<>(user, HttpStatus.OK);
       }
       return ResponseEntity.noContent().build();
    }


}
