package persistence.mapper;

import org.apache.ibatis.annotations.*;
import persistence.dto.SubjectDTO;

import java.util.List;

public interface SubjectMapper {
//    @SelectProvider(type = persistence.mapper.SubjectSql.class, method = "selectByTargetGrade")
//    @Results(id="subjectResultSet", value = {
//            @Result(property = "id", column = "subject_id"),
//            @Result(property = "subjectName", column = "subject_name"),
//            @Result(property = "targetGrade", column = "target_grade"),
//            @Result(property = "semester", column = "semester"),
//            @Result(property = "credit", column = "credit")
//    })
//    List<Integer> selectByTargetGrade(int target_grade);
//
//    @SelectProvider(type = persistence.mapper.SubjectSql.class, method = "selectBySubjectName")
//    @ResultMap("subjectResultSet")
//    List<Integer> selectBySubjectName(String subjectName);
}