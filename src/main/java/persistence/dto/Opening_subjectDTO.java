package persistence.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString

public class Opening_subjectDTO {
    private int opening_subject_id;
    private int subject_id;
    private int registered;
    private String professor_id;
    private LocalDateTime syllabus_write_start;
    private LocalDateTime syllabus_write_close;
    private LocalDateTime register_start;
    private LocalDateTime register_close;
    private int capacity;
    private int subject_room_id;
}
