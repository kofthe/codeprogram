package mehmetari.codeprogram.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Email
    @JsonProperty("E-Mail")
    private String email;

    @Size(min = 2, message = "İki karakterden fazla girilmelidir.")
    @JsonProperty("Sifre")
    private String password;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Question> questionList;

}
