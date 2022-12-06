package mehmetari.codeprogram.business.concretes;

import mehmetari.codeprogram.business.abstracts.UserService;
import mehmetari.codeprogram.business.request.user.CreateUserRequest;
import mehmetari.codeprogram.business.response.GetUserResponse;
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
    public CreateUserRequest add(CreateUserRequest createUserRequest) {
        User user = new User();
        user.setEmail(createUserRequest.getEmail());
        user.setPassword(createUserRequest.getPassword());
        this.userRepository.save(user);
        return createUserRequest;
    }

    @Override
    public GetUserResponse findById(int id) {
        User user = userRepository.findById(id).get();
        GetUserResponse getUserResponse = new GetUserResponse();
        getUserResponse.setEmail(user.getEmail());
        return getUserResponse;
    }

    @Override
    public void deleteById(int id) throws Exception {
            if (isIdExists(id)) {
               throw new Exception("ID Mevcut Değil.");
            }
            userRepository.deleteById(id);

    }

    public boolean isIdExists(int id){
        for (User user : userRepository.findAll()) {
            if (user.getId() == id) return true;
        }
        return false;
    }

    public boolean isEmailExists(String email){
        for (User user : userRepository.findAll()) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }


}
