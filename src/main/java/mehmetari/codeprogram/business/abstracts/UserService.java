package mehmetari.codeprogram.business.abstracts;

import mehmetari.codeprogram.business.request.user.CreateUserRequest;
import mehmetari.codeprogram.business.response.GetUserResponse;
import mehmetari.codeprogram.entity.User;

public interface UserService {

    CreateUserRequest add(CreateUserRequest createUserRequest);

    GetUserResponse findById(int id);

    void deleteById(int id) throws Exception;



}
