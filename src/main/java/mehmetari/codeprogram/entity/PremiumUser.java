package mehmetari.codeprogram.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class PremiumUser extends  User{
    @NotBlank
    private String phoneNumber;
    @Size(min = 2)
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @Past(message = "Doğum günü geçmiş zaman olmalıdır.")
    private LocalDate birthYear;

}
