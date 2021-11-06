package persistence.mapper;

import org.apache.ibatis.annotations.*;
import persistence.dto.Opening_subjectDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface Opening_subjectMapper {
    @SelectProvider(type = persistence.mapper.Opening_subjectSql.class, method = "selectAll")
    @Results(id="opening_subjectResultSet", value = {
            @Result(property = "opening_subject_id", column = "opening_subject_id"),
            @Result(property = "subject_id", column = "subject_id"),
            @Result(property = "registered", column = "registered"),
            @Result(property = "professor_id", column = "professor_id"),
            @Result(property = "syllabus_write_start", column = "syllabus_write_start"),
            @Result(property = "syllabus_write_close", column = "syllabus_write_close"),
            @Result(property = "register_start", column = "register_start"),
            @Result(property = "register_close", column = "register_close"),
            @Result(property = "capacity", column = "capacity"),
            @Result(property = "subject_room_id", column = "subject_room_id")
    })
    List<Opening_subjectDTO> selectAll();

    @UpdateProvider(type = persistence.mapper.Opening_subjectSql.class, method = "updateRegisterStartClose")
    void updateNewRegisterTime(@Param("subject_id") int subject_id, @Param("register_start") LocalDateTime register_start, @Param("register_close") LocalDateTime register_close);
}