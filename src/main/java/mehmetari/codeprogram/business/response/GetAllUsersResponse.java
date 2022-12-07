package mehmetari.codeprogram.business.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mehmetari.codeprogram.entity.Question;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllUsersResponse {


    private String email;

    private List<Question> questionList;


}
