package persistence.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import persistence.dto.DepartmentDTO;

import java.util.List;

public class DepartmentDAO {
    private SqlSessionFactory sqlSessionFactory = null;

    public DepartmentDAO(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public List<DepartmentDTO> selectAll(){
        List<DepartmentDTO> list = null;
        SqlSession session = sqlSessionFactory.openSession();
        try{
            list = session.selectList("mapper.DepartmentMapper.selectAll");
        } finally {
            session.close();
        }
        return list;
    }
}
