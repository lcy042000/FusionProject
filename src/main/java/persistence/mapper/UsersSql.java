package persistence.mapper;

import org.apache.ibatis.jdbc.SQL;

public class UsersSql {
    public String selectUser(){
        SQL sql = new SQL(){{
            SELECT("*");
            FROM("USERS");
        }};
        return sql.toString();
    }
}
