package persistence.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import java.time.LocalDateTime;

public class Opening_subjectSql {
    public String updateRegisterStartClose() {
        SQL sql = new SQL() {{
            UPDATE("opening_subjects");
            SET("register_start=#{register_start}", "register_close=#{register_close}");
            WHERE("subject_id=#{subject_id}");
        }};
        return sql.toString();
    }

    public String selectAll() {
        SQL sql = new SQL() {{
            SELECT("*");
            FROM("opening_subjects");
        }};
        return sql.toString();
    }
}