package mehmetari.codeprogram.entity;

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
    private String email;

    @Size(min = 2, message = "İki karakterden fazla girilmelidir.")
    private String password;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Question> questionList;

}
