package persistence.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class ProfessorDTO extends UserDTO{
    private long user_id;
    private String professor_id;
    private int department_id;
}
