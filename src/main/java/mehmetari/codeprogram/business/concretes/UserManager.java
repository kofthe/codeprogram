package mehmetari.codeprogram.business.concretes;

import mehmetari.codeprogram.business.abstracts.UserService;
import mehmetari.codeprogram.business.request.user.CreateUserRequest;

import mehmetari.codeprogram.business.request.user.UpdateUserRequest;
import mehmetari.codeprogram.business.response.GetAllUsersResponse;
import mehmetari.codeprogram.business.response.GetUserResponse;

import mehmetari.codeprogram.entity.User;
import mehmetari.codeprogram.repository.QuestionRepository;
import mehmetari.codeprogram.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserManager implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Override
    public User add(CreateUserRequest createUserRequest) {
        User user = new User();

        user.setEmail(createUserRequest.getEmail());
        user.setPassword(createUserRequest.getPassword());

        return this.userRepository.save(user);
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

    @Override
    public List<GetAllUsersResponse> getAll() {
        List<User> userList = userRepository.findAll();
        List<GetAllUsersResponse> getAllUsersResponses = new ArrayList<>();
        for (User user : userList) {
            GetAllUsersResponse getAllUsersResponse = new GetAllUsersResponse();
            getAllUsersResponse.setEmail(user.getEmail());

        }
        return getAllUsersResponses;
    }

    @Override
    public User update(UpdateUserRequest updateUserRequest, int id) {
        isIdExists(id);
        User user2 = userRepository.findById(id).get();

            User user1 = new User();
            user1.setEmail(updateUserRequest.getEmail());
            user1.setPassword(updateUserRequest.getPassword());
            userRepository.save(user1);

    return user2;
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
