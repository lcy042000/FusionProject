package persistence.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class StudentDTO extends UserDTO{
    private long user_id;
    private String student_id;
    private int department_id;
    private int grade;
}
