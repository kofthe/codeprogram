package mehmetari.codeprogram.business.abstracts;

import mehmetari.codeprogram.business.request.user.CreateUserRequest;
import mehmetari.codeprogram.business.request.user.UpdateUserRequest;
import mehmetari.codeprogram.business.response.GetAllUsersResponse;
import mehmetari.codeprogram.business.response.GetUserResponse;
import mehmetari.codeprogram.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User add(CreateUserRequest createUserRequest);

    GetUserResponse findById(int id);

    void deleteById(int id) throws Exception;

    List<GetAllUsersResponse> getAll();

    User update(UpdateUserRequest updateUserRequest, int id);


}
