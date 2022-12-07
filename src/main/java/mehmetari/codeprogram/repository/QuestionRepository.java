package mehmetari.codeprogram.repository;

import mehmetari.codeprogram.entity.Question;
import mehmetari.codeprogram.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer> {

    void findByUserAndTitle(User user, String title);

}
