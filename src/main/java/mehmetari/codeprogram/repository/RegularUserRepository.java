package mehmetari.codeprogram.repository;

import mehmetari.codeprogram.entity.RegularUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegularUserRepository extends JpaRepository<RegularUser, Integer> {
}
