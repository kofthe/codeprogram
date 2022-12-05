package mehmetari.codeprogram.business.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mehmetari.codeprogram.entity.User;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllQuestionsResponse {

    private String title;
    private String email;

}
