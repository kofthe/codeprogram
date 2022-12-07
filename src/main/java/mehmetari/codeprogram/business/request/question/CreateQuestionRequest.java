package mehmetari.codeprogram.business.request.question;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mehmetari.codeprogram.entity.User;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateQuestionRequest {

    private String title;
    private String description;
    private int userId;


}
