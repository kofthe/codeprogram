package mehmetari.codeprogram.business.abstracts;

import mehmetari.codeprogram.entity.User;

public interface UserService {

    User add(User user);

    void deleteById(int id);



}
