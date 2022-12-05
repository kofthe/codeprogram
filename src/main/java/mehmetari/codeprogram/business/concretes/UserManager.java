package mehmetari.codeprogram.business.concretes;

import mehmetari.codeprogram.business.abstracts.UserService;
import mehmetari.codeprogram.entity.User;
import mehmetari.codeprogram.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class UserManager implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(int id) {
        if (id == 0 || id < 0) {
            return;
        } else {
            userRepository.deleteById(id);
        }
    }
}
