package mehmetari.codeprogram.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;

    private String description;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id")
    private User user;


}
