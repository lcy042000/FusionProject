package persistence.mapper;

import org.apache.ibatis.annotations.*;
import persistence.dto.UserDTO;

import java.util.List;

public interface UsersMapper {
    final String getAll = "SELECT * FROM USERS";

    @Select(getAll)
    @Results(id="userResultSet", value = {
            @Result(property = "user_id", column = "User_id"),
            @Result(property = "name", column = "Name"),
            @Result(property = "password", column = "Password")
    })
    List<UserDTO> getAll();

//    @SelectProvider(type = persistence.mapper.UsersSql.class, method = "selectUser")
//    @ResultMap("userResultSet")
//    List<UsersDTO> selectUser();
}
