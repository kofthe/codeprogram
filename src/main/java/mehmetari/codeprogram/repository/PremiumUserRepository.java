package mehmetari.codeprogram.repository;

import mehmetari.codeprogram.entity.PremiumUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PremiumUserRepository extends JpaRepository<PremiumUser, Integer> {
}
