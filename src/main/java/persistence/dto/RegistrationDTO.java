package persistence.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class RegistrationDTO {
    private int registraion_id;
    private int opening_subject_id;
    private String student_id;
}
