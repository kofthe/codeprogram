package mehmetari.codeprogram.entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegularUser extends User{
    @Size(min = 2)
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;

    @Past(message = "Doğum günü geçmiş zaman olmalıdır.")
    private LocalDate birthdate;

}
